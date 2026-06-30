package com.bibliotecaCentral.modules.leitor.useCases;

import com.bibliotecaCentral.exceptions.UserFoundException;
import com.bibliotecaCentral.modules.leitor.LeitorEntity;
import com.bibliotecaCentral.modules.leitor.LeitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateLeitorUseCase {

    @Autowired
    private LeitorRepository leitorRepository;

    public LeitorEntity execute(LeitorEntity leitorEntity) {
        this.leitorRepository
                .findByUsernameOrEmail(leitorEntity.getUsername(), leitorEntity.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });
        return this.leitorRepository.save(leitorEntity);
    }
}
