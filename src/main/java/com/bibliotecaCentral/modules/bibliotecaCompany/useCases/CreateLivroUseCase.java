package com.bibliotecaCentral.modules.bibliotecaCompany.useCases;

import com.bibliotecaCentral.exceptions.LivroDuplicadoException;
import com.bibliotecaCentral.modules.bibliotecaCompany.entities.LivroEntity;
import com.bibliotecaCentral.modules.bibliotecaCompany.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateLivroUseCase {

    @Autowired
    private LivroRepository livroRepository;

    public LivroEntity execute(LivroEntity livroEntity) {
        if (this.livroRepository.existsByIsbn(livroEntity.getIsbn())) {
            throw new LivroDuplicadoException();
        }

        return this.livroRepository.save(livroEntity);
    }

}
