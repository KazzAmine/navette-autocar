package com.navette.navette.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navette.navette.model.Trajet;
import com.navette.navette.repository.TrajetRepository;

@Service
public class TrajetService {
    @Autowired
    private final TrajetRepository trjtRepo;

    public TrajetService(TrajetRepository trjtRepo) {
        this.trjtRepo = trjtRepo;
    }

    public void addTrajet(Trajet trajet){
        trjtRepo.save(trajet);
    }

    public Optional<Trajet> getTrajetInfo(int idTrajet) {
            return trjtRepo.findById(idTrajet);
    }

    public void removeTrajet(int idTrajet){
        trjtRepo.deleteById(idTrajet);
    }

    public List<Trajet> getAllTrajets(){
        return trjtRepo.findAll();
    }

    public void updateTrajet(Trajet trajet){
        trjtRepo.save(trajet);
    }
    
}
