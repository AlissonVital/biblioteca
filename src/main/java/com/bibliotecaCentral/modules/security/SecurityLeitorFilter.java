package com.bibliotecaCentral.modules.security;

import com.bibliotecaCentral.modules.bibliotecaCompany.providers.JWTLeitorProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityLeitorFilter extends OncePerRequestFilter {

    @Autowired
    private JWTLeitorProvider jwtLeitorProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // SecurityContextHolder.getContext().setAuthentication(null);
        String header = request.getHeader("Authorization");

        if (request.getRequestURI().startsWith("/leitor")) {
            if (header != null) {
                var token = this.jwtLeitorProvider.validateToken(header);

                if (token == null) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return;
                }
                request.setAttribute("leitor_id", token.getSubject());
                var roles = token.getClaim("roles").asList(Object.class);

                var grants = roles.stream()
                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toString())
                        ).toList();
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(token.getSubject(),
                                null, grants);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }
}
