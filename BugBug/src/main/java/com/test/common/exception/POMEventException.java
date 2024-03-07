package com.test.common.exception;

public class POMEventException extends Exception
{

 private static final long serialVersionUID = 1L;
    
    public POMEventException(String message)
	{
    	super (message);
	}
    
    public POMEventException(Exception e) 
    {
        super(e);
    }

    public POMEventException(String message, Exception e) 
    {
        super(message, e);
    }
 
}
