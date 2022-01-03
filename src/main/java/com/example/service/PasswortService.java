package com.example.service;

import com.example.persistence.PasswortEntity;
import com.example.persistence.PasswortRepository;
import com.example.servingwebcontent.api.Passwort;
import com.example.servingwebcontent.api.PasswortManipulationRequest;
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
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Passwort findById(Long id) {
        var passwortEntity = passwortRepository.findById(id);
        return passwortEntity.map(this::transformEntity).orElse(null);
    }

    public Passwort create(PasswortManipulationRequest request) {
        var passwortEntity = new PasswortEntity(request.getWebsite(), AES.encrypt(request.getPasswort()), request.getArbeitsbereich());
        passwortEntity = passwortRepository.save(passwortEntity);
        return transformEntity(passwortEntity);
    }

    public Passwort update(Long id, PasswortManipulationRequest request) {
        var passwortEntityOptional = passwortRepository.findById(id);
        if (passwortEntityOptional.isEmpty()) {
            return null;
        }

        var passwortEntity = passwortEntityOptional.get();
        passwortEntity.setWebsite(request.getWebsite());
        passwortEntity.setPasswort(request.getPasswort());
        passwortEntity.setArbeitsbereich(request.getArbeitsbereich());
        passwortEntity = passwortRepository.save(passwortEntity);

        return transformEntity(passwortEntity);
    }

    public boolean deleteById(Long id) {
        if (!passwortRepository.existsById(id)) {
            return false;
        }

        passwortRepository.deleteById(id);
        return true;
    }

    private Passwort transformEntity(PasswortEntity passwortEntity) {
        return new Passwort(
                passwortEntity.getId(),
                passwortEntity.getWebsite(),
                AES.decrypt(passwortEntity.getPasswort()),
                passwortEntity.getArbeitsbereich()
        );
    }
}
