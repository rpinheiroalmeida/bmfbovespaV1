package br.com.story.phrase.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.story.phrase.dao.CharacterDaoImpl;
import br.com.story.phrase.model.Character;

@Service
public class CharacterService {

	public CharacterService() {}

	@Autowired
	private CharacterDaoImpl characterDao;
	
	public void loadWords(Collection<Character> characters) {
		for (Character character : characters) {
			System.out.println("Load Words Character: " + character.getIdCharacter() + " - " + character.getName());
//			character.setWords(characterDao.findWordsCharacter(character.getIdCharacter()));
			loadWord(character);
		}
	}
	
	public void loadWord(Character character) {
		character.setWords(characterDao.findWordsCharacter(character.getIdCharacter()));
	}
	
	public List<Character> list() {
		List<Character> characters = characterDao.list();
		loadWords(characters);
		
		return characters;
	}
	
	public Character findById(Long id) {
		Character character = characterDao.findById(id);
		loadWord(character);
		return character;
	}

	public void shutdown() {
		characterDao.shutdown();
	}

	public CharacterDaoImpl getCharacterDao() {
		return characterDao;
	}

	public void setCharacterDao(CharacterDaoImpl characterDao) {
		this.characterDao = characterDao;
	}
	


}
