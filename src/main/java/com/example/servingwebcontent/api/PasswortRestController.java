package com.example.servingwebcontent.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PasswortRestController {

    private List<Passwort> passwort;

    public PasswortRestController() {
        this.passwort = passwort;
        passwort.add(new Passwort("www.test1.de", "Passwort" ));        //1. Testwebsite
        passwort.add(new Passwort("www.test2.de", "Passwort" ));        //2. Testwebsite
    }

    @GetMapping(path = "/api/passwort")
    public ResponseEntity<List<Passwort>> fetchPasswort(){
        return ResponseEntity.ok(passwort);
    }
}
