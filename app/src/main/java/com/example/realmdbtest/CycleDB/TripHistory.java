package com.example.realmdbtest.CycleDB;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

// 騎乘歷史紀錄
public class TripHistory extends RealmObject implements DBInterface {
    @PrimaryKey
    private int id; // Primary Key

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    private int MissionID;

    public int getMissionID() {
        return MissionID;
    }
    public void setMissionID(int MissionID) { this.MissionID = MissionID; }

    private Date Date;
    private String TravleStart;
    private float Startlongitude;
    private float Startlatitude;
    private String TravelEnd;
    private float Endlongitude;
    private float Endlatitude;
    private String TripStart;
    private String TripEnd;
    private float TripDistance;
    private Date RidingTime;
    private Date Rpause;
    private Date TripTime;
    private float TMaxSpeed;
    private float TAVGSpeed;
    private float RAVGSpeed;




    public Date getDate() { return Date; }
    public void setDate(Date Date) { this.Date = Date; }

    public String getTravleStart() { return TravleStart; }
    public void setTravleStart(String TravleStart) { this.TravleStart = TravleStart; }

    public float getStartlongitude() { return Startlongitude; }
    public void setStartlongitude(float Startlongitude) { this.Startlongitude = Startlongitude; }

    public float getStartlatitude() { return Startlatitude; }
    public void setStartlatitude(float Startlatitude) { this.Startlatitude = Startlatitude; }

    public String getTravelEnd() { return TravelEnd; }
    public void setTravelEnd(String TravelEnd) { this.TravelEnd = TravelEnd; }

    public float getEndlongitude() { return Endlongitude; }
    public void setEndlongitude(float Endlongitude) { this.Endlongitude = Endlongitude; }

    public float getEndlatitude() { return Endlatitude; }
    public void setEndlatitude(float Endlatitude) { this.Endlatitude = Endlatitude; }

    public String getTripStart() { return TripStart; }
    public void setTripStart(String TripStart) { this.TripStart = TripStart; }

    public String getTripEnd() { return TripEnd; }
    public void setTripEnd(String TripEnd) { this.TripEnd = TripEnd; }

    public float getTripDistance() { return TripDistance; }
    public void setTripDistance(float TripDistance) { this.TripDistance = TripDistance; }

    public Date getRidingTime() { return RidingTime; }
    public void setRidingTime(Date RidingTime) { this.RidingTime = RidingTime; }

    public Date getRpause() { return Rpause; }
    public void setRpause(Date Rpause) { this.Rpause = Rpause; }

    public Date getTripTime() { return TripTime; }
    public void setTripTime(Date TripTime) { this.TripTime = TripTime; }

    public float getTMaxSpeed() { return TMaxSpeed; }
    public void setTMaxSpeed(float TMaxSpeed) { this.TMaxSpeed = TMaxSpeed; }

    public float getTAVGSpeed() { return TAVGSpeed; }
    public void setTAVGSpeed(float TAVGSpeed) { this.TAVGSpeed = TAVGSpeed; }

    public float getRAVGSpeed() { return RAVGSpeed; }
    public void setRAVGSpeed(float RAVGSpeed) { this.RAVGSpeed = RAVGSpeed; }

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

