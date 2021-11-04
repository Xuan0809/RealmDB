package com.example.realmdb.DB.Table;

import java.util.Map;

import io.realm.RealmObject;

public interface DBInterface {

    Map<String,Object> toMap();

    void fromMap(Map<String,Object> map);

    Class<? extends RealmObject> getType();
}
