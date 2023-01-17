package com.navette.navette.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.navette.navette.model.Client;
import com.navette.navette.services.ClientService;

import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;
import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Client")
public class ClientController {
    @Autowired
    private final ClientService clServ;
    public ClientController(ClientService clServ) {
        this.clServ = clServ;
    }
    
    @PostMapping("/addclient")
    public void createClient(@RequestBody Client cl){
        clServ.createClient(cl);
    }

    @PutMapping("/updateclient/{cin}")
    public void updateClient(@PathVariable String cin,@RequestBody Client cl){
        cl.setCIN(cin);
        clServ.updateClient(cl);
    }
    @PostMapping("/addSubscriptionClient/{cin}")
    public String addSubscriptionClient(@PathVariable String cin,@RequestBody Client cl,HttpServletRequest request){
        String rolesession=(String)request.getSession().getAttribute("role");
        String cinsession=(String)request.getSession().getAttribute("cin");
        if(cinsession!=null && rolesession!=null){
            cl.setCIN(cinsession);
            clServ.updateClient(cl);
            return "success";
        }else{
            return "login";
        }
        
    }

    @DeleteMapping("/deleteclient/{cin}")
    public void deleteClient(@PathVariable String cin){
        clServ.removeClient(cin);
    }
    
    @GetMapping("/getallclients")
    public List<Client> getAllClient() {
        return clServ.getAllClients();
    }

    @PostMapping("/getclient/{cin}")
    public Optional<Client> getClient(@PathVariable String cin){
        return clServ.getClientInfo(cin);
    }

    @PostMapping("/getclientbymail/{email}")
    public Client getClientByMail(@PathVariable String email){
        return clServ.getClientbyMail(email);
    }
    
    
}
