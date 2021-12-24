package com.example.servingwebcontent.api;

public class Passwort {

    private Long id;
    private String website;  //Namen der Website oder des Programmes, bei dem Passwort gespeichert werden soll
    private String passwort; //mindestens 5 Charaktere + 1. Buchstabe groß
    private String arbeitsbereich;

    public Passwort(Long id, String website, String passwort, String arbeitsbereich) {
        this.id = id;
        this.website = website;
        this.passwort = passwort;
        this.arbeitsbereich = arbeitsbereich;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public void setArbeitsbereich(String arbeitsbereich){
        this.arbeitsbereich = arbeitsbereich;
    }

}
