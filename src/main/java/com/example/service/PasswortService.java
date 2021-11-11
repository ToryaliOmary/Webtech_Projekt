package com.example.service;

import com.example.persistence.PasswortEntity;
import com.example.persistence.PasswortRepository;
import com.example.servingwebcontent.api.Passwort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PasswortService {

    private final PasswortRepository passwortRepository;

    public PasswortService(PasswortRepository passwortRepository) {
        this.passwortRepository = passwortRepository;
    }

    public List<Passwort> findAll(){
        List<PasswortEntity> passworte = passwortRepository.findAll();
        return passworte.stream()
                .map(passwortEntity -> new Passwort(
                        passwortEntity.getId(),
                        passwortEntity.getPasswort(),
                        passwortEntity.getWebsite()
                ))
                .collect(Collectors.toList());
    }
}
