package com.example.jwt.rest.web.exception;

public class UsuarioJaExistenteException extends RuntimeException{


    public UsuarioJaExistenteException(String message) {
        super(message);
    }
}
