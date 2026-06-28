package com.bibliotecaCentral.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuario já existe!!"); // Chama o construtor da classe pai para mostrar a mensagem
    }
}
