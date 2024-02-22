package com.example.e_agricmarketing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Advertisement extends SQLiteOpenHelper {

    private String addDescription;
    private String telephoneNum;
    private String heading;
    private String address;
    private String type;
    private String username;

    public void setAddDescription(String addDescription) {
        this.addDescription = addDescription;
    }

    public void setTelephoneNum(String telephoneNum) {
        this.telephoneNum = telephoneNum;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public Advertisement(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "Agriculture1.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE ADVERTISEMENT(ADDID INTEGER PRIMARY KEY AUTOINCREMENT, USERNAME TEXT, ADDDESCRIPTION TEXT, HEADING TEXT, TELEPHONENUM TEXT, ADDRESS TEXT, TYPE TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ADVERTISEMENT");
        onCreate(db);
    }

    public void addAdvertisement(){
        ContentValues contentValues = new ContentValues();
        contentValues.put("ADDDESCRIPTION", addDescription);
        contentValues.put("HEADING", heading);
        contentValues.put("TELEPHONENUM", telephoneNum);
        contentValues.put("ADDRESS", address);
        contentValues.put("USERNAME", username);
        contentValues.put("TYPE", type);
        this.getWritableDatabase().insertOrThrow("ADVERTISEMENT","",contentValues);
    }

    Cursor getAllAdvertisement(){
        String query = "SELECT * FROM ADVERTISEMENT";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;

    }
    Cursor getMyAdvertisements(String username){
        String query = "SELECT * FROM ADVERTISEMENT WHERE USERNAME = '" + username + "'";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

}
