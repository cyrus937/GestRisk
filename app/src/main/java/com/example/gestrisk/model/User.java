package com.example.gestrisk.model;

public class User {
    private int idUser;
    private String nom;
    private String prenom;
    private String poste;
    private String zone;
    private String email;
    private String password;


    public User(int idUser, String nom, String prenom, String poste, String zone, String email, String password) {
        this(nom, prenom, poste, zone, email, password);
        this.idUser = idUser;
    }

    public User(String nom, String prenom, String poste, String zone, String email, String password) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.zone = zone;
        this.email = email;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", poste='" + poste + '\'' +
                ", zone='" + zone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
