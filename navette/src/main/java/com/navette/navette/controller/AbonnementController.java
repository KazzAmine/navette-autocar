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

import com.navette.navette.model.Abonnement;
import com.navette.navette.model.Client;
import com.navette.navette.model.Subscription;
import com.navette.navette.services.AbonnementService;
import com.navette.navette.services.ClientService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Abonnement")
public class AbonnementController {
    @Autowired
    private final AbonnementService abnServ;
    @Autowired
    private final ClientService clServ;
    public AbonnementController(AbonnementService abnServ,ClientService clServ) {
        this.abnServ = abnServ;
        this.clServ=clServ;
    }

    @PostMapping("/addAbonnement")
    public Optional<Client> addAbonnement(@RequestBody Abonnement ab,HttpServletRequest request){
        Client cl=new Client();
        String cin=(String)request.getSession().getAttribute("cin");
        cl.setCIN(cin);
        Abonnement abon=ab;
        abon.setCl(cl);
        abnServ.addAbonnement(abon);
        Optional<Client> cll=clServ.getClientInfo(cin);
        
        return cll;
    }

    @PutMapping("/updateAbonnement/{abid}")
    public void updateAbonnement(@PathVariable int abid,@RequestBody Abonnement ab){
        ab.setAbonnementId(abid);
        abnServ.updateAbonnement(ab);
    }

    @DeleteMapping("/deleteAbonnement/{abid}")
    public void deleteAbonnement(@PathVariable int abid){
        abnServ.removeAbonnemnt(abid);
    }
    
    @PostMapping("/getallabonnement")
    public List<Abonnement> getallabonnement() {
        return abnServ.getAllAbonnemnt();
    }

    @PostMapping("/getabonnementinfo/{abnid}")
    public Abonnement getSubscription(@PathVariable int abnid,@RequestBody Client client,HttpServletRequest request){
        String cin=(String)request.getSession().getAttribute("cin");
        client.setCIN(cin);
        return abnServ.getAbonnementInfo(client);
    }

    @PostMapping("/getabonnementbyclient/{clientcin}")
    public ResponseEntity<List<Abonnement>> getabonnementbyclient(@PathVariable(value = "clientcin") String clientcin) {
  
      List<Abonnement> abonnementss = abnServ.getabonnementbyclient(clientcin);
      return new ResponseEntity<>(abonnementss, HttpStatus.OK);
    }
}
