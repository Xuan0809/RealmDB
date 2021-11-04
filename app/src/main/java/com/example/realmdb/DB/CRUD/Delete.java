package com.example.realmdb.DB.CRUD;

import com.example.realmdb.DB.RealmManager;
import com.example.realmdb.DB.Table.DBInterface;

import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Delete {

    // 條件下全刪
    public <T extends RealmObject> void DeleteAllData(Class<T> obj , DBInterface Interface,String fieldName,String value) throws RealmException {
        // 指定
        RealmQuery<T> MyQueue = RealmManager.getRealm().where(obj);
        // 找出欲刪除的資料
        RealmResults<T> MyResult = MyQueue.contains(fieldName, value).findAll();

        // 開啟任務
        RealmManager.beginTransaction();

        // 刪除所有搜尋出的資料
        MyResult.deleteAllFromRealm();

        // 關閉任務
        RealmManager.commitTransaction();
    }

    // 條件下第一筆
    public <T extends RealmObject> void DeleteFirstData(Class<T> obj , DBInterface Interface,String fieldName,String value) throws RealmException {
        // 指定
        RealmQuery<T> MyQueue = RealmManager.getRealm().where(obj);
        // 找出欲刪除的資料
        RealmResults<T> MyResult = MyQueue.contains(fieldName, value).findAll();

        // 開啟任務
        RealmManager.beginTransaction();

        // 刪除第一個資料
         MyResult.deleteFirstFromRealm();

        // 關閉任務
        RealmManager.commitTransaction();
    }

    // 清空 table
    public <T extends RealmObject> void TruncateTable(Class<T> obj , DBInterface Interface,String fieldName,String value) throws RealmException {
        // 指定
        RealmQuery<T> MyQueue = RealmManager.getRealm().where(obj);
        // 找出欲刪除的資料
        RealmResults<T> MyResult = MyQueue.contains(fieldName, value).findAll();

        // 開啟任務
        RealmManager.beginTransaction();

        // 清空 Table
        RealmManager.getRealm().deleteAll();

        // 關閉任務
        RealmManager.commitTransaction();
    }
}
