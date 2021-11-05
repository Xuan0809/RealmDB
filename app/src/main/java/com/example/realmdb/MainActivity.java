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
import com.example.realmdb.DB.Table.RidingMode;
import com.example.realmdb.DB.Table.RidingModeTime;
import com.example.realmdb.DB.Table.TripDetail;
import com.example.realmdb.DB.Table.TripHistory;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.realm.RealmList;
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

        // 當前時間
        Date date = new Date();

        TripDetail info = new TripDetail();

        for(int i = 0 ; i < 5; i++){

            info.setMissionID(i);
            info.setDate(date);
            info.setlongitude(25.0028949f);
            info.setlatitude(121.4847282f);
            info.setSpeed(24.5f);

            // 搜尋最新一筆資料的 id
            int id = query.SearchFirstID(info.getType(), info);
            // 手動增量
            if (id != 0) {
                insert.InsertData(info, id + 1);
            } else {
                insert.InsertData(info, 1);
            }
        }

//        RidingMode info = new RidingMode();

//        (Boost /Trail/ ECO/ OFF)
//        List<String> RidingName = new ArrayList<String>();
//        RidingName.add("Boost");
//        RidingName.add("Trail");
//        RidingName.add("ECO");
//        RidingName.add("OFF");
//
//        for (int i = 0 ; i < 4 ; i++){
//
//            info.setMode(i);
//            info.setName(RidingName.get(i));
//
//            // 搜尋最新一筆資料的 id
//            int id = query.SearchFirstID(info.getType(), info);
//            // 手動增量
//            if (id != 0) {
//                insert.InsertData(info, id + 1);
//            } else {
//                insert.InsertData(info, 1);
//            }
//        }
    }

    // 更新資料，搜尋 FieldName,Value ，更改 FieldName,Value
    public void UpdateData() throws RealmException {
        TripDetail info = new TripDetail();

        String[] fieldName = {"MissionID","Speed"};
        Object[] value = {0,24.5f};
        String[] updatefield = {"longitude","latitude"};
        Object[] updatevalue = {27.0028949f,121.4847282f};

        update.UpdateData(info.getType(), fieldName, value, updatefield, updatevalue);
    }

    // 刪除資料，關鍵字全刪
    public void DelData() throws RealmException {
        TripDetail info = new TripDetail();

        String[] fieldName = {"longitude","latitude"};
        Object[] value = {27.0028949f,121.4847282f};

        delete.DeleteAllData(info.getType(), fieldName, value);
    }

    // 找到最新資料 id
    public void SearchID() throws RealmException {
        TripDetail info = new TripDetail();
        query.SearchFirstID(info.getType(), info);
    }

    // 搜尋資料庫，FieldName & 內容 搜尋
    public void SearchData() throws RealmException {
        TripDetail info = new TripDetail();

        String[] fieldName = {"Speed","MissionID","longitude"};
        Object[] value = {24.5f,0,25.0028949f};

        RealmResults result = query.SearchData(info.getType(), fieldName, value);

        Log.d("TAG", result.toString());
    }
}