package com.navette.navette.controller;


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

import com.navette.navette.model.Login;
import com.navette.navette.services.LoginService;

import jakarta.servlet.http.HttpServletRequest;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/Login")
public class LoginController {
    @Autowired
    private final LoginService logSer;
    public LoginController(LoginService logSer) {
        this.logSer = logSer;
    }
    
    @PostMapping("/addLog")
    public void addLogin(@RequestBody Login logInfo){
        logSer.addLogin(logInfo);
    }

    @PutMapping("/updateLogin/{email}")
    public void updaLogin(@PathVariable String email,@RequestBody Login log){
        log.setEmail(email);
        logSer.updateLogin(log);
    }

    @DeleteMapping("/deleteLog/{email}")
    public void deleteLogin(@PathVariable("email") String email){
        logSer.removeLogin(email);
    }
    
    @PostMapping("/createSess/{role}/{cin}")
    public String createSession(@PathVariable String role,@PathVariable String cin,HttpServletRequest request) {
		String roleSession =(String) request.getSession().getAttribute("role");
		if (roleSession == null) {
			roleSession = role;
			request.getSession().setAttribute("role", roleSession);
            request.getSession().setAttribute("cin", cin);
		}		
        //System.out.println(request.getSession().getAttribute("cin"));
        return (String)request.getSession().getAttribute("role");
    }

    @PostMapping("/destroySess")
    public String destroySessions(HttpServletRequest request){
        String roleSession =(String) request.getSession().getAttribute("role");
		if (roleSession != null) {
			request.getSession().removeAttribute("role");
            request.getSession().removeAttribute("cin");
			
		}		
        // System.out.println(request.getSession().getAttribute("cin"));
        // System.out.println("session destroyed");
        return "session destroyed";
    }

    @PostMapping("/getSess")
    public String getSessions(HttpServletRequest request){
        String roleSession =(String) request.getSession().getAttribute("role");
        String logSession =(String) request.getSession().getAttribute("cin");		
        return logSession;
    }

    @PostMapping("/getLogin/{email}")
    public Optional<Login> getLogin(@PathVariable String email){
        return logSer.getLoginInfo(email);
    }

    @PostMapping("/getLoginResult/{email}/{password}")
    public Login getlogres(@PathVariable String email,@PathVariable String password){
        return logSer.getLoginRes(email,password);
    }
    
}
