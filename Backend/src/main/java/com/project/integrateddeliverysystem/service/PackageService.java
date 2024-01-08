package com.project.integrateddeliverysystem.service;

import com.project.integrateddeliverysystem.entity.Package;
import com.project.integrateddeliverysystem.repository.PackageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PackageService {

    @Autowired
    private PackageRepo packageRepo;

    public void savePackage(Package pack){
        packageRepo.save(pack);
    }

    public Package getPackage(String trackingNum) {
        return packageRepo.findById(trackingNum).get();
    }
}
