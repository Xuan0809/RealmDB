package com.example.realmdb.DB;

import android.content.Context;

import com.example.realmdb.DB.CRUD.Delete;
import com.example.realmdb.DB.CRUD.Insert;
import com.example.realmdb.DB.CRUD.Query;
import com.example.realmdb.DB.CRUD.Update;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmManager {

    private static Realm mRealm = null;

    private static Boolean mInitFlag = false;

    public static Realm getRealm() { // use on UI thread only!
        return mRealm;
    }

    // 創建 CRUD Class
    private static Insert mInsert = null;

    public static Insert getInsert() {
        return mInsert;
    }

    private static Update mUpdate = null;

    public static Update getUpdate() {
        return mUpdate;
    }

    private static Delete mDelete = null;

    public static Delete getDelete() {
        return mDelete;
    }

    private static Query mQuery = null;

    public static Query getQuery() {
        return mQuery;
    }

    // 初始化
    public static void init(Context context) {
        if(mRealm == null){
            Realm.init(context);

            // MyDB
            String realmName = "db1.realm";
            RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).build();

            mRealm = Realm.getInstance(config);
        }

        mInsert = new Insert();
        mQuery = new Query();
        mUpdate = new Update();
        mDelete = new Delete();

        mInitFlag = true;
    }

    public static void beginTransaction() {
        mRealm.beginTransaction();
    }

    public static void commitTransaction() {
        mRealm.commitTransaction();
    }

    public static boolean IsInit() { return mInitFlag; }

    public static void close(){
        mRealm.close();
    }
}
