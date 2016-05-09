package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Fragments.MachineViewFragment;
import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelMachine;
import com.example.moizahmed.test1.R;
import com.getbase.floatingactionbutton.FloatingActionButton;

import javax.crypto.Mac;

/**
 * Created by Moiz Ahmed on 4/30/2016.
 */
public class ViewMachine extends Activity {
    Dialog listDialog;
    ListView mListView;
    String  itemValue;
    String name;
    String company;
    String ID;
    String quantity;
    String expense;
    String date;

    FloatingActionButton edit;
    FloatingActionButton delete;
    MachineViewFragment detailsFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_machine_malomat);

        initView();
        //  setLabels();


    }



    private void initView() {

        edit = (FloatingActionButton) findViewById(R.id.editBtn);
        delete = (FloatingActionButton) findViewById(R.id.deleteBtn);
        detailsFragment = (MachineViewFragment) getFragmentManager().findFragmentById(R.id.FragId);

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
        mListView.setAdapter(adapter.getMachineArrayList());

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemValue = (String) mListView.getItemAtPosition(position);
                gettingValues();
                detailsFragment.settingValues(ID,name,company,quantity,expense,date);
                edit.setVisibility(View.VISIBLE);
                delete.setVisibility(View.VISIBLE);
                listDialog.dismiss();
            }
        });

        //now that the dialog is set up, it's time to show it
        listDialog.show();
    }

    //modelNumber TEXT PRIMARY KEY,
    // name VARCHAR,
    // companyName VARCHAR,
    // ownershipStatus VARCHAR,
    // Expense VARCHAR,
    // date VARCHAR

    private void gettingValues() {
        ModelMachine modelMachine = new ModelMachine();
        Cursor cursor = modelMachine.getMachineDetail(getApplicationContext(),itemValue);
        cursor.moveToFirst();
        ID = cursor.getString(cursor.getColumnIndex("modelNumber"));
        name = cursor.getString(cursor.getColumnIndex("name"));
        company = cursor.getString(cursor.getColumnIndex("companyName"));
        quantity = cursor.getString(cursor.getColumnIndex("ownershipStatus"));
        expense = cursor.getString(cursor.getColumnIndex("Expense"));
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
