package com.bibliotecaCentral.modules.bibliotecaCompany;

import com.bibliotecaCentral.modules.bibliotecaCompany.dto.CreateLivroDTO;
import com.bibliotecaCentral.modules.bibliotecaCompany.entities.LivroEntity;
import com.bibliotecaCentral.modules.bibliotecaCompany.useCases.CreateLivroUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    public LivroEntity create(@RequestBody @Valid CreateLivroDTO createLivroDTO, HttpServletRequest request) {
        var bibliotecaCompanyId = request.getAttribute("bibliotecaCompany_id");

        //livroEntity.setBibliotecaId(UUID.fromString(bibliotecaCompanyId.toString()));

        var livroEntity = LivroEntity.builder()
                .bibliotecaId(UUID.fromString(bibliotecaCompanyId.toString()))
                .titulo(createLivroDTO.getTitulo())
                .autor(createLivroDTO.getAutor())
                .isbn(createLivroDTO.getIsbn())
                .quantidadeTotal(createLivroDTO.getQuantidadeTotal())
                .quantidadeDisponivel(createLivroDTO.getQuantidadeDisponivel())
                .build();

        return this.createLivroUseCase.execute(livroEntity);
    }

}
