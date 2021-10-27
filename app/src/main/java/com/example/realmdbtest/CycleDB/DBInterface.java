package com.example.realmdbtest.CycleDB;

import java.util.Map;

import io.realm.RealmObject;

public interface DBInterface {

    Map<String,Object> toMap();

    void fromMap(Map<String,Object> map);

    Class<? extends RealmObject> getType();
}
