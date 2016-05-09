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
import com.example.moizahmed.test1.Fragments.FasalViewFragment;
import com.example.moizahmed.test1.Model.ModelFasl;
import com.example.moizahmed.test1.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by Moiz Ahmed on 4/26/2016.
 */
public class ViewFasal extends Activity {
    Dialog listDialog;
    ListView fasalListView;
    String  itemValue;
    String name,season,year;
    FloatingActionButton edit;
    FloatingActionButton delete;
    FasalViewFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasl_malomat);
        initView();

    }

    private void initView() {
        edit = (FloatingActionButton)findViewById(R.id.editBtn);
        delete = (FloatingActionButton)findViewById(R.id.deleteBtn);
        detailsFragment = (FasalViewFragment) getFragmentManager().findFragmentById(R.id.fasalFragId);

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

        fasalListView = (ListView) listDialog.findViewById(R.id.list);
        GetAdapters adapter = new GetAdapters(this);
        fasalListView.setAdapter(adapter.getFasalArrayList());

        fasalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemValue = (String) fasalListView.getItemAtPosition(position);
                gettingValues();
                detailsFragment.settingValues(name,season,year);

                FloatingActionsMenu menu = (FloatingActionsMenu)findViewById(R.id.menu);
                menu.setVisibility(View.VISIBLE);
                listDialog.dismiss();
            }
        });

        //now that the dialog is set up, it's time to show it
        listDialog.show();
    }

    private void gettingValues() {
        ModelFasl modelFasl = new ModelFasl();
        Cursor cursor = modelFasl.getFasalDetail(getApplicationContext(),itemValue);
        cursor.moveToFirst();
        name = cursor.getString(cursor.getColumnIndex("cropName"));
        season = cursor.getString(cursor.getColumnIndex("season"));
        year = cursor.getString(cursor.getColumnIndex("year"));

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
