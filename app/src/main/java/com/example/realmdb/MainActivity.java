package com.example.realmdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.realmdb.DB.Table.MapInfo;
import com.example.realmdb.DB.CRUD.Delete;
import com.example.realmdb.DB.CRUD.Insert;
import com.example.realmdb.DB.CRUD.Query;
import com.example.realmdb.DB.RealmManager;
import com.example.realmdb.DB.CRUD.Update;

import java.text.ParseException;
import java.util.Date;

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

        // Update
        UpdateData();

        // Delete
        DelData();

        // 搜尋最新 id
        SearchID();

        // Query
        SearchData();

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
        int id = query.SearchFirstID(info.getType(), info);
        // 手動增量
        if (id != 0) {
            insert.InsertData(info, id + 1);
        } else {
            insert.InsertData(info, 1);
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

    // 更新資料，搜尋 FieldName,Value ，更改 FieldName,Value
    public void UpdateData() throws RealmException {
        MapInfo info = new MapInfo();
        update.UpdateData(info.getType(), "Version", "1", "Version", "2.0.0");
    }

    // 刪除資料，關鍵字全刪
    public void DelData() throws RealmException {
        MapInfo info = new MapInfo();
        delete.DeleteAllData(info.getType(), info, "Version", "1.0.0");
    }

    // 找到最新資料 id
    public void SearchID() throws RealmException {
        MapInfo info = new MapInfo();
        query.SearchFirstID(info.getType(), info);
    }

    // 搜尋資料庫，FieldName & 內容 搜尋
    public void SearchData() throws RealmException {
        MapInfo info = new MapInfo();
        RealmResults result =query.SearchData(info.getType(), "Version", "2.0.0");

        Log.d("TAG",result.toString());
    }
}