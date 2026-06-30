package com.bibliotecaCentral.modules.leitor.controllers;

import com.bibliotecaCentral.modules.bibliotecaCompany.entities.LivroEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PostMapping("/")
    public void create(@RequestBody LivroEntity livroEntity) {
        System.out.println("Livros: ");
        System.out.println(livroEntity.getTitulo());
        System.out.println(livroEntity.getAutor());
    }

}
