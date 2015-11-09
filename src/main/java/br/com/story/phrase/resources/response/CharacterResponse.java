package br.com.story.phrase.resources.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.story.phrase.model.Character;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CharacterResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public CharacterResponse() {}
	
	@XmlElement(name="id")
	private Long id;
	
	@XmlElement(name="name")
	private String name;
	
	@XmlElement(name="wordCounts")
	private List<WordResponse> words;


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<WordResponse> getWords() {
		return words;
	}
	public void setWords(List<WordResponse> words) {
		this.words = words;
	}
	
	public static CharacterResponse transform(Character character) {
		CharacterResponse response = new CharacterResponse();
		response.setId(character.getIdCharacter());
		response.setName(character.getName());
		response.setWords(WordResponse.transform(character.getWords()));
		return response;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CharacterResponse other = (CharacterResponse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Character [id=" + id + ", name=" + name + "]";
	}
	public static List<CharacterResponse> transform(Collection<Character> characters) {
		List<CharacterResponse> charactersResponse = new ArrayList<>();
		for (Character character : characters) {
			charactersResponse.add(transform(character));
		}
		return charactersResponse;
	}
	
}

