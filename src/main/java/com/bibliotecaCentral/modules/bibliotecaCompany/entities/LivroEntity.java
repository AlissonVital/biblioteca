package com.bibliotecaCentral.modules.bibliotecaCompany.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;
import jakarta.persistence.Column;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Data
@Entity(name = "livro")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String titulo;
    private String autor;

    @Column(unique = true, nullable = false)
    private String isbn;

    private String quantidadeTotal;
    private String quantidadeDisponivel;

    @ManyToOne()
    @JoinColumn(name = "biblioteca_id", insertable = false, updatable = false)
    private BibliotecaCompanyEntity bibliotecaCompanyEntity;

    @Column(name = "biblioteca_id")
    private UUID bibliotecaId;

    @CreationTimestamp
    private LocalDateTime dataCadastro;
}
