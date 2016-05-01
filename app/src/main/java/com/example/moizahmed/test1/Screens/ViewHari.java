package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Fragments.HariViewFragment;
import com.example.moizahmed.test1.Model.ModelFarmer;

/**
 * Created by Moiz Ahmed on 4/30/2016.
 */
public class ViewHari extends Activity {
    Dialog listDialog;
    ListView mListView;
    String  itemValue;
    String CNIC;
    String name;
    String CropName;
    String salary;
    String Address;
    String Phone;
    String Conditions;
    String Contract;
    String Experience;
    String landNumber;
    String date;
    ImageButton edit;
    ImageButton delete;
    HariViewFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hari_malomat);
        initView();

    }

    private void initView() {
        edit = (ImageButton)findViewById(R.id.editBtn);
        delete = (ImageButton)findViewById(R.id.deleteBtn);
        detailsFragment = (HariViewFragment) getFragmentManager().findFragmentById(R.id.FragId);

    }


    public void selectFasal(View view)
    {

        SelectDialog();

        edit.setOnClickListener(new myButtonListener());
        delete.setOnClickListener(new myButtonListener());

    }

    private void SelectDialog() {
        listDialog = new Dialog(this);
        listDialog.setTitle(R.string.dialog_title);
        LayoutInflater li = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = li.inflate(R.layout.fragment_list, null, false);
        listDialog.setCancelable(true);
        listDialog.setContentView(v);

        mListView = (ListView) listDialog.findViewById(R.id.list);
        GetAdapters adapter = new GetAdapters(this);
        mListView.setAdapter(adapter.getFarmerArrayList());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemValue =(String) mListView.getItemAtPosition(position);
                gettingValues();
                Toast.makeText(getApplicationContext(),itemValue,Toast.LENGTH_SHORT).show();
                detailsFragment.settingValues(CNIC,landNumber,CropName,name,salary,Address,Phone,Conditions,Contract,Experience,date);
                edit.setVisibility(View.VISIBLE);
                delete.setVisibility(View.VISIBLE);

                listDialog.dismiss();

            }
        });

        //now that the dialog is set up, it's time to show it
        listDialog.show();
    }

//CNIC TEXT PRIMARY KEY,l
// andNumber TEXT,
// cropName TEXT,
// name VARCHAR ,
// salary VARCHAR,
// address TEXT,
// phone VARCHAR,
// conditions VARCHAR,
// contratcType VARCHAR,        date = cursor.getString(cursor.getColumnIndex("date"));

    // experience VARCHAR,
// date VARCHAR
    private void gettingValues() {
        ModelFarmer modelFarmer = new ModelFarmer();
        Cursor cursor = modelFarmer.getFarmerDetail(getApplicationContext(),itemValue);
        cursor.moveToFirst();
        CNIC = cursor.getString(cursor.getColumnIndex("CNIC"));
        landNumber = cursor.getString(cursor.getColumnIndex("landNumber"));
        CropName = cursor.getString(cursor.getColumnIndex("cropName"));
        name = cursor.getString(cursor.getColumnIndex("name"));
        salary = cursor.getString(cursor.getColumnIndex("salary"));
        Address = cursor.getString(cursor.getColumnIndex("address"));
        Phone = cursor.getString(cursor.getColumnIndex("phone"));
        Conditions = cursor.getString(cursor.getColumnIndex("conditions"));
        Contract = cursor.getString(cursor.getColumnIndex("contratcType"));
        Experience = cursor.getString(cursor.getColumnIndex("experience"));
        date = cursor.getString(cursor.getColumnIndex("date"));

    }


    private class myButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.editBtn:
                    detailsFragment.Editable();
                    break;
                case R.id.deleteBtn:
                    detailsFragment.DeleteEntry();
                    break;
            }
        }
    }

}