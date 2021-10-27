package com.example.realmdbtest.DBFunction;

import com.example.realmdbtest.CycleDB.DBInterface;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Update {

    public void TestUpdate(){
//        MapInfo info = new MapInfo();
//        info.setVersion("1.0.0");
//        Insert(info);
    }

    public <T extends RealmObject>void UpdateData(Class<T> obj, DBInterface Interface,String fieldName,String value,String updatefield,String updatevalue) throws RealmException {

        // 開啟任務
        RealmManager.beginTransaction();
//        // 尋找第一個達到條件的
//        user = realm.where(User.class).contains("username", "Sam").findFirst();
//        // 修改成如下
//        user.setUsername("SamHuang");
//        user.setEmail("NewEmail@yahoo.com.tw");

        // 尋找全部相符的 ( username include Sam)
        RealmResults<T> MyResult = RealmManager.getRealm().where(obj).contains(fieldName,value).findAll();
        MyResult.setString(updatefield,updatevalue);

        // 關閉任務
        RealmManager.commitTransaction();
    }
}
