package com.example.realmdbtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.realmdbtest.CycleDB.MapInfo;
import com.example.realmdbtest.CycleDB.RidingMode;
import com.example.realmdbtest.CycleDB.TripHistory;
import com.example.realmdbtest.DBFunction.Delete;
import com.example.realmdbtest.DBFunction.Insert;
import com.example.realmdbtest.DBFunction.Query;
import com.example.realmdbtest.DBFunction.RealmManager;
import com.example.realmdbtest.DBFunction.Update;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.exceptions.RealmException;

public class MainActivity extends AppCompatActivity {

    // 創建 CRUD Class
    private Insert insert = new Insert();
    private Update update = new Update();
    private Delete delete = new Delete();
    private Query query = new Query();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Tag", "start initDB");
        // init DB
        RealmManager.init(this);

        // get DB URL for Realm Browser
        // Log.d("URL","path :" + RealmManager.getRealm().getPath());

        // Insert
        try {
            InsertData();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Delete
        DelData();

        // Update
        UpdateData();

        // Query
        SearchData();

        // 搜尋最新 id
        SearchID();

        // Close RealmDB
        RealmManager.close();
    }

    // 寫入資料，帶 pk id
    public void InsertData() throws RealmException, ParseException {

        // 當前時間‘
        Date date = new Date();

        MapInfo info = new MapInfo();
        info.setVersion("1.0.0");
        info.setUpdateDate(date);

        // 搜尋最新一筆資料的 id
        int id = query.SearchData_ID(info.getType(), info);
        // 手動增量
        if (id != 0) {
            insert.Insert(info, id + 1);
        } else {
            insert.Insert(info, 1);
        }

//        RidingMode info = new RidingMode();

        // (Boost /Trail/ ECO/ OFF)
//        List<String> RidingName = new ArrayList<String>();
//        RidingName.add("Boost");
//        RidingName.add("Trail");
//        RidingName.add("ECO");
//        RidingName.add("OFF");
//
//        for (int i = 0 ; i < 4 ; i++){
//
//            info.setRidingMode(i);
//            info.setName(RidingName.get(i));
//
//            // 搜尋最新一筆資料的 id
//            int id = query.SearchData_ID(info.getType(), info);
//            // 手動增量
//            if (id != 0) {
//                insert.Insert(info, id + 1);
//            } else {
//                insert.Insert(info, 1);
//            }
//        }
    }

    // 搜尋資料庫，FieldName & 內容 搜尋
    public void SearchData() throws RealmException {
        MapInfo info = new MapInfo();
        query.SearchData(info.getType(), info, "Version", "0.0");
    }

    // 找到最新資料 id
    public void SearchID() throws RealmException {
        MapInfo info = new MapInfo();
        query.SearchData_ID(info.getType(), info);
    }

    // 刪除資料，關鍵字全刪
    public void DelData() throws RealmException {
        MapInfo info = new MapInfo();
        delete.DelData(info.getType(), info, "Version", "2.0.0");
    }

    // 更新資料，搜尋 FieldName,Value ，更改 FieldName,Value
    public void UpdateData() throws RealmException {
        MapInfo info = new MapInfo();
        update.UpdateData(info.getType(), info, "Version", "1", "Version", "2.0.0");
    }
}