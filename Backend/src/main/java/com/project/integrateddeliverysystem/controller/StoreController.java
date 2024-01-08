package com.project.integrateddeliverysystem.controller;

import com.project.integrateddeliverysystem.service.StoreService;
import com.project.integrateddeliverysystem.util.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/login")
    private boolean storeLogin(@RequestBody Login login) {
        try{
            return storeService.storeLogin(login);
        }catch(Exception e){
            System.out.println("Login Exception Occurr");
        }

        return false;
    }
}
