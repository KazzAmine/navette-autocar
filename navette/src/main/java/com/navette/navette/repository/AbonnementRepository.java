package com.navette.navette.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navette.navette.model.Abonnement;
import com.navette.navette.model.Client;



public interface AbonnementRepository extends JpaRepository<Abonnement,Integer>{
    public Abonnement findByCl(Client cl);
    List<Abonnement> findByClCIN(String cin);
}
