package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by umair on 5/8/2016.
 */
public class ModelExpenseReport {

    public Cursor getLandNumb(Context context){

        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveLandNumber();
        return c;
    }

    public Cursor getTaxTotal(Context context,String land){

        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrievetaxTotal(land);
        return c;
    }
    public Cursor getSurveyTotal(Context context,String land){

        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveSurveyTotal(land);
        return c;
    }
    public Cursor getSeedTotal(Context context,String land){

        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveSeedTotal(land);
        return c;
    }
    public Cursor getLoanTotal(Context context,String land){

        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveLoanTotal(land);
        return c;
    }

    public Cursor getLandReportTax(Context context,String landNumber,String date1)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveExpenseReportTax(landNumber, date1);
        return c;
    }
    public Cursor getLandReportSurvey(Context context,String landNumber,String date1)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveExpenseReportSurvey(landNumber, date1);
        return c;
    }
    public Cursor getLandReportSeed(Context context,String landNumber,String date1)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveExpenseReportSeed(landNumber, date1);
        return c;
    }
    public Cursor getLandReportLoan(Context context,String landNumber,String date1)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveExpenseReportLoan(landNumber, date1);
        return c;
    }

}
