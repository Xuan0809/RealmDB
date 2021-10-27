package com.example.realmdbtest.DBFunction;

import android.util.Log;

import com.example.realmdbtest.CycleDB.DBInterface;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class Query {

    public void TestQuery(){
//        MapInfo info = new MapInfo();
//        info.setVersion("1.0.0");
//        Insert(info);
    }

    // 搜尋資料庫
    public <T extends RealmObject> void SearchData(Class<T> obj , DBInterface Interface,String fieldName,String value) throws RealmException {

        // Search Test 2 加入搜尋條件
        RealmResults<T> MyResult1 = RealmManager.getRealm().where(obj).contains(fieldName,value).findAll();
        // 遍歷所有資料 (每一筆)
        for(T i:MyResult1) {
            // 顯示出每一筆的 Username
            Log.d("TAG","HaveSearch :" + i.toString());
        }
    }

    // 搜尋資料庫,最新的 pk id
    public <T extends RealmObject> int SearchData_ID(Class<T> obj , DBInterface Interface) throws RealmException {

        Number maxid = RealmManager.getRealm().where(obj).max("id");

        // Empty Table
        if (maxid == null){
            return 0;
        }
        else{
            // 取最新的 id
            return Integer.parseInt(maxid.toString()) ;
        }
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
