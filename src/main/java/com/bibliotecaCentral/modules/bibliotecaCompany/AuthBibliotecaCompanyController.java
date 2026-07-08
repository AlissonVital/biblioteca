package com.bibliotecaCentral.modules.bibliotecaCompany;


import com.bibliotecaCentral.modules.bibliotecaCompany.dto.AuthBibliotecaCompanyDTO;
import com.bibliotecaCentral.modules.bibliotecaCompany.useCases.AuthBibliotecaCompanyUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthBibliotecaCompanyController {

    @Autowired
    private AuthBibliotecaCompanyUseCase authBibliotecaCompanyUseCase;

    @PostMapping("/company")
    public ResponseEntity<Object> create(@RequestBody AuthBibliotecaCompanyDTO authBibliotecaCompanyDTO) {
        try {
            var result = this.authBibliotecaCompanyUseCase.execute(authBibliotecaCompanyDTO);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

}
