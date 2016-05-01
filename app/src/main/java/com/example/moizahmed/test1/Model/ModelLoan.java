package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by umair on 3/13/2016.
 */
public class ModelLoan {
    String name;
    String landNumber;
    String amount;
    String Date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public Cursor getLoanDetail(Context context, String name)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveLoanDetails(name);;
        return c;
    }

}
