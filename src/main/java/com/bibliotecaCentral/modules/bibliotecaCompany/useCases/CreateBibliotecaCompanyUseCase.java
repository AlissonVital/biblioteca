package com.bibliotecaCentral.modules.bibliotecaCompany.useCases;

import com.bibliotecaCentral.exceptions.UserFoundException;
import com.bibliotecaCentral.modules.bibliotecaCompany.entities.BibliotecaCompanyEntity;
import com.bibliotecaCentral.modules.bibliotecaCompany.repositories.BibliotecaCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateBibliotecaCompanyUseCase {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private BibliotecaCompanyRepository bibliotecaCompanyRepository;

    public BibliotecaCompanyEntity execute(BibliotecaCompanyEntity bibliotecaCompanyEntity) {
        this.bibliotecaCompanyRepository
                .findByUsernameOrEmail(bibliotecaCompanyEntity.getName(), bibliotecaCompanyEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        var password = passwordEncoder.encode(bibliotecaCompanyEntity.getPassword());
        bibliotecaCompanyEntity.setPassword(password);

        return this.bibliotecaCompanyRepository.save(bibliotecaCompanyEntity);
    }
}
