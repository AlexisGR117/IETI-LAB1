package edu.eci.ieti.lab1.exception;

import org.springframework.web.server.ServerErrorException;

public class InvalidCredentialsException extends ServerErrorException {

    public InvalidCredentialsException() {
        super("invalid username or password");
    }
}
