package com.navette.navette.model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="Bus")
public class Bus {
    @Id
    @Column(nullable = false)
    private String matricule;

    @Column(length = 40,nullable = false)
    private String marque;
    
    @Column(nullable = false)
    private int capacite;
    
    public Bus(String matricule, String marque, int capacite) {
        this.matricule = matricule;
        this.marque = marque;
        this.capacite = capacite;
    }
    public Bus() {
    }
    public String getMatricule() {
        return matricule;
    }
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque = marque;
    }
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @ManyToOne
    @JoinColumn(name="societe_id")
    @JsonIgnore
    private Societe societe;

    public Societe getSocietee() {
        return societe;
    }
    public void setSocietee(Societe societee) {
        this.societe = societee;
    }

    @OneToMany(mappedBy = "minibus")
    @JsonIgnore
    private List<Subscription> subscriptionss=new ArrayList<>();

    public List<Subscription> getSubscriptionss() {
        return subscriptionss;
    }
    public void setSubscriptionss(List<Subscription> subscriptionss) {
        this.subscriptionss = subscriptionss;
    }
}
