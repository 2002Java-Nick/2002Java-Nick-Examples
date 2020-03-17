package com.revature.exception;

public class UserInsertionException extends Exception{

	public UserInsertionException() {
		super();
	}

	public UserInsertionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserInsertionException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserInsertionException(String message) {
		super(message);
	}

	public UserInsertionException(Throwable cause) {
		super(cause);
	}

}
