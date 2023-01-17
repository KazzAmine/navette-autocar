package com.navette.navette.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navette.navette.model.Societe;
import com.navette.navette.model.Subscription;

public interface SubsRepository extends JpaRepository<Subscription,String> {
   
    List<Subscription> findByHeureDepartAndVilleDepartAndVilleArrivee(String heuredep,String villedep,String villearr);
    List<Subscription> findBySocieteeSocId(String SocId);
}
