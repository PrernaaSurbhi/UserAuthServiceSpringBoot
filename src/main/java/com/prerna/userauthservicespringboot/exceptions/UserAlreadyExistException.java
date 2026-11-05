package com.prerna.userauthservicespringboot.exceptions;

public class UserAlreadyExistException extends RuntimeException {

    public  UserAlreadyExistException(String message ){
        super(message);
    }

}
