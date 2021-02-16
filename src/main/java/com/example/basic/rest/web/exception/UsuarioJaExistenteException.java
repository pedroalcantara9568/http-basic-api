package com.example.basic.rest.web.exception;

public class UsuarioJaExistenteException extends RuntimeException{


    public UsuarioJaExistenteException(String message) {
        super(message);
    }
}
