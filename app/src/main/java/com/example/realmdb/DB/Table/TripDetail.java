package com.example.realmdb.DB.Table;

import com.example.realmdb.DB.RealmManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TripDetail extends RealmObject {

    public TripDetail(){
        Number maxId =  RealmManager.getQuery().SearchFirstID(this.getClass());
        if (maxId == null) {
            this.id = 1;
        } else {
            this.id = maxId.intValue() + 1;
        }

        this.Date = System.currentTimeMillis();
    }

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

    private long Date;
    private float longitude;
    private float latitude;
    private float Speed;

    public long getDate() {return Date;}
    public void setDate(long Date) {this.Date =Date;}

    public float getlongitude() {return  longitude;}
    public void setlongitude(float longitude) {this.longitude = longitude;}

    public float getlatitude() {return  latitude;}
    public void setlatitude(float latitude) { this.latitude = latitude;}

    public float getSpeed() {return Speed;}
    public void setSpeed(float Speed) {this.Speed =Speed; }
}
