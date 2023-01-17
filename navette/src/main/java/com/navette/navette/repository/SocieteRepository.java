package com.navette.navette.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.navette.navette.model.Societe;

public interface SocieteRepository extends JpaRepository<Societe,String>{
    public Societe findByEmail(String email);
}
