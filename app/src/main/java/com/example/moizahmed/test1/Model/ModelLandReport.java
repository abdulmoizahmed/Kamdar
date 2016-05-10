package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by umair on 5/8/2016.
 */
public class ModelLandReport {



    public Cursor getLandNumb(Context context){

        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveLandNumber();
        return c;
    }


    public Cursor getLandReport(Context context,String landNumber)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveLandReport(landNumber);
        return c;
    }

}
