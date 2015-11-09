package br.com.story.phrase.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "movie_setting")
public class MovieSetting {

	@Id
	@GeneratedValue
	private Long idMovieSetting;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "movieSetting")
	private Set<Character> characters = new HashSet<Character>();

	public MovieSetting() {
	}
	
	public MovieSetting(String name) {
		this.name = name;
	}

	public Long getIdMovieSetting() {
		return idMovieSetting;
	}

	public void setIdMovieSetting(Long id) {
		this.idMovieSetting = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Character> getCharacters() {
		return characters;
	}

	public void setCharacters(Set<Character> characters) {
		this.characters = characters;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMovieSetting == null) ? 0 : idMovieSetting.hashCode());
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
		MovieSetting other = (MovieSetting) obj;
		if (idMovieSetting == null) {
			if (other.idMovieSetting != null)
				return false;
		} else if (!idMovieSetting.equals(other.idMovieSetting))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString() {
		return String.format("Movie Setting Name [%s]", this.name);
	}
}
