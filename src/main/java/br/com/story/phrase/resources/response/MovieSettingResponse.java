package br.com.story.phrase.resources.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.story.phrase.model.MovieSetting;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieSettingResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public MovieSettingResponse() {}
	
	@XmlElement(name="id")
	private Long id;
	
	@XmlElement(name="name")
	private String name;

	@XmlElement(name="characters")
	private List<CharacterResponse> characters;

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
	
	public List<CharacterResponse> getCharacters() {
		return characters;
	}
	public void setCharacters(List<CharacterResponse> characters) {
		this.characters = characters;
	}
	public static MovieSettingResponse transform(MovieSetting movieSetting) {
		MovieSettingResponse response = new MovieSettingResponse();
		response.setId(movieSetting.getIdMovieSetting());
		response.setName(movieSetting.getName());
		response.setCharacters(CharacterResponse.transform(movieSetting.getCharacters()));
		return response;
	}
	
	public static List<MovieSettingResponse> transform(List<MovieSetting> settings) {
		List<MovieSettingResponse> settingsResponse = new ArrayList<>();
		for (MovieSetting movieSetting : settings) {
			settingsResponse.add(transform(movieSetting));
		}
		return settingsResponse;
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
		MovieSettingResponse other = (MovieSettingResponse) obj;
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
		return "MovieSettingResponse [id=" + id + ", name=" + name + "]";
	}
	
	
}
