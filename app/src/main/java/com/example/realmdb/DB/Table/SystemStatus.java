package com.example.realmdb.DB.Table;

import com.example.realmdb.DB.RealmManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SystemStatus extends RealmObject  {

    public SystemStatus(){
        Number maxId =  RealmManager.getQuery().SearchFirstID(this.getClass());
        if (maxId == null) {
            this.id = 1;
        } else {
            this.id = maxId.intValue() + 1;
        }
    }

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

}
