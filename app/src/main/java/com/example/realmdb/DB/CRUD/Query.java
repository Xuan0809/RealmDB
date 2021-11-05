package com.example.realmdb.DB.CRUD;

import android.util.Log;
import android.widget.Switch;

import com.example.realmdb.DB.RealmManager;
import com.example.realmdb.DB.Table.DBInterface;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Query {

    // 搜尋資料庫,最新的 pk id
    public <T extends RealmObject> int SearchFirstID(Class<T> obj, DBInterface Interface) throws RealmException {

        Number maxid = RealmManager.getRealm().where(obj).max("id");

        // Empty Table
        if (maxid == null) {
            return 0;
        } else {
            // 取最新的 id
            return Integer.parseInt(maxid.toString());
        }
    }

    // 搜尋單一條件下
    public RealmResults SearchData(Class obj, String fieldName, Object value) throws RealmException {

        String[] fieldNameAdapter = {fieldName};
        Object[] valueAdapter = {value};

        return SearchData(obj, fieldNameAdapter, valueAdapter);
    }

    // 搜尋複數條件下
    public RealmResults SearchData(Class obj, String fieldName[], Object[] value) throws RealmException {

        RealmQuery Query = RealmManager.getRealm().where(obj);

        for (int i = 0; i < value.length; i++) {
            if (value[i] instanceof String) {
                Query = Query.containsValue(fieldName[i], value[i].toString());
            } else if (value[i] instanceof Integer) {
                Query = Query.containsValue(fieldName[i], (int) value[i]);
            } else if (value[i] instanceof Float) {
                Query = Query.containsValue(fieldName[i], (float) value[i]);
            } else if (value[i] instanceof Date) {
                Query = Query.containsValue(fieldName[i], (Date) value[i]);
            }
        }

        RealmResults MyResult = Query.findAll();

        return MyResult;
    }


}

//class OLDQuery{
//
//     // 搜尋資料庫 For User
//     public void SearchData() throws RealmException {

// Search Test 1 搜尋全部
       /* RealmResults<User> MyResult =
                realm.where(User.class).findAll();
        // 遍歷所有資料 (每一筆)
        for(User i:MyResult) {
            // 顯示出每一筆的 Username
            Log.d("results", i.getUsername());
*//*            Log.d("results", i.getEmail());
            Log.d("results", i.getId());*//*
        }*/

// Search Test 2 加入搜尋條件
        /*RealmResults<User> MyResult1 = realm.where(User.class).contains("username","S" ).findAll();
        // 遍歷所有資料 (每一筆)
        for(User i:MyResult1) {
            // 顯示出每一筆的 Username
            Log.d("results1", i.getUsername());
*//*            Log.d("results", i.getEmail());
            Log.d("results", i.getId());*//*
        }*/

// Search Test 2 也能這樣打
// 創建搜尋庫
//         RealmQuery<User> MyQueue = RealmManager.getRealm().where(User.class);
//         // 委派命令句
//         RealmResults<User> MyResult1 = MyQueue.contains("username", "X").findAll();
//         // 遍歷所有資料 (每一筆)
//         for (User i : MyResult1) {
//             // 顯示出每一筆的 Username
//             Log.d("results1", i.getUsername());
//             Log.d("results", i.getEmail());
//             Log.d("results", i.getId());
//         }
//
//         // 顯示本次搜尋出來的資料有幾筆
//         Log.d("Tag", String.valueOf(MyResult1.size()));
//     }
//}
