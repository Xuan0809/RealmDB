package com.example.realmdbtest.CycleDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class TripDetail extends RealmObject implements DBInterface {
    @PrimaryKey
    private int id; // Primary Key

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private int MissionID;

    public int getMissionID() {
        return MissionID;
    }
    public void setMissionID(int MissionID) { this.MissionID = MissionID; }

    private Date Date;
    private float longitude;
    private float latitude;
    private float Speed;

    public Date getDate() {return Date;}
    public void setDate(Date Date) {this.Date =Date;}

    public float getlongitude() {return  longitude;}
    public void setlongitude(float longitude) {this.longitude = longitude;}

    public float getlatitude() {return  latitude;}
    public void setlatitude(float latitude) { this.latitude = latitude;}

    public float getSpeed() {return Speed;}
    public void setSpeed(float Speed) {this.Speed =Speed; }

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
