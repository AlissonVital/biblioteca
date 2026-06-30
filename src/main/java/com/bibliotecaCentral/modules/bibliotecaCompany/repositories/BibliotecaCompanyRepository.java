package com.bibliotecaCentral.modules.bibliotecaCompany.repositories;

import com.bibliotecaCentral.modules.bibliotecaCompany.entities.BibliotecaCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BibliotecaCompanyRepository extends JpaRepository<BibliotecaCompanyEntity, UUID> {
    Optional<BibliotecaCompanyEntity> findByUsernameOrEmail(String username, String email);
}
