package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by umair on 5/8/2016.
 */
public class ModelSurveyReport {
    String name;
    String CNIC;
    String landNumber;
    String amount;
    String Date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCNIC() {
        return name;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getLandNumber() {
        return landNumber;
    }

    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Cursor getLandNumb(Context context){

        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveLandNumber();
        return c;
    }


    public Cursor getSurveyReport(Context context,String landNumber)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveSurveyReport(landNumber);
        return c;
    }


}
