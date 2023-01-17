package com.navette.navette.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navette.navette.model.Login;
import com.navette.navette.repository.LoginRepository;

@Service
public class LoginService {
    @Autowired
    private final LoginRepository logRepo;

    public LoginService(LoginRepository logRepo) {
        this.logRepo = logRepo;
    }


    public void addLogin(Login cl){
        logRepo.save(cl);
    }

    public Login getLoginRes(String email,String password) {
        return logRepo.findByEmailAndPassword(email,password);
    }

    public Optional<Login> getLoginInfo(String email) {
            return logRepo.findById(email);
    }

    public void removeLogin(String email){
        logRepo.deleteById(email);
    }

    public List<Login> getAllLogins(){
        return logRepo.findAll();
    }

    public void updateLogin(Login cl){
        logRepo.save(cl);
    }
}
