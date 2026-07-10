package com.bibliotecaCentral.modules.leitor.useCases;

import com.bibliotecaCentral.exceptions.UserFoundException;
import com.bibliotecaCentral.modules.leitor.LeitorEntity;
import com.bibliotecaCentral.modules.leitor.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateLeitorUseCase {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LeitorRepository leitorRepository;

    public LeitorEntity execute(LeitorEntity leitorEntity) {
        this.leitorRepository
                .findByUsernameOrEmail(leitorEntity.getUsername(), leitorEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        var password = passwordEncoder.encode(leitorEntity.getPassword());
        leitorEntity.setPassword(password);

        return this.leitorRepository.save(leitorEntity);
    }
}
