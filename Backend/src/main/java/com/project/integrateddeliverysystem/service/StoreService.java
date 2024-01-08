package com.project.integrateddeliverysystem.service;

import com.project.integrateddeliverysystem.entity.Store;
import com.project.integrateddeliverysystem.repository.StoreRepo;
import com.project.integrateddeliverysystem.util.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreService {
    @Autowired
    private StoreRepo storeRepo;

    public boolean storeLogin(Login login) throws Exception {
        System.out.println(login.getUsername());
        Store store = storeRepo.findById(login.getUsername()).get();
        if(store.getPassword().equals(login.getPassword())){
           return true;
        }else{
            return false;
        }
    }


}
