package com.example.moizahmed.test1.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.example.moizahmed.test1.Model.DataBaseHelper;

/**
 * Created by Moiz Ahmed on 3/13/2016.
 */
public class GetAdapters {
    private Context context;
    private int spinnerResource;
    private int listResource;
    private ArrayAdapter<String> adapter;
    private Cursor c;
    private int i;
    private String[] mSpinnerArray;

    public GetAdapters(Context context) {
        this.context = context;
        this.spinnerResource = android.R.layout.simple_spinner_item;
        this.listResource = android.R.layout.simple_list_item_1;
    }

    public ArrayAdapter<String> getLandArray(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveLandNumber();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, spinnerResource,mSpinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    public ArrayAdapter<String> getKhadID(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveFertilizerID();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, spinnerResource,mSpinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }

    public ArrayAdapter<String> getKhadCompany(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveFertilizerCompany();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, spinnerResource,mSpinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }



    public ArrayAdapter<String> getFasalArraySpinner(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveFasalName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){
            mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, spinnerResource,mSpinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;
    }


    public ArrayAdapter<String> getMachineNo() {
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveMachineName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){
            mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, spinnerResource,mSpinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        return adapter;


    }


    public ArrayAdapter<String> getFasalArrayList(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveFasalName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){
            mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, listResource,mSpinnerArray);
        return adapter;
    }


    public ArrayAdapter<String> getLandArrayList(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveLandNumber();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, listResource,mSpinnerArray);
        return adapter;
    }


    public ArrayAdapter<String> getFarmerArrayList(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveFarmerName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, listResource,mSpinnerArray);
        return adapter;
    }

    public ArrayAdapter<String> getFarmerArray(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveFarmerName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, spinnerResource,mSpinnerArray);
        return adapter;
    }

    public ArrayAdapter<String> getFertilizerArrayList(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveFertilizerName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, listResource,mSpinnerArray);
        return adapter;
    }


    public ArrayAdapter<String> getSurveyArrayList(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveSurvyeName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, listResource,mSpinnerArray);
        return adapter;
    }

    public ArrayAdapter<String> getSeedArray(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveSeedName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context,spinnerResource,mSpinnerArray);
        return adapter;
    }

    public ArrayAdapter<String> getSeedArrayList(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveSeedName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, listResource,mSpinnerArray);
        return adapter;
    }


    public ArrayAdapter<String> getMachineArrayList(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveMachineName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, listResource,mSpinnerArray);
        return adapter;
    }

    public ArrayAdapter<String> getLoanArrayList(){
        DataBaseHelper db = new DataBaseHelper(context);
        c = db.retrieveLoanFarmerName();i=0;
        this.mSpinnerArray = new String[c.getCount()];
        while(c.moveToNext()){mSpinnerArray[i++] = c.getString(0);}
        c.close();
        adapter = new ArrayAdapter<String>(context, listResource,mSpinnerArray);
        return adapter;
    }



    /*
    * Remaining Adapters code
    *
    * */


}
