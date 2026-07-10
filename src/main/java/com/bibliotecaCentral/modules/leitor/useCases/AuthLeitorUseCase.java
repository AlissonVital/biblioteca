package com.bibliotecaCentral.modules.leitor.useCases;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.bibliotecaCentral.modules.bibliotecaCompany.dto.AuthLeitorResponseDTO;
import com.bibliotecaCentral.modules.leitor.AuthLeitorRequestDTO;
import com.bibliotecaCentral.modules.leitor.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

@Service
public class AuthLeitorUseCase {

    @Value("${security.token.secret.leitor}")
    private String secretKey;

    @Autowired
    private LeitorRepository leitorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthLeitorResponseDTO execute(AuthLeitorRequestDTO authLeitorRequestDTO) throws AuthenticationException {
        var leitor = this.leitorRepository.findByUsername(authLeitorRequestDTO.username())
                .orElseThrow(() -> {
                    throw new UsernameNotFoundException("Username or password incorrect!!!!!");
                });

        var passwordMatches = this.passwordEncoder
                .matches(authLeitorRequestDTO.password(), leitor.getPassword());

        if (!passwordMatches) {
            throw new AuthenticationException();
        }

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        var expiresIn = Instant.now().plus(Duration.ofMinutes(10));
        var token = JWT.create()
                .withIssuer("livros")
                .withSubject(leitor.getId().toString())
                .withClaim("roles", Arrays.asList("leitor"))
                .withExpiresAt(expiresIn)
                .sign(algorithm);

        var authLeitorResponse = AuthLeitorResponseDTO.builder()
                .access_token(token)
                .expires_in((expiresIn.toEpochMilli()))
                .build();
        return authLeitorResponse;
    }
}
