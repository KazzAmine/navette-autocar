package com.navette.navette.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class redirectRepo {
    
    @GetMapping("/login")
    public String goToLogin(){
        return "login";
    }
    
    @GetMapping("/registrationClient")
    public String registrationClient(){
        return "registrationClient";
    }

    @GetMapping("/registrationSociete")
    public String registrationSociete(){
        return "registrationSociete";
    }
    @GetMapping("/ListAbonnement/{heuredep}/{villedep}/{villearr}")
    public String ListAbonnement(@PathVariable String heuredep,@PathVariable String villedep,@PathVariable String villearr,RedirectAttributes  redirectAttributes){
        redirectAttributes.addAttribute("heuredep", heuredep);
        redirectAttributes.addAttribute("villedep", villedep);
        redirectAttributes.addAttribute("villearr", villearr);
        return "ListAbonnement";
    }

    @GetMapping("/clientProfile/{cin}")
    public String clientprofile(@PathVariable String cin,RedirectAttributes  redirectAttributes,HttpServletRequest request){
        String cinClient=(String)request.getSession().getAttribute("cin");
        redirectAttributes.addAttribute("cin",cinClient);
        return "clientProfile";
    }
    @GetMapping("/societeProfile/{socid}")
    public String societeProfile(@PathVariable String socid,RedirectAttributes  redirectAttributes,HttpServletRequest request){
        socid=(String)request.getSession().getAttribute("cin");
        redirectAttributes.addAttribute("socId",socid);
        return "societeProfile";
    }
    
    @GetMapping("/subInfo/{subId}")
    public String subscripInfo(@PathVariable String subId,RedirectAttributes  redirectAttributes,HttpServletRequest request){
        if(request.getSession().getAttribute("cin")!=null){
            redirectAttributes.addAttribute("subId", subId);
            return "ValidateAbonnement";
        }else{
            return "login"; 
        } 
    }

    @GetMapping("/offres/{socid}")
    public String goToOffres(@PathVariable String socid,RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("socid",socid);
        return "offres";
    }
}
