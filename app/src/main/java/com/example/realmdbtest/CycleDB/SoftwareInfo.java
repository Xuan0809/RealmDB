package com.example.realmdbtest.CycleDB;

import java.io.Serializable;
import java.util.Date;
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
