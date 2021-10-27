package com.example.realmdbtest.DBFunction;

import com.example.realmdbtest.CycleDB.DBInterface;
import com.example.realmdbtest.CycleDB.MapInfo;

import java.util.UUID;

import io.realm.exceptions.RealmException;

public class Insert {

    public void TestInsert(){
        MapInfo info = new MapInfo();
        info.setVersion("1.0.0");
        Insert(info,1);
    }

    // 寫入資料
    public String Insert(DBInterface Interface,int pkid) throws RealmException {

        String result = "Successed";

        RealmManager.beginTransaction();
        DBInterface dbi = (DBInterface) RealmManager.getRealm().createObject(Interface.getType(), pkid);
        dbi.fromMap(Interface.toMap());
        RealmManager.commitTransaction(); // 創建結束

        // 寫入資料
/*        realm.beginTransaction(); // 創建開始
        // 因包含 pk id (不可變參數) 故新增時要在 class 後面加入
        TripHistory tripHistory = realm.createObject(TripHistory.class, UUID.randomUUID().toString());
        tripHistory.set("Sam");
        tripHistory.setEmail("Test789@luffydesign.com");*/
        //realm.commitTransaction();

        return result;
    }



}
