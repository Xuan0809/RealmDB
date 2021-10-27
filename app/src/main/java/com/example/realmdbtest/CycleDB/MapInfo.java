package com.example.realmdbtest.CycleDB;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MapInfo extends RealmObject implements DBInterface {
    @PrimaryKey
    private int id; // Primary Key

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String Version;
    private Date UpdateDate;

    public String getVersion() { return Version;}
    public void  setVersion(String Version) { this.Version =Version;}

    public Date getUpdateDate() { return UpdateDate;}
    public void setUpdateDate(Date UpdateDate) { this.UpdateDate = UpdateDate; }

    @Override
    public Map<String, Object> toMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("Version",Version);
        map.put("UpdateDate",UpdateDate);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        Version = (String) map.get("Version");
        UpdateDate = (Date) map.get("UpdateDate");
    }

    @Override
    public Class<MapInfo> getType() {
        return MapInfo.class;
    }
}
