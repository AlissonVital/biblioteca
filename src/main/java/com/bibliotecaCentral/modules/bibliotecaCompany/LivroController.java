package com.bibliotecaCentral.modules.bibliotecaCompany;

import com.bibliotecaCentral.modules.bibliotecaCompany.entities.LivroEntity;
import com.bibliotecaCentral.modules.bibliotecaCompany.useCases.CreateLivroUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private CreateLivroUseCase createLivroUseCase;

    @PostMapping("/")
    public LivroEntity create(@RequestBody @Valid LivroEntity livroEntity) {
        return this.createLivroUseCase.execute(livroEntity);
    }

}
