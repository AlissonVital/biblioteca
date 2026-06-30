package com.bibliotecaCentral.modules.leitor.controllers;

import com.bibliotecaCentral.modules.leitor.LeitorEntity;
import com.bibliotecaCentral.modules.leitor.useCases.CreateLeitorUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leitor")
public class LeitorController {

    @Autowired
    private CreateLeitorUseCase createLeitorUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody LeitorEntity leitorEntity) {
        try {
            var result = this.createLeitorUseCase.execute(leitorEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }



    }
}
