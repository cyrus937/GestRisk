package com.example.gestrisk.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Timestamp;
import java.util.ArrayList;

public abstract class DAO {

    protected final static int VERSION = 1;

    protected final static String NOM = "GestionRisqueDB.db";

    protected SQLiteDatabase mDb ;

    protected MySQLiteOpenHelper mHandler;

    public DAO (Context pContext){
        this.mHandler = new MySQLiteOpenHelper(pContext, NOM, null, VERSION);
    }

    public SQLiteDatabase open() throws SQLException {
        this.mDb = this.mHandler.getWritableDatabase();
        return this.mDb;
    }

    public void close(){
        this.mDb.close();
    }

    public SQLiteDatabase getDb() {
        this.mDb = mHandler.getReadableDatabase();
        return this.mDb;
    }
}
