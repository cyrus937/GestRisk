package com.example.gestrisk.model;

import android.content.Context;

public class UserRisqueDAO extends DAO{

    public static final String TABLE_NAME = "UserRisque";
    public static final String KEY1 = "idUser";
    public static final String KEY2 = "idRisque";

    private String creation2 = "CREATE TABLE "+TABLE_NAME+" (" +
            ""+KEY1+" INTEGER NOT NULL," +
            ""+KEY2+" INTEGER NOT NULL," +
            "FOREIGN KEY(idUser) REFERENCES User(idUser)," +
            "FOREIGN KEY(idRisque) REFERENCES Risque(idRisque));";

    public UserRisqueDAO(Context pContext) {
        super(pContext);
    }

    public void ajouterUserRisque (int idUser, int idRisque)
    {
        mDb = this.open();

        String req = "insert into UserRisque values ("+idUser+","+idRisque+")";

        this.mDb.execSQL(req);

        System.out.println("Le Lien a été créé avec succès !!!!!!");
    }
}
