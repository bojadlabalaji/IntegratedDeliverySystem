package com.project.integrateddeliverysystem.controller;

import com.project.integrateddeliverysystem.entity.Dropoff;
import com.project.integrateddeliverysystem.service.DropoffService;
import com.project.integrateddeliverysystem.service.PackageService;
import com.project.integrateddeliverysystem.util.TrackingDeatils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DropoffController {

    @Autowired
    private DropoffService dropoffService;

    private PackageService packageService;

    @PostMapping("/saveDropoff")
    private void saveDropoff(@RequestBody Dropoff dropoff){
        dropoffService.saveDropoff(dropoff);
    }

    @GetMapping("/trackPackage")
    private List<List<String>> trackPackage(@RequestParam("trackingNum") String trackingNum){
        return dropoffService.joinTablesAndFindByTracking(trackingNum);
    }


}
