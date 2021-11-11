package com.example.persistence;

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


    public PasswortEntity(String website, String passwort) {
        this.id = id;
        this.website = website;
        this.passwort = passwort;
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
}