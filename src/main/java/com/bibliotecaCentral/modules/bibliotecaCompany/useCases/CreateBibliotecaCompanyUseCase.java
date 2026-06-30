package com.bibliotecaCentral.modules.bibliotecaCompany.useCases;

import com.bibliotecaCentral.exceptions.UserFoundException;
import com.bibliotecaCentral.modules.bibliotecaCompany.entities.BibliotecaCompanyEntity;
import com.bibliotecaCentral.modules.bibliotecaCompany.repositories.BibliotecaCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateBibliotecaCompanyUseCase {

    @Autowired
    private BibliotecaCompanyRepository bibliotecaCompanyRepository;

    public BibliotecaCompanyEntity execute(BibliotecaCompanyEntity bibliotecaCompanyEntity) {
        this.bibliotecaCompanyRepository
                .findByUsernameOrEmail(bibliotecaCompanyEntity.getName(), bibliotecaCompanyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.bibliotecaCompanyRepository.save(bibliotecaCompanyEntity);
    }
}
