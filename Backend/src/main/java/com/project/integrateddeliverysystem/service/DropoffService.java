package com.project.integrateddeliverysystem.service;

import com.project.integrateddeliverysystem.entity.Dropoff;
import com.project.integrateddeliverysystem.repository.DropoffRepo;
import com.project.integrateddeliverysystem.util.TrackingDeatils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DropoffService {

    @Autowired
    private DropoffRepo dropoffRepo;

    public void saveDropoff(Dropoff dropoff) {
        dropoffRepo.save(dropoff);
    }

    public List<Dropoff> trackPackage(String trackingNum) {
        return dropoffRepo.findByTracking(trackingNum);
    }

    public List<List<String>> joinTablesAndFindByTracking(String tracking){
        return dropoffRepo.joinTablesAndFindByTracking(tracking);
    }
}
