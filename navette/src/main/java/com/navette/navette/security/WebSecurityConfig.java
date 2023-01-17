package com.navette.navette.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.http.HttpServletRequest;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig{

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,HttpServletRequest request) throws Exception {
        http.csrf().disable();
        return http.build();
    }
   
  }