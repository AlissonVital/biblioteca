package com.bibliotecaCentral.modules.leitor.controllers;

import com.bibliotecaCentral.exceptions.UserFoundException;
import com.bibliotecaCentral.modules.leitor.LeitorEntity;
import com.bibliotecaCentral.modules.leitor.LeitorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leitor")
public class LeitorController {

    @Autowired
    private LeitorRepository leitorRepository;

    @PostMapping("/")
    public LeitorEntity create(@Valid @RequestBody LeitorEntity leitorEntity) {
        this.leitorRepository
                .findByUsernameOrEmail(leitorEntity.getUsername(), leitorEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
        });
        return this.leitorRepository.save(leitorEntity);
    }
}
