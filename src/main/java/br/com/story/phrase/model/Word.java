package br.com.story.phrase.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name =  "word")
public class Word {

	@Id
	@GeneratedValue
	private Long idWord;
	
	@Column(name = "word", nullable = false)
	private String word;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	private Character character;
	
	@Transient
	private Long count;

	public Word(String word) {
		this.word = word;
	}

	public Word(String word, Character character) {
		this.word = word;
		this.character = character;
	}

	public Long getIdWord() {
		return idWord;
	}

	public void setIdWord(Long id) {
		this.idWord = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String toString() {
		return String.format("Word [%s]", this.word);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((idWord == null) ? 0 : idWord.hashCode());
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		Word other = (Word) obj;
//		if (character == null) {
//			if (other.character != null)
//				return false;
//		} else if (!character.equals(other.character))
//			return false;
		if (idWord == null) {
			if (other.idWord != null)
				return false;
		} else if (!idWord.equals(other.idWord))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}
}
