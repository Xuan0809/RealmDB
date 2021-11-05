package com.example.realmdb.DB;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmManager {

    private static Realm mRealm = null;

    public static Realm getRealm() { // use on UI thread only!
        return mRealm;
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
    }

    public static void beginTransaction() {
        mRealm.beginTransaction();
    }

    public static void commitTransaction() {
        mRealm.commitTransaction();
    }

    public static void close(){
        mRealm.close();
    }
}
