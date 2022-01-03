package com.example.persistence;

import com.example.service.AES;

import javax.persistence.*;

@Entity(name = "passwoerter")
public class PasswortEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "website", nullable = false)
    private String website;

    @Column(name = "passwort", nullable = false)
    private String passwort;

    @Column(name = "arbeitsbereich", nullable = true)
    private String arbeitsbereich;


    public PasswortEntity(String website, String passwort, String arbeitsbereich) {
        this.website = website;
        this.passwort = passwort;
        this.arbeitsbereich = arbeitsbereich;
    }

    protected PasswortEntity() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsite() {return website;}

    public void setWebsite(String website) {this.website = website;}

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getArbeitsbereich() {
        return arbeitsbereich;
    }

    public void setArbeitsbereich(String arbeitsbereich){
        this.arbeitsbereich = arbeitsbereich;
    }
}
