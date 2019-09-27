package com.example.demo.exception;


public class InvalidJwtAuthenticationException extends RuntimeException
{

    private static final long serialVersionUID = 1243934594818324912L;


    public InvalidJwtAuthenticationException(String message)
    {
        super(message);
    }
}
