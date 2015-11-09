package br.com.story.phrase.resources.response;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "")
public class ResposeList implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<?> list;
	
	public ResposeList() {	}
	
	public ResposeList(List<?> list) {
		this.list = list;
	}

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
