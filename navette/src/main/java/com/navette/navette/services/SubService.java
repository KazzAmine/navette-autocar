package com.navette.navette.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navette.navette.model.Societe;
import com.navette.navette.model.Subscription;
import com.navette.navette.repository.SubsRepository;

@Service
public class SubService {
    @Autowired
    private final SubsRepository subRepo;

    public SubService(SubsRepository subRepo) {
        this.subRepo = subRepo;
    }
    
    public void addSubs(Subscription sub){
        subRepo.save(sub);
    }

    public Optional<Subscription> getSubInfo(String idSub) {
            return subRepo.findById(idSub);
    }

    public void removeSub(String idSub){
        subRepo.deleteById(idSub);
    }

    public List<Subscription> getAllSubs(String heuredep,String villedep,String villearr){
        return subRepo.findByHeureDepartAndVilleDepartAndVilleArrivee(heuredep,villedep,villearr);
    }

    public List<Subscription> getSubBySociete(String SocId){
        return subRepo.findBySocieteeSocId(SocId);
    }
    public List<Subscription> getall(){
        return subRepo.findAll();
    }
    public void updateSub(Subscription sub){
        subRepo.save(sub);
    }
}
