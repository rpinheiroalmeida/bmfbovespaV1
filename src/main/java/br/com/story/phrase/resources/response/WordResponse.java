package br.com.story.phrase.resources.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.story.phrase.model.Word;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class WordResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public WordResponse() {}
	
	@XmlElement(name="count")
	private Long count;
	
	@XmlElement(name="word")
	private String word;


	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	public String toString() {
		return String.format("word: %s, count: %d", this.word, this.count);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((count == null) ? 0 : count.hashCode());
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
		WordResponse other = (WordResponse) obj;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	public static List<WordResponse> transform(List<Word> words) {
		List<WordResponse> wordsResponse = new ArrayList<>();
		
		for (Word word : words) {
			wordsResponse.add(transform(word));
		}
		
		return wordsResponse;
	}

	public static WordResponse transform(Word word) {
		WordResponse wordResponse = new WordResponse();
		wordResponse.setWord(word.getWord());
		wordResponse.setCount(word.getCount());
		return wordResponse;
	}
	

	
		
}
