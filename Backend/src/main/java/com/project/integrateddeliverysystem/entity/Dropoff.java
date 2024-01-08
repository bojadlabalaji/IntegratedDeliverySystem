package com.project.integrateddeliverysystem.entity;

import javax.persistence.*;

@Entity
@IdClass(DropoffID.class)
public class Dropoff {


    @Id
    private String tracking;
    @Id
    private String storeID;

    private String timeStamp;

    public Dropoff() {
    }

    public Dropoff(String tracking, String storeID, String timeStamp) {
        this.tracking = tracking;
        this.storeID = storeID;
        this.timeStamp = timeStamp;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
