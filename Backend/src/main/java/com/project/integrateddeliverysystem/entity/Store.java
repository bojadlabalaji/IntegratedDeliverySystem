package com.project.integrateddeliverysystem.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Store {

    @Id
    private String storeID;
    private String name;
    private String location;
    private String password;

    public Store() {
    }

    public Store(String storeID, String name, String location,  String password) {
        this.storeID = storeID;
        this.name = name;
        this.location = location;
        this.password = password;
    }

    public String getStoreID() {
        return storeID;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
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


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
