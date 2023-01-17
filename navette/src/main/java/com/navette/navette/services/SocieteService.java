package com.navette.navette.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navette.navette.model.Societe;
import com.navette.navette.repository.SocieteRepository;

@Service
public class SocieteService {
    @Autowired
    private final SocieteRepository socRepo;

    public SocieteService(SocieteRepository socRepo) {
        this.socRepo = socRepo;
    }

    public void CreateSociete(Societe soc){
        socRepo.save(soc);
    }
    
    public Optional<Societe> getsocieteInfo(String SocId) {
        return socRepo.findById(SocId);
}

public void removeSocite(String SocId){
    socRepo.deleteById(SocId);
}

public List<Societe> getAllSocietes(){
    return socRepo.findAll();
}

public void updateSociete(Societe soc){
    socRepo.save(soc);
}

public Societe getSocieteByMail(String email) {
    return socRepo.findByEmail(email);
}
}
