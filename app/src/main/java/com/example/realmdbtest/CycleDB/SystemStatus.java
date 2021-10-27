package com.example.realmdbtest.CycleDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SystemStatus extends RealmObject implements DBInterface {
    @PrimaryKey
    private int id; // Primary Key

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String BikeUID;
    private Date UsedTime;
    private Date RidingTime;

    public String getBikeUID() {return  BikeUID;}
    public void setBikeUID(String BikeUID) {this.BikeUID = BikeUID;}

    public Date getUsedTime() {return UsedTime;}
    public void setUsedTime(Date UsedTime) { this.UsedTime = UsedTime;}

    public Date getRidingTime() { return  RidingTime;}
    public void  setRidingTime(Date RidingTime) {this.RidingTime = RidingTime;}

    @Override
    public Map<String, Object> toMap() {
        return null;
    }

    @Override
    public void fromMap(Map<String, Object> map) {

    }

    @Override
    public Class<? extends RealmObject> getType() {
        return null;
    }
}
