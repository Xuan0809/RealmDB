package com.example.realmdb.DB.Table;

import com.example.realmdb.DB.RealmManager;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class POI extends RealmObject {

    public POI(){
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

    private RealmList<POISearchHistory> POISearchHistory;
    private RealmList<MapPreferences> MapPreferences;

    protected long Date;

    public RealmList<POISearchHistory> getPOISearchHistory() { return POISearchHistory; }
    public void setPOISearchHistory(RealmList<POISearchHistory> POISearchHistory) { this.POISearchHistory = POISearchHistory; }

    public RealmList<MapPreferences> getMapPreferences() { return MapPreferences; }
    public void setMapPreferences(RealmList<MapPreferences> MapPreferences) { this.MapPreferences = MapPreferences; }

    public long getDate(){ return this.Date; }
    public void setDate(long date){ this.Date = Date; }
}


