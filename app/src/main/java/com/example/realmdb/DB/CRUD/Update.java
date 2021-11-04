package com.example.realmdb.DB.CRUD;

import com.example.realmdb.DB.RealmManager;

import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Update {

    // 單一條件下,更新單筆資料
    public String UpdateData(Class obj,String fieldName,String value,String updatefield,String updatevalue) throws RealmException {

        String[] ValueAdapter = {value};
        String[] UpdatefieldAdapter = {updatefield};
        String[] UpdatevalueAdapter = {updatevalue};

        return UpdateData(obj,fieldName,ValueAdapter,UpdatefieldAdapter,UpdatevalueAdapter);
    }

    // 複數條件下,更新數筆資料
    public String UpdateData(Class obj, String fieldName, String[] value, String[] updatefield, String[] updatevalue) throws RealmException {

        String result = "Successed";

        // 開啟任務
        RealmManager.beginTransaction();

        RealmQuery Query = RealmManager.getRealm().where(obj);

        for (int i = 0 ; i < value.length ; i ++){
            Query = Query.contains(fieldName,value[i]);
        }

        // 尋找全部相符的
        RealmResults MyResult = Query.findAll();

        for (int i = 0 ; i < updatefield.length ; i++){
            MyResult.setString(updatefield[i],updatevalue[i]);
        }

        // 關閉任務
        RealmManager.commitTransaction();

        return result;
    }
}
