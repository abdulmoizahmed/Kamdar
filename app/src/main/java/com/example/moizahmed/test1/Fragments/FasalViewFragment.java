package com.example.moizahmed.test1.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelFasl;
import com.example.moizahmed.test1.Screens.R;

/**
 * Created by Moiz Ahmed on 4/26/2016.
 */
public class FasalViewFragment extends Fragment {
    EditText fasalName;
    EditText fasalSeason;
    EditText fasalYear;
    TextView number;
    TextView owner;
    TextView dimension;


    Button save;
    String modifyReference;
    DataBaseHelper dbObject;
    String[] labels;

    public FasalViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       setLanguage();
        View view = inflater.inflate(R.layout.fragment_fasal_detail, container, false);
        initView(view);

        return view;

    }

    private void setLabels() {
        number.setText(labels[0]);
        owner.setText(labels[1]);
        dimension.setText(labels[2]);

    }


    private void setLanguage() {

        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputfasal);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputfasal);
        }
    }

    private void initView(View view) {
        fasalName = (EditText)view.findViewById(R.id.view_fasl_name);
        fasalSeason = (EditText)view.findViewById(R.id.view_fasl_season);
        fasalYear = (EditText)view.findViewById(R.id.view_fasl_year);

        number =(TextView) view.findViewById(R.id.txt_fasl_name);
        owner =(TextView) view.findViewById(R.id.txt_fasl_season);
        dimension =(TextView) view.findViewById(R.id.txt_fasl_year);

        save = (Button)view.findViewById(R.id.saveBtn);

        dbObject = new DataBaseHelper(getActivity().getApplicationContext());


        fasalName.setEnabled(false);
        fasalSeason.setEnabled(false);
        fasalYear.setEnabled(false);
    }

    public void settingValues(String name, String season,String year) {
        setLabels();

        fasalName.setText(name);
        fasalSeason.setText(season);
        fasalYear.setText(year);


        //Setting refernce for Db
        modifyReference = fasalName.getText().toString();
    }

    public void Editable()
    {
        fasalName.setEnabled(true);
        fasalSeason.setEnabled(true);
        fasalYear.setEnabled(true);
        fasalYear.setInputType(InputType.TYPE_DATETIME_VARIATION_DATE);

        fasalName.setFocusableInTouchMode(true);
        fasalSeason.setFocusableInTouchMode(true);
        fasalYear.setFocusableInTouchMode(true);

        makeVisible();
    }

    private void setFaslObject() {
        ModelFasl modelFasl = new ModelFasl();

        modelFasl.setCropName(fasalName.getText().toString());
        modelFasl.setSeason(fasalSeason.getText().toString());
        modelFasl.setYear(fasalYear.getText().toString());
        dbObject.modifyFaslToDb(modelFasl,modifyReference);

    }


    private void makeVisible()
    {
        save.setVisibility(View.VISIBLE);
        //Save Action
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save Button Code
                setFaslObject();
                Toast.makeText(getActivity().getApplicationContext(),"Edit Successfully",Toast.LENGTH_SHORT).show();
                stopEditing();
            }
        });
    }

    private void stopEditing() {



        fasalName.setEnabled(false);
        fasalSeason.setEnabled(false);
        fasalYear.setEnabled(false);
        save.setVisibility(View.GONE);
    }


    public void DeleteEntry() {
        AlertDialog.Builder b=  new  AlertDialog.Builder(getActivity())
                .setTitle(R.string.warning)
                .setMessage(R.string.warningMessage)
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dbObject.deleteFasalFromDb(modifyReference);
                                hideEntry();
                                Toast.makeText(getActivity().getApplicationContext(),"Delete Successfully",Toast.LENGTH_SHORT).show();
                            }
                        }
                )
                .setNegativeButton(R.string.no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        }
                );

        b.show();
    }

    private void hideEntry() {
        fasalName.setText("");
        fasalSeason.setText("");
        fasalYear.setText("");

    }
}
