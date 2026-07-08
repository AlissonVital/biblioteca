package com.bibliotecaCentral.modules.bibliotecaCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthBibliotecaCompanyDTO {

    private String password;
    private String username;
}
