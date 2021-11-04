package com.example.realmdb.DB.Table;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

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
        Map<String,Object> map = new HashMap<>();
        map.put("MissionID",MissionID);
        map.put("Date",Date);
        map.put("longitude",longitude);
        map.put("latitude",latitude);
        map.put("Speed",Speed);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        MissionID = (int) map.get("MissionID");
        Date = (Date) map.get("Date");
        longitude = (float) map.get("longitude");
        latitude = (float) map.get("latitude");
        Speed = (float) map.get("Speed");
    }

    @Override
    public Class<TripDetail> getType() {
        return TripDetail.class;
    }
}
