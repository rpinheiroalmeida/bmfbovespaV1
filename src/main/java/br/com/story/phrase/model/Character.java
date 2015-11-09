package br.com.story.phrase.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name =  "character")
public class Character implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idCharacter;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMovieSetting", nullable = false)
	private MovieSetting movieSetting;
	
	@OneToMany(cascade={CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "character")
	private List<Word> words = new ArrayList<>();

	public Character() {
	}
	
	public Character(String name) {
		this.name = name;
	}

	public Long getIdCharacter() {
		return idCharacter;
	}

	public void setIdcharacter(Long id) {
		this.idCharacter = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MovieSetting getMovieSetting() {
		return movieSetting;
	}

	public void setMovieSetting(MovieSetting movieSetting) {
		this.movieSetting = movieSetting;
	}
	
	public List<Word> getWords() {
		return words;
	}

	public void setWords(List<Word> words) {
		this.words = words;
	}

	public String toString() {
		return String.format("Character Name[%s], Words (%s)", this.name, this.words != null ? this.words.toString() : "");
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCharacter == null) ? 0 : idCharacter.hashCode());
		result = prime * result + ((movieSetting == null) ? 0 : movieSetting.hashCode());
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
		Character other = (Character) obj;
		if (idCharacter == null) {
			if (other.idCharacter != null)
				return false;
		} else if (!idCharacter.equals(other.idCharacter))
			return false;
		if (movieSetting == null) {
			if (other.movieSetting != null)
				return false;
		} else if (!movieSetting.equals(other.movieSetting))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
