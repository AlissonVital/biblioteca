package com.bibliotecaCentral.modules.leitor.controllers;

import com.bibliotecaCentral.modules.leitor.LeitorEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leitor")
public class LeitorController {

    @PostMapping("/")
    public void create(@Valid @RequestBody LeitorEntity leitorEntity) {
        System.out.println("Leitor");
        System.out.println(leitorEntity.getUsername());
        System.out.println(leitorEntity.getName());
        System.out.println(leitorEntity.getEmail());
        System.out.println(leitorEntity.getPassword());
        System.out.println(leitorEntity.getDataCadastro());
    }
}
