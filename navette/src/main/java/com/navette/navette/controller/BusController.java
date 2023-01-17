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

import com.navette.navette.model.Bus;
import com.navette.navette.services.BusService;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Bus")
public class BusController {
    @Autowired
    private final BusService busServ;

    public BusController(BusService busServ) {
        this.busServ = busServ;
    }

    @PostMapping("/addBus")
    public void addBus(@RequestBody Bus bus){
        busServ.addBus(bus);
    }

    @PutMapping("/updateBus/{mat}")
    public void updaClient(@PathVariable String mat,@RequestBody Bus bus){
        bus.setMatricule(mat);
        busServ.updateBus(bus);
    }

    @DeleteMapping("/deleteBus/{mat}")
    public void deleteBus(@PathVariable("mat") String mat){
        busServ.removeBus(mat);
    }
    
    @PostMapping("/getallBusses")
    public List<Bus> getAllBusses() {
        return busServ.getAllBusses();
    }

    @PostMapping("/getBus/{mat}")
    public Optional<Bus> getBus(@PathVariable String mat){
        return busServ.getBusInfo(mat);
    }

}
