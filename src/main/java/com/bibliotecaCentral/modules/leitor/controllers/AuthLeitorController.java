package com.bibliotecaCentral.modules.leitor.controllers;

import com.bibliotecaCentral.modules.leitor.AuthLeitorRequestDTO;
import com.bibliotecaCentral.modules.leitor.useCases.AuthLeitorUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/leitor")
public class AuthLeitorController {

    @Autowired
    private AuthLeitorUseCase authLeitorUseCase;

    @PostMapping("/auth")
    public ResponseEntity<Object> auth(@RequestBody AuthLeitorRequestDTO authLeitorRequestDTO) {

        try {
            var token = this.authLeitorUseCase.execute(authLeitorRequestDTO);
            return ResponseEntity.ok().body(token);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}
