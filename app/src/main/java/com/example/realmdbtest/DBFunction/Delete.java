package com.example.realmdbtest.DBFunction;

import android.util.Log;

import com.example.realmdbtest.CycleDB.DBInterface;
import com.example.realmdbtest.CycleDB.RidingMode;

import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Delete {

    public void TestDelete(){
        // MapInfo info = new MapInfo();
        // info.setVersion("1.0.0");
        //  Insert(info);
    }

    // 刪除資料 For User
    public <T extends RealmObject> void DelData(Class<T> obj , DBInterface Interface,String fieldName,String value) throws RealmException {
        // 指定
        RealmQuery<T> MyQueue = RealmManager.getRealm().where(obj);
        // 找出欲刪除的資料
        RealmResults<T> MyResult = MyQueue.contains(fieldName, value).findAll();

        Log.d("TAG","Delete Something");
        // 開啟任務
        RealmManager.beginTransaction();

        // 以下四種針對搜尋出來的資料做刪除
        // MyResult.deleteFirstFromRealm(); // 刪除第一個資料
        // MyResult.deleteLastFromRealm(); // 刪除最後一個資料
        //MyResult.deleteFromRealm(); // 刪除位置 0 的資料
        MyResult.deleteAllFromRealm(); // 刪除所有搜尋出的資料

        // 針對 Table 做刪除
//         RealmManager.getRealm().delete(RidingMode.class);
        // 針對整個 DB 做刪除
        // realm.deleteAll();

        // 關閉任務
        RealmManager.commitTransaction();
    }


}
