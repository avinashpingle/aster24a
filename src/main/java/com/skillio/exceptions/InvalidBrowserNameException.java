package com.skillio.exceptions;


public class InvalidBrowserNameException extends RuntimeException{

	private String browserName;
	public InvalidBrowserNameException(String browserName) {
		this.browserName = browserName;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Invalid browser name: "+browserName;
	}
}
