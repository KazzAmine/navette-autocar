package com.navette.navette.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navette.navette.model.Abonnement;
import com.navette.navette.model.Client;
import com.navette.navette.repository.AbonnementRepository;

@Service
public class AbonnementService {
    @Autowired
    private final AbonnementRepository abRepo;


    public AbonnementService(AbonnementRepository abRepo) {
        this.abRepo = abRepo;
    }

    public void addAbonnement(Abonnement ab){
        abRepo.save(ab);
    }

    public Abonnement getAbonnementInfo(Client cl) {
            return abRepo.findByCl(cl);
    }

    public void removeAbonnemnt(int idab){
        abRepo.deleteById(idab);
    }

    public List<Abonnement> getAllAbonnemnt(){
        return abRepo.findAll();
    }

    public void updateAbonnement(Abonnement ab){
        abRepo.save(ab);
    }

    public List<Abonnement> getabonnementbyclient(String SocId){
        return abRepo.findByClCIN(SocId);
    }

}
