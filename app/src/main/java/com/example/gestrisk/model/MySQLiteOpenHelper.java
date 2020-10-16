package com.example.gestrisk.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {


    private String creation = "CREATE TABLE User(" +
            "idUser INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "NOM TEXT NOT NULL UNIQUE," +
            "PRENOM TEXT NOT NULL," +
            "POSTE TEXT," +
            "ZONE TEXT," +
            "EMAIL TEXT NOT NULL UNIQUE," +
            "PASSWORD TEXT NOT NULL UNIQUE);";

    private String creation1 = "CREATE TABLE Risque (" +
            "idRisque INTEGER PRIMARY KEY  AUTOINCREMENT," +
            "photo TEXT," +
            "localisation TEXT," +
            "description TEXT," +
            "caracterisation TEXT," +
            "evaluation TEXT," +
            "mesureComp TEXT," +
            "mesurePre TEXT," +
            "date TEXT," +
            "emailRespon TEXT NOT NULL);";


    private String creation2 = "CREATE TABLE UserRisque(" +
            "idUser INTEGER NOT NULL," +
            "idRisque INTEGER NOT NULL," +
            "FOREIGN KEY(idUser) REFERENCES User(idUser)," +
            "FOREIGN KEY(idRisque) REFERENCES Risque(idRisque));";
    /**
     * constructeur
     * @param context
     * @param name
     * @param factory
     * @param version
     */
    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("JE CREE LES TABLES DE MA BASE DE DONNEES");
        db.execSQL(creation);
        db.execSQL(creation1);
        db.execSQL(creation2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
