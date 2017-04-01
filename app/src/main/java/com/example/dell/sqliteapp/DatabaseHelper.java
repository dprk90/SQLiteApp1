package com.example.dell.sqliteapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "freshleafy.db";
    public static final String TABLE_NAME = "items_sold";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "ITEM_NAME";
    public static final String COL_3 = "PRICE";
    public static final String COL_4 = "QUANTITY";
    public static final String COL_5 = "CATEGORY";
    public static final String COL_6 = "SUB_CATEGORY";



    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,ITEM_NAME TEXT,PRICE INTEGER,QUANTITY INTEGER,CATEGORY INTEGER,SUB_CATEGORY INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void insertData(String name,int price,int quantity,int category,int sub_category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,price);
        contentValues.put(COL_4,quantity);
        contentValues.put(COL_5,category);
        contentValues.put(COL_6,sub_category);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        Log.e("insert",""+name);

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }





    public long QueryNumEntries()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        return DatabaseUtils.queryNumEntries(db, TABLE_NAME);
    }

    public boolean updateData(String id,String name,int price,int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,price);
        contentValues.put(COL_4,quantity);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }


}