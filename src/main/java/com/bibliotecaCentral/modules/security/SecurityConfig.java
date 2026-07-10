package com.bibliotecaCentral.modules.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private SecurityFilter securityFilter;

    @Autowired
    private SecurityLeitorFilter securityLeitorFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers("/leitor/").permitAll()
                            .requestMatchers("/bibliotecaCompany/").permitAll()
                            .requestMatchers("/leitor/auth").permitAll()
                            .requestMatchers("/bibliotecaCompany/auth").permitAll()
                            .requestMatchers("/swagger-ui/**").permitAll()
                            .requestMatchers("/swagger-ui.html").permitAll()
                            .requestMatchers("/v3/api-docs/**").permitAll()
                            .requestMatchers("/api-docs/**").permitAll();
                    auth.anyRequest().authenticated();
                })

                .addFilterBefore(securityLeitorFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(securityFilter, BasicAuthenticationFilter.class)

        ;
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }
}
