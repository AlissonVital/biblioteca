package com.bibliotecaCentral.modules.bibliotecaCompany.repositories;

import com.bibliotecaCentral.modules.bibliotecaCompany.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<LivroEntity, UUID> {
    boolean existsByIsbn(String isbn);
}
