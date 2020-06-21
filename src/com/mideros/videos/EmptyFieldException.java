package com.mideros.videos;

/**
 * This class extends the class Exception and its subclasses are a form of
 * Throwable; the exception is thrown when the field is empty.
 * 
 * @author Yohanna Mideros Giraldo
 * @version 1.0
 * 
 */
public class EmptyFieldException extends Exception {

	private static final long serialVersionUID = 1L;

	public EmptyFieldException() {
	}

	@Override
	public void printStackTrace() {

		System.out.println("The field is empty, try again");
	}
}
