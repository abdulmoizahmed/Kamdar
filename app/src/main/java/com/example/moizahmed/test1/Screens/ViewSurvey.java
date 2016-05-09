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
import com.example.moizahmed.test1.R;
import com.example.moizahmed.test1.Adapters.GetAdapters;
import com.example.moizahmed.test1.Fragments.SurveyViewFragment;
import com.example.moizahmed.test1.Model.ModelLand;
import com.example.moizahmed.test1.Model.ModelSurvey;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by Moiz Ahmed on 4/30/2016.
 */
public class ViewSurvey  extends Activity {
    Dialog listDialog;
    ListView mListView;
    String  itemValue;
    String number,owner,dimension,location,ph,date;
    FloatingActionButton edit;
    FloatingActionButton delete;
    SurveyViewFragment detailsFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_malomat);

        initView();
        //  setLabels();


    }



    private void initView() {

        edit = (FloatingActionButton) findViewById(R.id.editBtn);
        delete = (FloatingActionButton) findViewById(R.id.deleteBtn);
        detailsFragment = (SurveyViewFragment) getFragmentManager().findFragmentById(R.id.FragId);

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
        mListView.setAdapter(adapter.getSurveyArrayList());

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemValue = (String) mListView.getItemAtPosition(position);
                gettingValues();
                detailsFragment.settingValues(number,owner,dimension,location,ph,date);
                FloatingActionsMenu menu = (FloatingActionsMenu)findViewById(R.id.menu);
                menu.setVisibility(View.VISIBLE);

                listDialog.dismiss();
            }
        });

        //now that the dialog is set up, it's time to show it
        listDialog.show();
    }

    //surveyCode TEXT PRIMARY KEY NOT NULL,
    // landNumber VARCHAR ,
    // company VARCHAR,
    // expense VARCHAR,
    // pH VARCHAR,
    // date VARCHAR,

    private void gettingValues() {
        ModelSurvey modelSurvey = new ModelSurvey();
        Cursor cursor = modelSurvey.getSurveyDetail(getApplicationContext(),itemValue);
        cursor.moveToFirst();
        number = cursor.getString(cursor.getColumnIndex("surveyCode"));
        owner = cursor.getString(cursor.getColumnIndex("company"));
        dimension = cursor.getString(cursor.getColumnIndex("landNumber"));
        location = cursor.getString(cursor.getColumnIndex("expense"));
        ph = cursor.getString(cursor.getColumnIndex("pH"));
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
