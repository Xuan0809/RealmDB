package com.example.realmdb.DB.Table;

import com.example.realmdb.DB.RealmManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RidingModeTime extends RealmObject {

    public RidingModeTime(){
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
    private int ModeId;
    private long Date;

    public int getModeId() { return ModeId; }
    public void setModeId(int ModeId) { this.ModeId = ModeId; }

    public long getDate() {return Date;}
    public void setDate(long Date) {this.Date=Date;}

}
