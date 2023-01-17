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

import com.navette.navette.model.Trajet;
import com.navette.navette.services.TrajetService;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Trajet")
public class TrajetController {
    @Autowired
    private final TrajetService trjtServ;

    public TrajetController(TrajetService trjtServ) {
        this.trjtServ = trjtServ;
    }

    @PostMapping("/addTrajet")
    public void createTrajet(@RequestBody Trajet trajet){
        trjtServ.addTrajet(trajet);
    }

    @PutMapping("/updateTrajet/{trajetId}")
    public void updateTrajet(@PathVariable int trajetId,@RequestBody Trajet trajet){
        trajet.setIdTrajet(trajetId);
        trjtServ.updateTrajet(trajet);
    }

    @DeleteMapping("/deleteTrajet/{trajetID}")
    public void deleteTrajet(@PathVariable("trajetID") int trajetID){
        trjtServ.removeTrajet(trajetID);
    }
    
    @PostMapping("/getAllTrajets")
    public List<Trajet> getAllTrajets() {
        return trjtServ.getAllTrajets();
    }

    @PostMapping("/getTrajet/{trajetId}")
    public Optional<Trajet> getTrajet(@PathVariable int trajetId){
        return trjtServ.getTrajetInfo(trajetId);
    }
    
}
