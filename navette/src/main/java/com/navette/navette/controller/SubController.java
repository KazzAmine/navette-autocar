package com.navette.navette.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navette.navette.model.Bus;
import com.navette.navette.model.Societe;
import com.navette.navette.model.Subscription;
import com.navette.navette.repository.SocieteRepository;
import com.navette.navette.services.BusService;
import com.navette.navette.services.SocieteService;
import com.navette.navette.services.SubService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Subscription")
public class SubController {
    @Autowired
    private final SubService subServ;

    @Autowired
    private final SocieteService socServ;
    @Autowired
    private final BusService busServ;
    public SubController(SubService subServ,SocieteService socServ,BusService busServ) {
        this.subServ = subServ;
        this.socServ=socServ;
        this.busServ=busServ;
    }

    @PostMapping("/addsubscription/{socid}/{busmatr}")
    public void createSubscription(@RequestBody Subscription sub,@PathVariable String socid,@PathVariable String busmatr){
        Optional<? extends Societe> soc=socServ.getsocieteInfo(socid);
        sub.setSociete(soc.get());
        Optional<? extends Bus> bus=busServ.getBusInfo(busmatr);
        sub.setMinibus(bus.get());
        subServ.addSubs(sub);
    }

    @PutMapping("/updatesubscription/{SubId}")
    public void updateSubscription(@PathVariable String SubId,@RequestBody Subscription sub){
        sub.setIdSubs(SubId);
        subServ.updateSub(sub);
    }

    @DeleteMapping("/deletesubscription/{subid}")
    public void deleteSubscription(@PathVariable String subid){
        subServ.removeSub(subid);
    }
    
    @PostMapping("/getallsubscriptions/{heuredep}/{villedep}/{villearr}")
    public List<Subscription> getAllSubscriptions(@PathVariable String heuredep,@PathVariable String villedep,@PathVariable String villearr) {
        return subServ.getAllSubs(heuredep,villedep,villearr);
    }
    @GetMapping("/getallsubscription")
    public List<Subscription> getAllSubscription() {
        return subServ.getall();
    }

    @PostMapping("/getsubscriptionInfo/{subid}")
    public Optional<Subscription> getSubscription(@PathVariable String subid){
        return subServ.getSubInfo(subid);
    }

    // @PostMapping("/getsubscriptionbysoc/{societe}")
    // public Optional<Subscription> getsubscriptionbysoc(@PathVariable String subid){
    //     return subServ.getSubInfo(subid);
    // }


    @PostMapping("/getsubscriptionbysoc/{societeid}")
    public ResponseEntity<List<Subscription>> getAllSubscriptionBySicuete(@PathVariable(value = "societeid") String societeid) {
  
      List<Subscription> subscriptionss = subServ.getSubBySociete(societeid);
      return new ResponseEntity<>(subscriptionss, HttpStatus.OK);
    }
    
}
