package br.com.story.phrase.errorhandling;

public class AppException extends Exception {

	private static final long serialVersionUID = -8999932578270387947L;
	
	public AppException(String message) {
		super(message);
	}

	public AppException() { }

}
