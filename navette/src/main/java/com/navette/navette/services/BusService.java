package com.navette.navette.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navette.navette.model.Bus;
import com.navette.navette.repository.BusRepository;

@Service
public class BusService {
    @Autowired
    private final BusRepository busRepo;

    public BusService(BusRepository busRepo) {
        this.busRepo = busRepo;
    }
    
    public void addBus(Bus bus){
        busRepo.save(bus);
    }

    public Optional<Bus> getBusInfo(String mat) {
            return busRepo.findById(mat);
    }

    public void removeBus(String mat){
        busRepo.deleteById(mat);
    }

    public List<Bus> getAllBusses(){
        return busRepo.findAll();
    }

    public void updateBus(Bus bus){
        busRepo.save(bus);
    }

}
