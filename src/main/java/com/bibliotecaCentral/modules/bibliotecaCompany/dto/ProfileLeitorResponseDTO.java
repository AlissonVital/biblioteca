package com.bibliotecaCentral.modules.bibliotecaCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileLeitorResponseDTO {

    private UUID id;
    private String username;
    private String name;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;

}
