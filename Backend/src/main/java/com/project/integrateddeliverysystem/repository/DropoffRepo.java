package com.project.integrateddeliverysystem.repository;

import com.project.integrateddeliverysystem.entity.Dropoff;
import com.project.integrateddeliverysystem.entity.DropoffID;
import com.project.integrateddeliverysystem.util.TrackingDeatils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DropoffRepo extends JpaRepository<Dropoff, DropoffID> {
    List<Dropoff> findByTracking(String tracking);// Select * from Dropoff where tracking = ?;

    @Query(value = "select tracking, Dropoff.storeid as storeid, location, name, time_stamp" +
            " from Dropoff join Store on Dropoff.storeid = Store.storeid where Dropoff.tracking=?"+";", nativeQuery = true)
    List<List<String>> joinTablesAndFindByTracking(String Tracking);
}
