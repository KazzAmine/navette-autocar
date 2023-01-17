package com.navette.navette.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.navette.navette.model.Bus;


public interface BusRepository extends JpaRepository<Bus,String>  {
    
}
