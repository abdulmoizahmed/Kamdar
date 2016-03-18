package com.example.moizahmed.test1.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.widget.ArrayAdapter;

import com.example.moizahmed.test1.Model.DataBaseStarter;

/**
 * Created by Moiz Ahmed on 3/13/2016.
 */
public class GetAdapters {
    private Context context;
    private int resource;
    private ArrayAdapter<String> adapter;
    private Cursor c;
    private int i;
    private String[] mSpinnerArray;

    public GetAdapters(Context context) {
        this.context = context;
        this.resource = android.R.layout.simple_spinner_item;
    }

    public ArrayAdapter<String> getLandArray(){
        DataBaseStarter db = new DataBaseStarter(context);
        c = db.retrieveLandNumber();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context,resource,mSpinnerArray);
        return adapter;
    }


    public ArrayAdapter<String> getFasalArray(){
        DataBaseStarter db = new DataBaseStarter(context);
        c = db.retrieveFasalName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context,resource,mSpinnerArray);
        return adapter;
    }


    /*
    * Remaining Adapters code
    *
    * */


}
