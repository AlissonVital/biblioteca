package com.bibliotecaCentral.modules.bibliotecaCompany.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthLeitorResponseDTO {

    private String access_token;
    private Long expires_in;

}
