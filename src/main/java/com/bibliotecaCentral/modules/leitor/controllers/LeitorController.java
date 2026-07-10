package com.bibliotecaCentral.modules.leitor.controllers;

import com.bibliotecaCentral.modules.bibliotecaCompany.useCases.ProfileLeitorUseCase;
import com.bibliotecaCentral.modules.leitor.LeitorEntity;
import com.bibliotecaCentral.modules.leitor.useCases.CreateLeitorUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/leitor")
public class LeitorController {

    @Autowired
    private CreateLeitorUseCase createLeitorUseCase;

    @Autowired
    private ProfileLeitorUseCase profileLeitorUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody LeitorEntity leitorEntity) {
        try {
            var result = this.createLeitorUseCase.execute(leitorEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('leitor')")
    public ResponseEntity<Object> get(HttpServletRequest request) {

        var idLeitor = request.getAttribute("leitor_id");
        try {
            var profile = this.profileLeitorUseCase.execute(UUID.fromString(idLeitor.toString()));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
