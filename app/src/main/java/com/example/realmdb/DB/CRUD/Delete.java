package com.example.realmdb.DB.CRUD;

import com.example.realmdb.DB.RealmManager;
import com.example.realmdb.DB.Table.DBInterface;

import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Delete {

    private Query query = new Query();

    // 單一條件下全刪
    public String DeleteAllData(Class obj, String fieldName, Object value) throws RealmException {

        String[] fieldNameAdapter = {fieldName};
        Object[] valueAdapter = {value};

        return DeleteAllData(obj, fieldNameAdapter, valueAdapter);
    }

    // 複數條件下全刪
    public String DeleteAllData(Class obj, String[] fieldName, Object[] value) throws RealmException {
        // 指定
        RealmQuery Query = RealmManager.getRealm().where(obj);

        // 找出欲刪除的資料
        RealmResults MyResult = query.SearchData(obj,fieldName,value);

        // 開啟任務
        RealmManager.beginTransaction();

        // 刪除所有搜尋出的資料
        MyResult.deleteAllFromRealm();

        // 關閉任務
        RealmManager.commitTransaction();

        return "Success Clear All Data";
    }

    // 條件下第一筆
    public String DeleteFirstData(Class obj, String fieldName, Object value) throws RealmException {

        String[] fieldNameAdapter = {fieldName};
        Object[] valueAdapter = {value};

        return DeleteAllData(obj, fieldNameAdapter, valueAdapter);
    }

    // 複數條件下第一筆
    public String DeleteFirstData(Class obj, String[] fieldName, Object[] value) throws RealmException {
        // 指定
        RealmQuery MyQueue = RealmManager.getRealm().where(obj);
        // 找出欲刪除的資料
        RealmResults MyResult = query.SearchData(obj,fieldName,value);

        // 開啟任務
        RealmManager.beginTransaction();

        // 刪除第一個資料
         MyResult.deleteFirstFromRealm();

        // 關閉任務
        RealmManager.commitTransaction();

        return "Success Clear First Data";
    }

    // 清空 table
    public String TruncateTable(Class obj , DBInterface Interface, String fieldName, String value) throws RealmException {
        // 指定
        RealmQuery MyQueue = RealmManager.getRealm().where(obj);
        // 找出欲刪除的資料
        RealmResults MyResult = query.SearchData(obj,fieldName,value);

        // 開啟任務
        RealmManager.beginTransaction();

        // 清空 Table
        RealmManager.getRealm().deleteAll();

        // 關閉任務
        RealmManager.commitTransaction();

        return "Success Truncate Table";
    }
}
