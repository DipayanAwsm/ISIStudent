package com.dipayan;

public class HelloWorld {
	private String message;

	public String getMessage() {
		System.out.println("Hello World:"+this.message);
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
