package com.bibliotecaCentral.modules.bibliotecaCompany.useCases;

import com.bibliotecaCentral.modules.bibliotecaCompany.dto.ProfileLeitorResponseDTO;
import com.bibliotecaCentral.modules.leitor.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfileLeitorUseCase {

    @Autowired
    private LeitorRepository leitorRepository;

    public ProfileLeitorResponseDTO execute(UUID idLeitor) {

        var leitor = this.leitorRepository.findById(idLeitor)
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("User not found");
                });
        var leitroDTO = ProfileLeitorResponseDTO.builder()
                .id(leitor.getId())
                .username(leitor.getUsername())
                .name(leitor.getName())
                .cpf(leitor.getCpf())
                .email(leitor.getEmail())
                .telefone(leitor.getTelefone())
                .dataCadastro(leitor.getDataCadastro())
                .build();
        return leitroDTO;
    }
}
