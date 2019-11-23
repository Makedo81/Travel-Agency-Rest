package com.rest.travelagency.exceptions;

public class LoginAlreadyExistsException extends Exception {

    public LoginAlreadyExistsException(final String message) {
        super(message);
    }
}
