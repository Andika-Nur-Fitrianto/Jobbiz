package com.example.jobizz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Db_sqlite extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "jobizz.db";
    private static final int DATABASE_VERSION = 1;

    public Db_sqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table notes (judul text primary key, isi text)";
        Log.d("Data", "onCreate : " + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db0, int db1, int db2) {
        db0.execSQL("drop table if exists notes");
        onCreate(db0);
    }

    void addNote(String judul, String isi) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("judul", judul);
        cv.put("isi", isi);
        long result = db.insert("notes", null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to retrieve all saved messages from the database
    Cursor getSavedMessages() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("SELECT * FROM notes", null);
    }
}
