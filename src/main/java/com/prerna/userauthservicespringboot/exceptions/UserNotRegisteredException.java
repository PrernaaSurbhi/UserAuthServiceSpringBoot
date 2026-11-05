package com.prerna.userauthservicespringboot.exceptions;

public class UserNotRegisteredException extends RuntimeException{

    public UserNotRegisteredException(String message){
        super(message);
    }

}
