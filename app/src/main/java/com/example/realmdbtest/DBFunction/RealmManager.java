package com.example.realmdbtest.DBFunction;

import android.content.Context;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmManager {

    private static Realm realm = null;

    public static Realm getRealm() { // use on UI thread only!
        return realm;
    }

    // 初始化
    public static void init(Context context) {
        if(realm == null){
            Realm.init(context);

            // MyDB
            String realmName = "db.realm";
            RealmConfiguration config = new RealmConfiguration.Builder().name(realmName).build();

            realm = Realm.getInstance(config);
        }
    }

    public static void beginTransaction() {
        realm.beginTransaction();
    }

    public static void commitTransaction() {
        realm.commitTransaction();
    }

    public static void close(){
        realm.close();
    }
}
