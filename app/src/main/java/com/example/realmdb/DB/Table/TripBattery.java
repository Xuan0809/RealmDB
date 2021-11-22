package com.example.realmdb.DB.Table;

import com.example.realmdb.DB.RealmManager;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class TripBattery extends RealmObject{

    public TripBattery(){
        Number maxId =  RealmManager.getQuery().SearchFirstID(this.getClass());
        if (maxId == null) {
            this.id = 1;
        } else {
            this.id = maxId.intValue() + 1;
        }
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

    private int ControllerGear;
    private int ControllerRight;
    private int Ebike;
    private int CycleComputer;

    public int getControllerGear() {
        return ControllerGear;
    }
    public void setControllerGear(int ControllerGear) {
        this.ControllerGear = ControllerGear;
    }

    public int getControllerRight() {
        return ControllerRight;
    }
    public void setControllerRight(int ControllerRight) {
        this.ControllerRight = ControllerRight;
    }

    public int getEbike() {
        return Ebike;
    }
    public void setEbike(int Ebike) {
        this.Ebike = Ebike;
    }

    public int getCycleComputer() {
        return CycleComputer;
    }
    public void setCycleComputer(int CycleComputer) {
        this.CycleComputer = CycleComputer;
    }

}
