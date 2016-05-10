package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by umair on 5/8/2016.
 */
public class ModelAnnualFaslReport {

    public Cursor getCropName(Context context){

        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveFasalName();
        return c;
    }
    public Cursor getFaslAnnualReportMachine(Context context,String land,String date1)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveAnnualMachine(land, date1);
        return c;
    }
}
