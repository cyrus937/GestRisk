package com.example.gestrisk.model;

import android.content.Context;
import android.database.Cursor;

import java.sql.Timestamp;
import java.util.ArrayList;

public class RisqueDAO extends DAO {

    public static final String TABLE_NAME = "Risque";
    public static final String KEY = "idRisque";
    public static final String PHOTO = "photo";
    public static final String LOCALISATION = "localisation";
    public static final String DESCRIPTION = "description";
    public static final String CARACTERISATION = "caracterisation";
    public static final String EVALUATION = "evaluation";
    public static final String MESURECOMP = "mesureComp";
    public static final String MESUREPRE = "mesurePre";
    public static final String DATE = "date";
    public static final String EMAILRESPON = "emailRespon";

    public static final String CREATE_TABLE = "create table "+TABLE_NAME+" ("+KEY+" INTEGER PRIMARY KEY AUTOINCREMENT" +
            ", "+PHOTO+" TEXT , "+LOCALISATION+" TEXT, "+DESCRIPTION+" TEXT, "+CARACTERISATION+" TEXT, "+EVALUATION+" TEXT ," +
            " "+MESURECOMP+" TEXT ,"+MESUREPRE+" TEXT, "+DATE+" TEXT ,"+EMAILRESPON+" TEXT NOT NULL);";

    public static final String TABLE_DROP = "DROP TABLE IF EXISTS "+TABLE_NAME+";";

    public RisqueDAO(Context pContext) {
        super(pContext);
    }

    public ArrayList findRisque(int idUser)
    {
        ArrayList<Risque> listRisque = new ArrayList<Risque>();
        mDb = this.getDb();
        String req ="select * from Risque inner join UserRisque on Risque.idRisque = UserRisque.idRisque" +
                " where idUser = "+idUser;
        Cursor curseur = mDb.rawQuery(req,null);
        int i = 0;
        while (curseur.moveToNext())
        {

            Timestamp date;
            Risque r = new Risque(curseur.getInt(0),
                    curseur.getString(1),
                    curseur.getString(2),
                    curseur.getString(3),
                    curseur.getString(4),
                    curseur.getString(5),
                    curseur.getString(6),
                    curseur.getString(7),
                    date = new Timestamp(System.currentTimeMillis()),
                    curseur.getString(9));
            System.out.println(r);
            listRisque.add(r);

            System.out.println(listRisque.get(i)+"\n la position est = "+i);
            i++;
        }
        curseur.close();
        System.out.println("J'AI FINI DE CHERCHER TOUS LES RISQUES !!!!!!");
        return listRisque;
    }

    public void ajouterRisque (Risque risque)
    {
        this.mDb = this.open();
        String req = "insert into Risque (photo,localisation,description,caracterisation,evaluation,mesureComp,mesurePre,date,emailRespon) values(\""+risque.getPhoto()+"\"" +
                ",\""+risque.getLocalisation()+"\",\""+risque.getDescription()+"\"" +
                ",\""+risque.getCaracterisation()+"\",\""+risque.getEvaluation()+"\"" +
                ",\""+risque.getMesureComp()+"\",\""+risque.getMesurePre()+"\"" +
                ",\""+risque.getDate()+"\",\""+risque.getEmailRespon()+"\")";

        this.mDb.execSQL(req);
        System.out.println("Le risque a été créé avec succès !!!!!!");
    }

    public int findLastInsertRisque ()
    {
        int id = -1;
        String req = "select last_insert_rowid()";
        mDb = this.getDb();
        Cursor curseur = mDb.rawQuery(req, null);
        curseur.moveToLast();
        if(!curseur.isAfterLast())
        {
            id = curseur.getInt(0);
        }
        return  id;
    }
}
