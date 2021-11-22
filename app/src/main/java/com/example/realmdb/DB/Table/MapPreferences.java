package com.example.realmdb.DB.Table;

import io.realm.RealmModel;
import io.realm.RealmObject;

public class MapPreferences extends RealmObject {

    private String location;
    private float longitude;
    private float latitude;

    public String getlocation() { return location;}
    public void setlocation(String location) { this.location = location;}

    public float getlongitude() { return longitude;}
    public void setlongitude(float longitude) { this.longitude =longitude;}

    public float getlatitude() { return latitude;}
    public void setlatitude(float latitude) { this.latitude = latitude;}

}
