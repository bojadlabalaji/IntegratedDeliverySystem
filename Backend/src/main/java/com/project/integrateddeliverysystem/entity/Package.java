package com.project.integrateddeliverysystem.entity;
import javax.persistence.*;

@Entity
public class Package {

    @Id
    private String tracking;


    private String fromUserId;


    private String toUserId;
    private String dimensions;
    private String weight;
    private String insurance;
    private String cost;
    private String type;

    private String description;
    private String storeId;
    private String estDate;
    private String actDate;
    private String createdTimeStamp;
    private String status;

    public Package() {
    }

    public Package(String tracking, String fromUserId, String toUserId, String dimensions, String weight, String insurance, String cost, String type, String description, String storeId, String estDate, String actDate, String createdTimeStamp, String status) {
        this.tracking = tracking;
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.dimensions = dimensions;
        this.weight = weight;
        this.insurance = insurance;
        this.cost = cost;
        this.type = type;
        this.description = description;
        this.storeId = storeId;
        this.estDate = estDate;
        this.actDate = actDate;
        this.createdTimeStamp = createdTimeStamp;
        this.status = status;
    }

    public String getTracking() {
        return tracking;
    }

    public void setTracking(String tracking) {
        this.tracking = tracking;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getEstDate() {
        return estDate;
    }

    public void setEstDate(String estDate) {
        this.estDate = estDate;
    }

    public String getActDate() {
        return actDate;
    }

    public void setActDate(String actDate) {
        this.actDate = actDate;
    }

    public String getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(String createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
