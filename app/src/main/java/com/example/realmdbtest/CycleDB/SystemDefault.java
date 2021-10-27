package com.example.realmdbtest.CycleDB;

import java.io.Serializable;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SystemDefault extends RealmObject implements DBInterface {
    @PrimaryKey
    private int id; // Primary Key

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String User;
    private boolean LightStatus;
    private int BackLightLevel;
    private int LightMode;
    private int BackgroundMode;
    private int RidingMode;
    private int GearPosition;
    private String Unit;

    public String getUser() { return User; }
    public void setUser(String User) { this.User = User; }

    public boolean getLightStatus() {return LightStatus;}
    public void setLightStatus(boolean LightStatus) {this.LightStatus = LightStatus;}

    public int getBackLightLevel() {
        return BackLightLevel;
    }
    public void setBackLightLevel(int BackLightLevel) { this.BackLightLevel = BackLightLevel; }

    public int getLightMode() {
        return LightMode;
    }
    public void setLightMode(int LightMode) { this.LightMode = LightMode; }

    public int getBackgroundMode() { return BackgroundMode; }
    public void seetBackgroundMode(int BackgroundMode) { this.BackgroundMode = BackgroundMode; }

    public int getRidingMode() { return RidingMode; }
    public void setRidingMode(int RidingMode) { this.RidingMode = RidingMode; }

    public int getGearPosition() { return GearPosition; }
    public void setGearPosition(int GearPosition) { this.GearPosition = GearPosition; }

    public String getUnit() {return Unit;}
    public void setUnit(String Unit) {this.Unit = Unit;}

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
