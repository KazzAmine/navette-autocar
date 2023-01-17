package com.navette.navette.model;


import jakarta.persistence.*;

@Entity
@Table(name="TrajetPropo")
public class TrajetPropo {

    @Id
    @Column(nullable = false)
    private int idTraProp;
    public int getIdTraProp() {
        return idTraProp;
    }
    public void setIdTraProp(int idTraProp) {
        this.idTraProp = idTraProp;
    }
    @Column(length = 100,nullable = false)
    private String villeDepart;
    @Column(length = 100,nullable = false)
    private String villeArrive;
    @Column(nullable = false)
    private String heureDepart;
    @Column(nullable = false)
    private String heureArrive;
    @Column(nullable = false)
    private String dateDepart;
    @Column(nullable = false)
    private String dateArrive;
    
    public TrajetPropo(int id,String villeDepart, String villeArrive, String heureDepart, String heureArrive,
            String dateDepart, String dateArrive) {
        this.idTraProp=id;
        this.villeDepart = villeDepart;
        this.villeArrive = villeArrive;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.dateDepart = dateDepart;
        this.dateArrive = dateArrive;
    }
    public TrajetPropo() {
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
    public String getDateDepart() {
        return dateDepart;
    }
    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }
    public String getDateArrive() {
        return dateArrive;
    }
    public void setDateArrive(String dateArrive) {
        this.dateArrive = dateArrive;
    }
}
