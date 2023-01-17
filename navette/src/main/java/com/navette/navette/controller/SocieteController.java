package com.navette.navette.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navette.navette.model.Societe;
import com.navette.navette.services.SocieteService;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Societe")
public class SocieteController {
    @Autowired
    private final SocieteService socServ;

    public SocieteController(SocieteService socServ) {
        this.socServ = socServ;
    }

    @PostMapping("/addsociete/{socid}")
    public void CreateSociete(@RequestBody Societe soc,@PathVariable String socid){
        soc.setSocId(socid);
        socServ.CreateSociete(soc);
    }

    @PutMapping("/updateSociete/{socId}")
    public void updateSociete(@PathVariable String socId,@RequestBody Societe soc){
        soc.setSocId(socId);
        socServ.updateSociete(soc);
    }

    @DeleteMapping("/deleteSociete/{socId}")
    public void deleteSociete(@PathVariable("socId") String socId){
        socServ.removeSocite(socId);
    }
    
    @PostMapping("/getallSociete")
    public List<Societe> getAllSociete() {
        return socServ.getAllSocietes();
    }

    @PostMapping("/getSociete/{socid}")
    public Optional<Societe> getClient(@PathVariable String socid){
        return socServ.getsocieteInfo(socid);
    }

    @PostMapping("/getsocietebymail/{email}")
    public Societe getSoccieteByMail(@PathVariable String email){
        return socServ.getSocieteByMail(email);
    }

}
