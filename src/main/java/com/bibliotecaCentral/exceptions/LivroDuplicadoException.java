package com.bibliotecaCentral.exceptions;

public class LivroDuplicadoException extends RuntimeException {
    public LivroDuplicadoException() {
        super("Este livro já existe na base de cadastro!!! não é permitido duplicidade!");
    }
}
