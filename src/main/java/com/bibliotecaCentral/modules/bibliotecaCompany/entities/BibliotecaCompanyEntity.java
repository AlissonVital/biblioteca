package com.bibliotecaCentral.modules.bibliotecaCompany.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Entity(name = "biblioteca")
@Data
public class BibliotecaCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String username;
    @Email(message = "O campo de [email] deve conter um e-mail válido!!!")
    private String email;
    private String password;
    private String cnpj;
    @CreationTimestamp
    private LocalDateTime createdAt;
}
