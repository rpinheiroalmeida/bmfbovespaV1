package br.com.story.phrase.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name =  "script")
public class Script implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Lob
	@Column(name = "name", nullable = false)
	private String content;
	
	@Column(name = "path_file", nullable = false)
	private String pathFile;

	public Script() {}
	
	public Script(String content) {
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String pathFile) {
		this.content = pathFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public String toString() {
		return String.format("Script: Id(%d), Name(%s)", this.id, this.content);
	}
}
