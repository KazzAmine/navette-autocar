package com.navette.navette.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="Subscription")
public class Subscription {
    @Id
    @Column(nullable = false)
    private String idSubs;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String heureDepart;
    @Column(nullable = false)
    private String heureArrive;
    @Column(nullable = false)
    private String villeDepart;
    public String getVilleDepart() {
        return villeDepart;
    }
    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }

    @Column(nullable = false)
    private String villeArrivee;
    public String getVilleArrivee() {
        return villeArrivee;
    }
    public void setVilleArrivee(String villeArrivee) {
        this.villeArrivee = villeArrivee;
    }

    @Column(nullable = false)
    private double prix;
    @Column(nullable = false)
    private int nbrSubscribers;
    public Subscription(String idSubs, String description, String heureDepart, String heureArrive, String villeDepart,
            String villeArrivee, double prix, int nbrSubscribers) {
        this.idSubs = idSubs;
        this.description = description;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.villeDepart = villeDepart;
        this.villeArrivee = villeArrivee;
        this.prix = prix;
        this.nbrSubscribers = nbrSubscribers;
    }
    public Subscription() {
    }
    public String getIdSubs() {
        return idSubs;
    }
    public void setIdSubs(String idSubs) {
        this.idSubs = idSubs;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getHeureDepart() {
        return heureDepart;
    }
    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }
    public String getHeureArrive() {
        return heureArrive;
    }
    public void setHeureArrive(String heureArrive) {
        this.heureArrive = heureArrive;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix = prix;
    }
    public int getNbrSubscribers() {
        return nbrSubscribers;
    }
    public void setNbrSubscribers(int nbrSubscribers) {
        this.nbrSubscribers = nbrSubscribers;
    }
    
    @OneToMany(mappedBy = "subscription")
    @JsonIgnore
    private List<Abonnement> abonnements = new ArrayList<>();

    public List<Abonnement> getAbonnements() {
        return abonnements;
    }
    public void setAbonnements(List<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    @ManyToOne
    @JoinColumn(name = "Societe_id")
    @JsonIgnore
    private Societe societee;
    
    @ManyToOne
    @JoinColumn(name="busMatr")
    @JsonIgnore
    private Bus minibus;
    
    
    public Bus getMinibus() {
        return minibus;
    }
    public void setMinibus(Bus minibus) {
        this.minibus = minibus;
    }
    public Societe getSociete() {
        return societee;
    }
    public void setSociete(Societe societe) {
        this.societee = societe;
    } 
}
