package com.demo.security.service;
import com.demo.security.entities.Rol;
import com.demo.security.entities.Users;
import com.demo.security.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUsersRepository iUsersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = iUsersRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));
       return new User(users.getUsername(),users.getPassword(),mapRoles(users.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRoles(Set<Rol> roles){
        return roles.stream().map(rol -> new SimpleGrantedAuthority(rol.getName())).collect(Collectors.toList());
    }
}
