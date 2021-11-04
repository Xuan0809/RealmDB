package com.example.realmdb.DB.Table;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SoftwareInfo extends RealmObject implements DBInterface {
    @PrimaryKey
    private int id; // Primary Key

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String Version;
    private Date Date;

    public String getVersion() { return Version;}
    public void  setVersion(String Version) { this.Version =Version;}

    public Date getDate() { return Date;}
    public void setDate(Date Date) { this.Date = Date; }

    @Override
    public Map<String, Object> toMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("Version",Version);
        map.put("Date",Date);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        Version = (String) map.get("Version");
        Date = (Date) map.get("Date");
    }

    @Override
    public Class<SoftwareInfo> getType() {
        return SoftwareInfo.class;
    }
}
