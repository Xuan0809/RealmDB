package com.example.realmdb.DB.Table;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RidingModeTime extends RealmObject implements DBInterface {
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

    // Foreign key RidingMode
    private RealmList<RidingMode> RidingMode;
    private Date Date;

    public RealmList<RidingMode> getRidingMode() { return RidingMode; }
    public void setRidingMode(RealmList<RidingMode> RidingMode) { this.RidingMode = RidingMode; }

    public Date getDate() {return Date;}
    public void setDate(Date Date) {this.Date=Date;}

    @Override
    public Map<String, Object> toMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("MissionID",MissionID);
        map.put("RidingMode",RidingMode);
        map.put("Date",Date);
        return map;
    }

    @Override
    public void fromMap(Map<String, Object> map) {
        MissionID = (int) map.get("MissionID");
        RidingMode = (RealmList<RidingMode>) map.get("RidingMode");
        Date = (Date) map.get("Date");
    }

    @Override
    public Class<RidingModeTime> getType()  {
        return RidingModeTime.class;
    }
}
