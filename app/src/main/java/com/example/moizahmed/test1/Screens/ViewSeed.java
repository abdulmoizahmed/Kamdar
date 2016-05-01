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

import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Fragments.SeedViewFragment;
import com.example.moizahmed.test1.Model.ModelKhad;
import com.example.moizahmed.test1.Model.ModelSeed;

/**
 * Created by Moiz Ahmed on 4/30/2016.
 */
public class ViewSeed  extends Activity {
    Dialog listDialog;
    ListView mListView;
    String  itemValue;
    String name;
    String company;
    String ID;
    String quantity;
    String expense;
    String date;

    ImageButton edit;
    ImageButton delete;
    SeedViewFragment detailsFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seed_malomat);

        initView();
        //  setLabels();


    }



    private void initView() {

        edit = (ImageButton)findViewById(R.id.editBtn);
        delete = (ImageButton)findViewById(R.id.deleteBtn);
        detailsFragment = (SeedViewFragment) getFragmentManager().findFragmentById(R.id.FragId);

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
        mListView.setAdapter(adapter.getSeedArrayList());

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
//ID VARCHAR PRIMARY KEY,
// name VARCHAR,
// company VARCHAR,
// quantity VARCHAR,
// expense VARCHAR,
// date VARCHAR)


    private void gettingValues() {
        ModelSeed modelSeed = new ModelSeed();
        Cursor cursor = modelSeed.getSeedDetail(getApplicationContext(),itemValue);
        cursor.moveToFirst();
        ID = cursor.getString(cursor.getColumnIndex("ID"));
        name = cursor.getString(cursor.getColumnIndex("name"));
        company = cursor.getString(cursor.getColumnIndex("company"));
        quantity = cursor.getString(cursor.getColumnIndex("quantity"));
        expense = cursor.getString(cursor.getColumnIndex("expense"));
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

