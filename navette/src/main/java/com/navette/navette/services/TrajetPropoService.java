package com.navette.navette.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navette.navette.model.TrajetPropo;
import com.navette.navette.repository.TrajPropoResps;

@Service
public class TrajetPropoService {
    @Autowired
    private final TrajPropoResps trjtPrRepo;

    public TrajetPropoService(TrajPropoResps trjtPrRepo) {
        this.trjtPrRepo = trjtPrRepo;
    }

    public void addTrajetPropo(TrajetPropo trajetPropo){
        trjtPrRepo.save(trajetPropo);
    }

    public Optional<TrajetPropo> getTrajetPropoInfo(int idTrajet) {
            return trjtPrRepo.findById(idTrajet);
    }

    public void removeTrajetPropo(int idTrajet){
        trjtPrRepo.deleteById(idTrajet);
    }

    public List<TrajetPropo> getAllTrajetsPropo(){
        return trjtPrRepo.findAll();
    }

    public void updateTrajetPropo(TrajetPropo trajet){
        trjtPrRepo.save(trajet);
    }
    
}
