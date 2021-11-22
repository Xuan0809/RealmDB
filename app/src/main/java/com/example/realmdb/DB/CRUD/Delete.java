package com.example.realmdb.DB.CRUD;

import com.example.realmdb.DB.RealmManager;
import com.example.realmdb.DB.Table.DBInterface;

import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Delete {

    // 單一條件下全刪 ( 含搜尋 )
    public String SearchAndDeleteAllData(Class obj, String fieldName, Object value) throws RealmException {

        String[] fieldNameAdapter = {fieldName};
        Object[] valueAdapter = {value};

        return SearchAndDeleteAllData(obj, fieldNameAdapter, valueAdapter);
    }

    // 複數條件下全刪 ( 含搜尋 )
    public String SearchAndDeleteAllData(Class obj, String[] fieldName, Object[] value) throws RealmException {

        // 找出欲刪除的資料
        RealmResults MyResult = RealmManager.getQuery().SearchData(obj,fieldName,value);

        // 開啟任務
        RealmManager.beginTransaction();

        // 刪除所有搜尋出的資料
        MyResult.deleteAllFromRealm();

        // 關閉任務
        RealmManager.commitTransaction();

        return "Success Clear All Data";
    }

    // 條件下第一筆 ( 含搜尋 )
    public String SearchAndDeleteFirstData(Class obj, String fieldName, Object value) throws RealmException {

        String[] fieldNameAdapter = {fieldName};
        Object[] valueAdapter = {value};

        return SearchAndDeleteFirstData(obj, fieldNameAdapter, valueAdapter);
    }

    // 複數條件下第一筆 ( 含搜尋 )
    public String SearchAndDeleteFirstData(Class obj, String[] fieldName, Object[] value) throws RealmException {

        // 找出欲刪除的資料
        RealmResults MyResult = RealmManager.getQuery().SearchData(obj,fieldName,value);

        // 開啟任務
        RealmManager.beginTransaction();

        // 刪除第一個資料
        MyResult.deleteFirstFromRealm();

        // 關閉任務
        RealmManager.commitTransaction();

        return "Success Clear First Data";
    }

    public void DeleteAllResult(RealmResults result){

        RealmManager.beginTransaction();

        result.deleteAllFromRealm();

        RealmManager.commitTransaction();
    }

    public void DeleteResultFromIndex(RealmResults result,Integer location){

        RealmManager.beginTransaction();

        result.deleteFromRealm(location);

        RealmManager.commitTransaction();
    }

    public void DeleteFirstResult(RealmResults result ){

        RealmManager.beginTransaction();

        result.deleteFirstFromRealm();

        RealmManager.commitTransaction();
    }

    public void DeleteLastResult(RealmResults result ){

        RealmManager.beginTransaction();

        result.deleteLastFromRealm();

        RealmManager.commitTransaction();
    }

    public void Delete(RealmObject object){

        RealmManager.beginTransaction();

        object.deleteFromRealm();

        RealmManager.commitTransaction();
    }

    // 清空 table
    public String TruncateTable(Class obj , DBInterface Interface, String fieldName, String value) throws RealmException {
        // 開啟任務
        RealmManager.beginTransaction();

        // 清空 Table
        RealmManager.getRealm().deleteAll();

        // 關閉任務
        RealmManager.commitTransaction();

        return "Success Truncate Table";
    }
}

