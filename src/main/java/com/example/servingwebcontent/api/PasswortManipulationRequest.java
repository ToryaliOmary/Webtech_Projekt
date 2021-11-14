package com.example.servingwebcontent.api;

public class PasswortManipulationRequest {

    private String website;  //Namen der Website oder des Programmes, bei dem Passwort gespeichert werden soll
    private String passwort; //mindestens 5 Charaktere + 1. Buchstabe groß

    public PasswortManipulationRequest(String website, String passwort) {
        this.website = website;
        this.passwort = passwort;
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
}
