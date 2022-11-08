package com.ct.exception;

public class CartListException extends Exception {
	public CartListException() {       
		super();       
	 }

	public CartListException(String message, Throwable cause) {        
		super(message, cause);     
    }

	public CartListException(String message) {        
		super(message);        
   }

	public CartListException(Throwable cause) {        
		super(cause);        
  }

}
