package com.douzone.mysite.exception;

public class UserRepositoryExcetion extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public UserRepositoryExcetion(String message) {
		super(message);
	}
	public UserRepositoryExcetion() {
		super("예외 발생");
	}
}
