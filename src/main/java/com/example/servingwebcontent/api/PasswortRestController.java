package com.example.servingwebcontent.api;

import com.example.service.PasswortService;
import com.example.servingwebcontent.api.Passwort;
import com.example.servingwebcontent.api.PasswortManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
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

    @GetMapping(path = "/api/v1/passwort/{id}")
    public ResponseEntity<Passwort> fetchPasswortById(@PathVariable Long id) {
        var passwort = passwortService.findById(id);
        return passwort != null? ResponseEntity.ok(passwort) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/passwort")
    public ResponseEntity<Void> createPasswort(@RequestBody PasswortManipulationRequest request) throws URISyntaxException {
        var passwort = passwortService.create(request);
        URI uri = new URI("/api/v1/passwort/" + passwort.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/passwort/{id}")
    public ResponseEntity<Passwort> updatePasswort(@PathVariable Long id, @RequestBody PasswortManipulationRequest request) {
        var passwort = passwortService.update(id, request);
        return passwort != null? ResponseEntity.ok(passwort) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/passwort/{id}")
    public ResponseEntity<Void> deletePasswort(@PathVariable Long id) {
        boolean successful = passwortService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
