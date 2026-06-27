package com.bibliotecaCentral.modules.leitor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Data
@Entity(name = "leitor")
public class LeitorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Pattern(regexp = "^\\S+$", message = "O username não pode conter espaço!")
    private String username;
    private String name;
    private String cpf;
    @Email(message = "No campo [email] coloque um email válido!")
    private String email;
    private String password;
    private String telefone;
    @CreationTimestamp
    private LocalDateTime dataCadastro;
}
