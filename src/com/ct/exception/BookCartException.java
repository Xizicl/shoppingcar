package com.ct.exception;

public class BookCartException extends Exception {

	public BookCartException() {
		super();
	}

	public BookCartException(String message, Throwable cause) {
		super(message, cause);

	}

	public BookCartException(String message) {
		super(message);

	}

	public BookCartException(Throwable cause) {
		super(cause);
	}
}
