package com.example.gestrisk.model;

import java.sql.Timestamp;
import java.sql.Date;

public class Risque {

    private Integer idRisque = null;
    private String photo;
    private String localisation;
    private String description;
    private String caracterisation;
    private String evaluation;
    private String mesureComp;
    private String mesurePre;
    //private Date date1 = new Date(System.currentTimeMillis());
    private Timestamp date = new Timestamp(System.currentTimeMillis());
    private String emailRespon;

    public Risque(int idRisque, String photo, String localisation, String description, String caracterisation,
                  String evaluation, String mesureComp, String mesurePre, Timestamp date, String emailRespon) {
        this(photo, localisation, description, caracterisation, evaluation, mesureComp, mesurePre, date, emailRespon);
        this.idRisque = idRisque;
    }

    public Risque(String photo, String localisation, String description, String caracterisation,
                  String evaluation, String mesureComp, String mesurePre, Timestamp date, String emailRespon) {
        super();
        this.photo = photo;
        this.localisation = localisation;
        this.description = description;
        this.caracterisation = caracterisation;
        this.evaluation = evaluation;
        this.mesureComp = mesureComp;
        this.mesurePre = mesurePre;
        //this.date = date;
        this.emailRespon = emailRespon;
    }

    public int getIdRisque() {
        return idRisque;
    }

    public void setIdRisque(int idRisque) {
        this.idRisque = idRisque;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaracterisation() {
        return caracterisation;
    }

    public void setCaracterisation(String caracterisation) {
        this.caracterisation = caracterisation;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getMesureComp() {
        return mesureComp;
    }

    public void setMesureComp(String mesureComp) {
        this.mesureComp = mesureComp;
    }

    public String getMesurePre() {
        return mesurePre;
    }

    public void setMesurePre(String mesurePre) {
        this.mesurePre = mesurePre;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getEmailRespon() {
        return emailRespon;
    }

    public void setEmailRespon(String emailRespon) {
        this.emailRespon = emailRespon;
    }

    @Override
    public String toString() {
        return "Risque{" +
                "idRisque=" + idRisque +
                ", photo='" + photo + '\'' +
                ", localisation='" + localisation + '\'' +
                ", description='" + description + '\'' +
                ", caracterisation='" + caracterisation + '\'' +
                ", evaluation='" + evaluation + '\'' +
                ", mesureComp='" + mesureComp + '\'' +
                ", mesurePre='" + mesurePre + '\'' +
                ", date=" + date +
                ", emailRespon='" + emailRespon + '\'' +
                '}';
    }
}
