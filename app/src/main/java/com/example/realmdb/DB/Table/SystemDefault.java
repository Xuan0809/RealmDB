package com.example.realmdb.DB.Table;

import com.example.realmdb.DB.RealmManager;

import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class SystemDefault extends RealmObject  {

    public SystemDefault(){
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
}
