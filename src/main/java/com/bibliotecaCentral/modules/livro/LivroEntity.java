package com.bibliotecaCentral.modules.livro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity(name = "livro")
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    public UUID id;
    public String titulo;
    public String autor;
    public String isbn;
    public String quantidadeTotal;
    public String quantidadeDisponivel;
}
