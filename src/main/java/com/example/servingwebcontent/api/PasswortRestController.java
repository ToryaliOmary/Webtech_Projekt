package com.example.servingwebcontent.api;

import com.example.service.PasswortService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PasswortRestController {

    private final PasswortService passwortService;

    public PasswortRestController(PasswortService passwortService) {
        this.passwortService = passwortService;
    }


    @GetMapping(path = "/api/passwort")
    public ResponseEntity<List<Passwort>> fetchPasswort(){
        return ResponseEntity.ok(passwortService.findAll());
    }
}
