package com.navette.navette.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.navette.navette.model.Client;

public interface ClientRepository extends JpaRepository<Client,String>{
    
    public Client findByEmail(String email);
}
