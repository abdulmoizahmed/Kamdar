package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Moiz Ahmed on 3/12/2016.
 */
public class ModelFasl {
    DataBaseHelper dataBaseHelper;

    String cropName;
    String season;
    String year;

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Cursor getFasalDetail(Context context,String name)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveFasalDetails(name);;
        return c;
    }




}

