package com.bibliotecaCentral.modules.bibliotecaCompany;

import com.bibliotecaCentral.modules.bibliotecaCompany.dto.CreateLivroDTO;
import com.bibliotecaCentral.modules.bibliotecaCompany.entities.LivroEntity;
import com.bibliotecaCentral.modules.bibliotecaCompany.useCases.CreateLivroUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/bibliotecaCompany/livro")
public class LivroController {

    @Autowired
    private CreateLivroUseCase createLivroUseCase;

    @PostMapping({"", "/"})
    @PreAuthorize("hasRole('BIBLIOTECACOMPANY')")
    public ResponseEntity<Object> create(@RequestBody @Valid CreateLivroDTO createLivroDTO, HttpServletRequest request) {
        try {
            var bibliotecaCompanyId = request.getAttribute("bibliotecaCompany_id");

            var livroEntity = LivroEntity.builder()
                    .bibliotecaId(UUID.fromString(bibliotecaCompanyId.toString()))
                    .titulo(createLivroDTO.getTitulo())
                    .autor(createLivroDTO.getAutor())
                    .isbn(createLivroDTO.getIsbn())
                    .quantidadeTotal(createLivroDTO.getQuantidadeTotal())
                    .quantidadeDisponivel(createLivroDTO.getQuantidadeDisponivel())
                    .build();

            var result = this.createLivroUseCase.execute(livroEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
