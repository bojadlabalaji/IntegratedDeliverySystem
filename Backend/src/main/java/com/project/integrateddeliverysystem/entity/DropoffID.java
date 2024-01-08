package com.project.integrateddeliverysystem.entity;

import java.io.Serializable;
import java.util.Objects;

public class DropoffID implements Serializable {

    private String tracking;

    private String storeID;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DropoffID)) return false;
        DropoffID dropoffID = (DropoffID) o;
        return getTracking().equals(dropoffID.getTracking()) && getStoreID().equals(dropoffID.getStoreID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTracking(), getStoreID());
    }
}
