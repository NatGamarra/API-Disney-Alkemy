package com.demo.service;


import com.demo.dto.CharacterDTO;
import com.demo.entities.Character;

import javax.transaction.Transactional;
import java.util.List;

public interface ICharacterService {

    public void saveCharacter(Character character);

    public List<CharacterDTO> getCharacters();

    public Character findById(Long id);

    public void deleteCharacter(Long id);

    public void editCharacter(Character character);

    public List<Character> findByName(String name);

    public List<Character> findByAge(int age);

}
