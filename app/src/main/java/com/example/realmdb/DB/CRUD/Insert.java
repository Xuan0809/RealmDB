package com.example.realmdb.DB.CRUD;

import com.example.realmdb.DB.RealmManager;
import com.example.realmdb.DB.Table.DBInterface;

import io.realm.RealmObject;
import io.realm.exceptions.RealmException;

public class Insert {

    public String InsertData(DBInterface Interface,int pkid) throws RealmException {

        RealmManager.beginTransaction();
        DBInterface dbi = (DBInterface) RealmManager.getRealm().createObject(Interface.getType(), pkid);
        dbi.fromMap(Interface.toMap());
        RealmManager.commitTransaction();

        return "Success";
    }

    public void InsertOrUpdate(RealmObject obj){
        RealmManager.beginTransaction();
        RealmManager.getRealm().copyToRealmOrUpdate(obj);
        RealmManager.commitTransaction();
    }
}
