package com.example.realmdb.DB.Table;

import java.util.Date;
import java.util.HashMap;
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
        Map<String,Object> map = new HashMap<>();
        map.put("BikeUID",BikeUID);
        map.put("UsedTime",UsedTime);
        map.put("RidingTime",RidingTime);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        BikeUID = (String) map.get("BikeUID");
        UsedTime = (Date) map.get("UsedTime");
        RidingTime = (Date) map.get("RidingTime");
    }

    @Override
    public Class<SystemStatus> getType() {
        return SystemStatus.class;
    }
}
