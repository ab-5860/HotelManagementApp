package com.lcwd.user.service.exception;

public class ResourceNotFoundException extends RuntimeException{

	
	// extra properties that can be managed
	public ResourceNotFoundException()
	{
		super("Resource not found on server !!");
	}
	
	
	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
