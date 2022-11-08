package com.ct.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class OrderException extends Exception {

	public OrderException() {
		super();
	}

	public OrderException(String message, Throwable cause) {
		super(message, cause);

	}

	public OrderException(String message) {
		super(message);

	}

	public OrderException(Throwable cause) {
		super(cause);
	}
}
