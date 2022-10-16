package com.demo.service;
import com.demo.dto.CharacterDTO;
import com.demo.entities.Character;
import com.demo.repository.ICharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterService implements ICharacterService {

    @Autowired
    private ICharacterRepository iCharacterRepository;

    @Override
    public void saveCharacter(Character character) {
        iCharacterRepository.save(character);
    }

    @Override
    public List<CharacterDTO> getCharacters() {
       List<Character> characters = iCharacterRepository.findAll();
       List<CharacterDTO> characterDTOS = new ArrayList<CharacterDTO>();
       CharacterDTO characterDTO = new CharacterDTO();

       for (Character character : characters){
           characterDTO.setImage(character.getImage());
           characterDTO.setName(character.getName());

           characterDTOS.add(characterDTO);
           characterDTO = new CharacterDTO();
       }

        return characterDTOS;
    }

    @Override
    public Character findById(Long id) {
        return iCharacterRepository.findById(id).get();
    }

    @Override
    public void deleteCharacter(Long id) {
        iCharacterRepository.deleteById(id);
    }

    @Override
    public void editCharacter(Character character) {
        this.saveCharacter(character);
    }

    @Override
    public List<Character> findByName(String name) {
        return iCharacterRepository.findByName(name);
    }

    @Override
    public List<Character> findByAge(int age) {
        return iCharacterRepository.findByAge(age);
    }

}
