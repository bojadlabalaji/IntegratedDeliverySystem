package com.project.integrateddeliverysystem.util;

import javax.persistence.Id;

public class TrackingDeatils {


    private String tracking;
    private String storeID;
    private String time_stamp;
    private String name;
    private String location;

    public TrackingDeatils() {
    }

    public TrackingDeatils(String tracking, String storeID, String timeStamp, String name, String location) {
        this.tracking = tracking;
        this.storeID = storeID;
        this.time_stamp = timeStamp;
        this.name = name;
        this.location = location;
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

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
