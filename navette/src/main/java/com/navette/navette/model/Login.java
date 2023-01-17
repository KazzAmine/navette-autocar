package com.navette.navette.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

@Entity
public class Login {
    
    @Id
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,length = 20)
    private String role;
    public Login(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Login() {
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

   
    
}
