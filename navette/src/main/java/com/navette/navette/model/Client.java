package com.navette.navette.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name="client")
public class Client {
    @Id
    @Column(nullable = false)
    private String CIN;
    @Column(length = 100,nullable=false)
    private String nom;
    @Column(length = 100,nullable=false)
    private String prenom;
    @Column(length = 70,nullable=false)
    private String ville;

    private String email;
    
    public Client(String cIN, String nom, String prenom, String ville, String email) {
        this.CIN = cIN;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.email = email;
    }

    public Client() {
    }

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String cIN) {
        CIN = cIN;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @OneToMany(mappedBy = "cl")
    @JsonIgnore
    private List<Abonnement> subscriptins = new ArrayList<Abonnement>();

    public List<Abonnement> getSubscriptins() {
        return subscriptins;
    }

    public void setSubscriptins(List<Abonnement> subscriptins) {
        this.subscriptins = subscriptins;
    }

}
