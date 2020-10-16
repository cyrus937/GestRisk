package com.example.gestrisk.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class UserDAO extends DAO {
    public static final String TABLE_NAME = "User";
    public static final String KEY = "idUser";
    public static final String NAME = "nom";
    public static final String PRENOM = "prenom";
    public static final String POSTE = "poste";
    public static final String ZONE = "zone";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    public static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("+KEY+" INTEGER PRIMARY KEY AUTOINCREMENT" +
            ", "+NAME+" TEXT NOT NULL, "+PRENOM+" TEXT, "+POSTE+" TEXT, "+ZONE+" TEXT, "+EMAIL+" TEXT NOT NULL, "+PASSWORD+" TEXT NOT NULL);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS "+TABLE_NAME+";";

    public UserDAO(Context pContext) {
        super(pContext);
    }

    public void ajouter (User user)
    {
        mDb = this.open();
        ContentValues value = new ContentValues();
        value.put(UserDAO.NAME, user.getNom());
        value.put(UserDAO.PRENOM, user.getPrenom());
        value.put(UserDAO.POSTE, user.getPoste());
        value.put(UserDAO.ZONE, user.getZone());
        value.put(UserDAO.EMAIL, user.getEmail());
        value.put(UserDAO.PASSWORD, user.getPassword());

        mDb.insert(UserDAO.TABLE_NAME, null, value);
    }

    public int findIdUser(String name, String pawd)
    {
        int id = -1;
        mDb = this.getDb();
        String req = "select idUser from User where NOM = \""+name+"\" AND PASSWORD = \""+pawd+"\"";
        Cursor curseur = mDb.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast())
        {
            id = curseur.getInt(0);
        }
        curseur.close();
        return id;
    }

    public User findUser(String name, String pawd)
    {
        User user = null;
        mDb = this.getDb();
        String req = "select * from User where NOM = \""+name+"\" AND PASSWORD = \""+pawd+"\"";
        Cursor curseur = mDb.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast())
        {
            int idUser = curseur.getInt(0);
            String nom = curseur.getString(1);
            String prenom = curseur.getString(2);
            String poste = curseur.getString(3);
            String zone = curseur.getString(4);
            String email = curseur.getString(5);
            String pwd = curseur.getString(6);
            user = new User(idUser,nom,prenom,poste,zone,email,pwd);
        }
        curseur.close();
        return user;
    }
}
