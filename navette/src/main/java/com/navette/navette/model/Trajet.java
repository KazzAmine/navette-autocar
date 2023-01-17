package com.navette.navette.model;

import jakarta.persistence.*;

@Entity
@Table(name="Trajet")
public class Trajet {
    
    @Id
    @Column(nullable = false)
    private int idTrajet;
    @Column(length = 100,nullable = false)
    private String villeDepart;
    @Column(length = 100,nullable = false)
    private String villeArrive;
    
    public Trajet(int idTrajet, String villeDepart, String villeArrive) {
        this.idTrajet = idTrajet;
        this.villeDepart = villeDepart;
        this.villeArrive = villeArrive;
    }
    public Trajet() {
    }
    public int getIdTrajet() {
        return idTrajet;
    }
    public void setIdTrajet(int idTrajet) {
        this.idTrajet = idTrajet;
    }
    public String getVilleDepart() {
        return villeDepart;
    }
    public void setVilleDepart(String villeDepart) {
        this.villeDepart = villeDepart;
    }
    public String getVilleArrive() {
        return villeArrive;
    }
    public void setVilleArrive(String villeArrive) {
        this.villeArrive = villeArrive;
    }

    

}
