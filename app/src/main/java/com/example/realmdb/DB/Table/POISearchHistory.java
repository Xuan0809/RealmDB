package com.example.realmdb.DB.Table;

import io.realm.RealmModel;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class POISearchHistory extends RealmObject {

    protected String poi;

    public void setPoi(String POIjsonSt){ this.poi = POIjsonSt; }
    public String getPoi(){ return this.poi; }

}
