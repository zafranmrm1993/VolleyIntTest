package com.example.user.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 9/17/2018.
 */

public class DbOperation extends SQLiteOpenHelper{


    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME= "simdetails";
    private static String DATABASE_TABLE_SIM= "sim";

    private static String DATABASE_KEY_ID= "id";
    private static String DATABASE_KEY_ICCID= "iccid";
    private static String DATABASE_KEY_SP= "sp";
    private static String DATABASE_KEY_EXPIREDATE= "expire_date";

    public DbOperation(Context context) {

        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String create ="CREATE table "+DATABASE_TABLE_SIM+" ("+DATABASE_KEY_ID+" INTEGER PRIMARY KEY,"
                +DATABASE_KEY_ICCID+" TEXT,"
                +DATABASE_KEY_SP+" TEXT"
                +DATABASE_KEY_EXPIREDATE+" TEXT"
                +")";
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE_SIM);
        onCreate(db);
    }

// for speed up transection ...
public void addSimlist(List<sim> list) {
    SQLiteDatabase db = this.getWritableDatabase();
    db.beginTransaction();
    try {
        ContentValues values = new ContentValues();
        for (sim s : list) {
            values.put(DATABASE_KEY_ICCID, s.getIccid());
            values.put(DATABASE_KEY_SP, s.getSp());
            values.put(DATABASE_KEY_EXPIREDATE, s.getExpire_date());
            db.insert(DATABASE_TABLE_SIM, null, values);
        }
        db.setTransactionSuccessful();
    } finally {
        db.endTransaction();
    }
}
//=================================
    public List<sim>getAllSim(){
        List<sim> getallcontact = new ArrayList<>();
        String qry = "SELECT * FROM "+DATABASE_TABLE_SIM;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(qry,null);
        if( cursor.moveToFirst()){
            do{
                sim s = new sim();
                s.setId(Integer.parseInt(cursor.getString(0)));
                s.setIccid(cursor.getString(1));
                s.setSp(cursor.getString(2));
                s.setExpire_date(cursor.getString(3));
                getallcontact.add(s);

            }while (cursor.moveToFirst());

        }
        return getallcontact;
    }


}
