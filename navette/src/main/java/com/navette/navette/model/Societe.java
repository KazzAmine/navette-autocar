package com.navette.navette.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="Societe")
public class Societe {
    
    @Id
    @Column(nullable = false)
    private String socId;
    @Column(length = 100,nullable = false)
    private String nom;
    @Column(length = 100,nullable = false)
    private String adresse;
    @Column(nullable = false)
    private String email;
    
    public Societe(String socId, String nom, String adresse, String email) {
        this.socId = socId;
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
    }
    public Societe() {
    }
    public String getSocId() {
        return socId;
    }
    public void setSocId(String socId) {
        this.socId = socId;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    

    @OneToMany(mappedBy = "societe")
    @JsonIgnore
    private List<Bus> busses=new ArrayList<>();
    
    public List<Bus> getBusses() {
        return busses;
    }
    public void setBusses(List<Bus> busses) {
        this.busses = busses;
    }

    @OneToMany(mappedBy = "societee")
    @JsonIgnore
    private List<Subscription> sub;
}
