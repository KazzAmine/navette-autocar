package com.navette.navette.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Abonnement {

    @Id
    @Column(name = "abonnementId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long abonnementId;

    @ManyToOne
    @JoinColumn(name = "client_cin")
    private Client cl;

    @ManyToOne
    @JoinColumn(name = "subscriptionid")
    private Subscription subscription;

    @Column(name = "depDate")
    private String depDate;
    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    @Column(name = "endDate")
    private String endDate;
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Column
    private boolean active;
    @Column
    private long totalPrice;
   

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Abonnement(long abonnementId, String depDate, String endDate, boolean active,long totalPrice) {
        this.abonnementId = abonnementId;
        this.depDate = depDate;
        this.endDate = endDate;
        this.active = active;
        this.totalPrice=totalPrice;
    }

    public Abonnement() {
    }

    public long getAbonnementId() {
        return abonnementId;
    }

    public void setAbonnementId(long abonnementId) {
        this.abonnementId = abonnementId;
    }

    public Client getCl() {
        return cl;
    }

    public void setCl(Client cl) {
        this.cl = cl;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

   

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
