package com.navette.navette.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.navette.navette.model.Trajet;

public interface TrajetRepository extends JpaRepository<Trajet,Integer>{
    
}
