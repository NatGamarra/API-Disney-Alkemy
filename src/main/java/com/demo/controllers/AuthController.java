package com.demo.controllers;
import com.demo.dto.JwtDTO;
import com.demo.dto.LoginDTO;
import com.demo.dto.NewUserDTO;
import com.demo.entities.Rol;
import com.demo.entities.Users;
import com.demo.repository.IRolRepository;
import com.demo.repository.IUsersRepository;
import com.demo.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IUsersRepository iUsersRepository;

    @Autowired
    private IRolRepository iRolRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    private final PasswordEncoder passwordEncoder;

    public AuthController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //obtenemos el token del jwtTokenProvider
        String token = jwtTokenProvider.generarToken(authentication);

        return ResponseEntity.ok(new JwtDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrarUsuario(@RequestBody NewUserDTO newUserDTO){
        if(iUsersRepository.existsByUsername(newUserDTO.getUsername())) {
            return new ResponseEntity<>("Ese nombre de usuario ya existe", HttpStatus.BAD_REQUEST);
        }
        Users user = new Users();
        user.setUsername(newUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(newUserDTO.getPassword()));

        Rol roles = iRolRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        iUsersRepository.save(user);
        return new ResponseEntity<>("Usuario registrado exitosamente",HttpStatus.OK);
    }
}
