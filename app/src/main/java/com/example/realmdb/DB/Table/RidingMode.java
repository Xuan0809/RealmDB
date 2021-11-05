package com.example.realmdb.DB.Table;

import java.util.HashMap;
import java.util.Map;

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

    private int Mode;
    private String Name;

    public int getMode() {return  Mode;}
    public void setMode(int RidingMode ) {this.Mode =RidingMode;}

    public String getName() {return  Name;}
    public void setName(String Name) {this.Name = Name;}

    @Override
    public Map<String, Object> toMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("Mode",Mode);
        map.put("Name",Name);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        Mode = (int) map.get("Mode");
        Name = (String) map.get("Name");
    }

    @Override
    public Class<RidingMode> getType() {
        return RidingMode.class;
    }
}
