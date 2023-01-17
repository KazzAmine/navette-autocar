package com.navette.navette.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navette.navette.model.Client;
import com.navette.navette.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private final ClientRepository clRepo;


    public ClientService(ClientRepository clRepo) {
        this.clRepo = clRepo;
    }

    public void createClient(Client cl){
        clRepo.save(cl);
    }

    public Optional<Client> getClientInfo(String cin) {
            return clRepo.findById(cin);
    }

    public void removeClient(String cin){
        clRepo.deleteById(cin);
    }

    public List<Client> getAllClients(){
        return clRepo.findAll();
    }

    public void updateClient(Client cl){
        clRepo.save(cl);
    }

    public Client getClientbyMail(String email) {
        return clRepo.findByEmail(email);
}
}
