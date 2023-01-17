package com.navette.navette.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.navette.navette.model.Login;

public interface LoginRepository extends JpaRepository<Login,String> {
    public Login findByEmailAndPassword(String email,String password);
}
