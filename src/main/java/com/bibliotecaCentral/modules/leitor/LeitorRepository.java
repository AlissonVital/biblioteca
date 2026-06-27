package com.bibliotecaCentral.modules.leitor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LeitorRepository extends JpaRepository<LeitorEntity, UUID> {

}
