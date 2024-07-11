package com.skillstorm.pojos;

/*
 * Custom exceptions must inherit from Throwable or a subtype of Throwable
 */
public class ImpossiblePotatoException extends Exception {
	
	public ImpossiblePotatoException() { }

	public ImpossiblePotatoException(String message) {
		super(message);
	}
	
	public ImpossiblePotatoException(String message, Throwable cause) {
		super(message, cause);
	}
}
