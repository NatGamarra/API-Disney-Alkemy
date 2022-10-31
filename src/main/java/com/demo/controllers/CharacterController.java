package com.demo.controllers;
import com.demo.entities.Character;
import com.demo.exceptions.RequestException;
import com.demo.service.ICharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value ="/characters")
@RestController
public class CharacterController {

    @Autowired
    private ICharacterService iCharacterService;

    //Obtener todos los personajes
    @GetMapping()
    public ResponseEntity<?> getCharacters() {
        return new ResponseEntity<>(iCharacterService.getCharacters(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAllCharacters(){
        return new ResponseEntity<>(iCharacterService.findAllCharacters(), HttpStatus.OK);
    }

    //Buscar personaje por id
    @GetMapping("/character/{id}")
    public ResponseEntity<?> findCharacter(@PathVariable Long id) {
        return new ResponseEntity<>(iCharacterService.findById(id), HttpStatus.OK);
    }

    @RequestMapping(value="",params = "name",method = RequestMethod.GET)
    public ResponseEntity<?> findByName(@RequestParam String name){
        return new ResponseEntity<>(iCharacterService.findByName(name), HttpStatus.OK);
    }

    @RequestMapping(value="",params = "age",method = RequestMethod.GET)
    public ResponseEntity<?> findByAge(@RequestParam int age){
        return new ResponseEntity<>(iCharacterService.findByAge(age), HttpStatus.OK);
    }

    //Crear un personaje

    @PostMapping("/save")
    public ResponseEntity<?> saveCharacter(@RequestBody Character character) {
        iCharacterService.saveCharacter(character);
        if(character.getName().equals("") || character.getName() == null){
            throw new RequestException("Name is required","500");
        }
        return new ResponseEntity<>(character, HttpStatus.CREATED);
    }


    //Eliminar un personaje
    @DeleteMapping("/{idCharacter}")
    public ResponseEntity<?> deleteCharacter(@PathVariable Long idCharacter) {
        iCharacterService.deleteCharacter(idCharacter);
        return new ResponseEntity<>("Eliminado con exito", HttpStatus.OK);
    }

    //Editar un personaje
    @PutMapping("/edit")
    public ResponseEntity<?> editCharacter(@RequestBody Character character){
         iCharacterService.editCharacter(character);
        return new ResponseEntity<>(iCharacterService.findById(character.getId()),HttpStatus.OK);
    }



}
