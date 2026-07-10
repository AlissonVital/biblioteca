package com.bibliotecaCentral.modules.bibliotecaCompany.useCases;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bibliotecaCentral.modules.bibliotecaCompany.dto.AuthBibliotecaCompanyDTO;
import com.bibliotecaCentral.modules.bibliotecaCompany.repositories.BibliotecaCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;

@Service
public class AuthBibliotecaCompanyUseCase {

    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private BibliotecaCompanyRepository bibliotecaCompanyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthBibliotecaCompanyDTO authBibliotecaCompanyDTO) throws AuthenticationException {
        var bibliotecaCompany = this.bibliotecaCompanyRepository.findByUsername(authBibliotecaCompanyDTO.getUsername()).orElseThrow(
                () -> {
                    throw new UsernameNotFoundException("username ou password incorreto!!!!!");
                });
        // VERIFICAÇÃO SE AS SENHAS SÃO IGUAIS
        var passwordMatches = this.passwordEncoder.matches(authBibliotecaCompanyDTO.getPassword(), bibliotecaCompany.getPassword());

        // VERIFICAÇÃO SE NÃO FOR IGUAL = ERRO
        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        // VERIFICAÇÃO SE FOR IGUAL = GERAR TOKEN
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var token = JWT.create().withIssuer("livros")
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .withSubject(bibliotecaCompany
                .getId().toString()).sign(algorithm);
        return token;
    }

}
