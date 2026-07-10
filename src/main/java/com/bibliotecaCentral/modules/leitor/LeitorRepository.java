package com.bibliotecaCentral.modules.leitor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LeitorRepository extends JpaRepository<LeitorEntity, UUID> {
    Optional<LeitorEntity> findByUsernameOrEmail(String username, String email);
    Optional<LeitorEntity> findByUsername(String username);
}
