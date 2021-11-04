package com.example.realmdb.DB.Table;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

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
        Map<String,Object> map = new HashMap<>();
        map.put("MissionID",MissionID);
        map.put("Date",Date);
        map.put("TravleStart",TravleStart);
        map.put("Startlongitude",Startlongitude);
        map.put("Startlatitude",Startlatitude);
        map.put("TravelEnd",TravelEnd);
        map.put("Endlongitude",Endlongitude);
        map.put("Endlatitude",Endlatitude);
        map.put("TripStart",TripStart);
        map.put("TripEnd",TripEnd);
        map.put("TripDistance",TripDistance);
        map.put("RidingTime",RidingTime);
        map.put("Rpause",Rpause);
        map.put("TripTime",TripTime);
        map.put("TMaxSpeed",TMaxSpeed);
        map.put("TAVGSpeed",TAVGSpeed);
        map.put("RAVGSpeed",RAVGSpeed);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        MissionID = (int) map.get("MissionID");
        Date = (Date) map.get("Date");
        TravleStart = (String) map.get("TravleStart");
        Startlongitude = (float) map.get("Startlongitude");
        Startlatitude = (float) map.get("Startlatitude");
        TravelEnd = (String) map.get("TravelEnd");
        Endlongitude = (float) map.get("Endlongitude");
        Endlatitude = (float) map.get("Endlatitude");
        TripStart = (String) map.get("TripStart");
        TripEnd = (String) map.get("TripEnd");
        TripDistance = (float) map.get("TripDistance");
        RidingTime = (Date) map.get("RidingTime");
        Rpause = (Date) map.get("Rpause");
        TripTime = (Date) map.get("TripTime");
        TMaxSpeed = (float) map.get("TMaxSpeed");
        TAVGSpeed = (float) map.get("TAVGSpeed");
        RAVGSpeed = (float) map.get("RAVGSpeed");
    }

    @Override
    public Class<TripHistory> getType() {
        return TripHistory.class;
    }
}

