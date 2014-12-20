package it.reti.futureti.testkata.exceptions;

public class ProgramException extends Exception {

	private static final long serialVersionUID = 1633932660089693890L;

	public ProgramException() {
		super();
	}
	
	public ProgramException(String message) {
		super(message);
	}
	
	public ProgramException(String message, Throwable t) {
		super(message, t);
	}
}
