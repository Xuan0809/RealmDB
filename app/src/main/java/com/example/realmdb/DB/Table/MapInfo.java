package com.example.realmdb.DB.Table;

import com.example.realmdb.DB.RealmManager;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class MapInfo extends RealmObject {

    public MapInfo(){
        Number maxId =  RealmManager.getQuery().SearchFirstID(this.getClass());
        if (maxId == null) {
            this.id = 1;
        } else {
            this.id = maxId.intValue() + 1;
        }

        this.UpdateDate = System.currentTimeMillis();
    }

    @PrimaryKey
    private int id; // Primary Key

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String Version;
    private long UpdateDate;

    public String getVersion() { return Version;}
    public void  setVersion(String Version) { this.Version =Version;}

    public long getUpdateDate() { return UpdateDate;}
    public void setUpdateDate(long UpdateDate) { this.UpdateDate = UpdateDate; }

}
