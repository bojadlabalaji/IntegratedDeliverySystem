package com.project.integrateddeliverysystem.controller;

import com.project.integrateddeliverysystem.entity.Package;
import com.project.integrateddeliverysystem.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageController {

    @Autowired
    private PackageService packageService;

    @PostMapping("/savePackage")
    private void savePackage(@RequestBody Package pack){
        packageService.savePackage(pack);
    }

    @GetMapping("/getPackage")
    private Package getPackage(@RequestParam("trackingNum") String trackingNum){
        return packageService.getPackage(trackingNum);
    }

}
