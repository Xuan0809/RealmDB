package com.example.realmdbtest.CycleDB;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RidingMode extends RealmObject implements DBInterface {
    @PrimaryKey
    private int id; // Primary Key

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private int RidingMode;
    private String Name;

    public int getRidingMode() {return  RidingMode;}
    public void setRidingMode(int RidingMode ) {this.RidingMode =RidingMode;}

    public String getName() {return  Name;}
    public void setName(String Name) {this.Name = Name;}

    @Override
    public Map<String, Object> toMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("RidingMode",RidingMode);
        map.put("Name",Name);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        RidingMode = (int) map.get("RidingMode");
        Name = (String) map.get("Name");
    }

    @Override
    public Class<? extends RealmObject> getType() {
        return RidingMode.class;
    }
}
