package com.bibliotecaCentral.modules.bibliotecaCompany;

import com.bibliotecaCentral.modules.bibliotecaCompany.entities.BibliotecaCompanyEntity;
import com.bibliotecaCentral.modules.bibliotecaCompany.useCases.CreateBibliotecaCompanyUseCase;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliotecaCompany")
public class BibliotecaCompanyController {

    @Autowired
    private CreateBibliotecaCompanyUseCase createBibliotecaCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody BibliotecaCompanyEntity bibliotecaCompanyEntity) {
        try {
            var result = this.createBibliotecaCompanyUseCase.execute(bibliotecaCompanyEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
