package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Moiz Ahmed on 3/13/2016.
 */
public class ModelLand {
    String landNumber;
    String landOwner;
    String dimensions;
    String landLoc;


    public String getLandNumber() {
        return landNumber;
    }

    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    public String getLandOwner() {
        return landOwner;
    }

    public void setLandOwner(String landOwner) {
        this.landOwner = landOwner;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getLandLoc() {
        return landLoc;
    }

    public void setLandLoc(String landLoc) {
        this.landLoc = landLoc;
    }

    public Cursor getLandDetail(Context context, String name)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveLandDetails(name);;
        return c;
    }
}
