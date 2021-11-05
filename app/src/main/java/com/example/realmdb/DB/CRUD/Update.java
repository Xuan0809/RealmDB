package com.example.realmdb.DB.CRUD;

import com.example.realmdb.DB.RealmManager;

import java.util.Date;

import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Update {

    private Query query = new Query();

    // 單一條件下,更新單筆資料
    public String UpdateData(Class obj, String fieldName, Object value, String updatefield, Object updatevalue) throws RealmException {

        String[] fieldNameAdapter = {fieldName};
        Object[] ValueAdapter = {value};
        String[] UpdatefieldAdapter = {updatefield};
        Object[] UpdatevalueAdapter = {updatevalue};

        return UpdateData(obj, fieldNameAdapter, ValueAdapter, UpdatefieldAdapter, UpdatevalueAdapter);
    }

    // 複數條件下,更新數筆資料
    public String UpdateData(Class obj, String[] fieldName, Object[] value, String[] updatefield, Object[] updatevalue) throws RealmException {

        String result = "Successed";

        // 開啟任務
        RealmManager.beginTransaction();

        // 找出欲刪除的資料
        RealmResults MyResult = query.SearchData(obj,fieldName,value);

        for (int f = 0; f < updatefield.length; f++) {

            if (updatevalue[f] instanceof String) {
                MyResult.setString(updatefield[f], updatevalue[f].toString());
            } else if (updatevalue[f] instanceof Integer) {
                MyResult.setInt(updatefield[f], (int) updatevalue[f]);
            } else if (updatevalue[f] instanceof Float) {
                MyResult.setFloat(updatefield[f], (float) updatevalue[f]);
            } else if (updatevalue[f] instanceof Date) {
                MyResult.setDate(updatefield[f], (Date) updatevalue[f]);
            }
        }

        // 關閉任務
        RealmManager.commitTransaction();

        return result;
    }
}
