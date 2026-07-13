package com.bibliotecaCentral.modules.bibliotecaCompany.dto;

import lombok.Data;

@Data
public class CreateLivroDTO {

    private String titulo;
    private String autor;
    private String isbn;
    private String quantidadeTotal;
    private String quantidadeDisponivel;
}
