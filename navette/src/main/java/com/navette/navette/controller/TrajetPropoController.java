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

import com.navette.navette.model.TrajetPropo;
import com.navette.navette.services.TrajetPropoService;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Trajetpropo")
public class TrajetPropoController {
    @Autowired
    private final TrajetPropoService trjtServ;

    public TrajetPropoController(TrajetPropoService trjtServ) {
        this.trjtServ = trjtServ;
    }
    
    @PostMapping("/addTrajetPropo")
    public void createTrajetPropo(@RequestBody TrajetPropo trajet){
        trjtServ.addTrajetPropo(trajet);
    }

    @PutMapping("/updateTrajetPropo/{trajetId}")
    public void updateTrajetPropo(@PathVariable int trajetId,@RequestBody TrajetPropo trajet){
        trajet.setIdTraProp(trajetId);
        trjtServ.updateTrajetPropo(trajet);
    }

    @DeleteMapping("/deleteTrajetPropo/{trajetID}")
    public void deleteTrajetPropo(@PathVariable("trajetID") int trajetID){
        trjtServ.removeTrajetPropo(trajetID);
    }
    
    @PostMapping("/getAllTrajetsPropo")
    public List<TrajetPropo> getAllTrajetsPropo() {
        return trjtServ.getAllTrajetsPropo();
    }

    @PostMapping("/getTrajet/{trajetId}")
    public Optional<TrajetPropo> getTrajet(@PathVariable int trajetId){
        return trjtServ.getTrajetPropoInfo(trajetId);
    }
    
}
