package com.spring.exception;

public class IdNotFound extends Exception {
	
	String errorMassageString;

	public IdNotFound() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IdNotFound(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public IdNotFound(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public IdNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public IdNotFound(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
