package com.example.moizahmed.test1.Fragments;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moizahmed.test1.Model.DataBaseHelper;
import com.example.moizahmed.test1.Model.Language;
import com.example.moizahmed.test1.Model.ModelLand;
import com.example.moizahmed.test1.R;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by Moiz Ahmed on 4/28/2016.
 */
public class ZameenViewFragment extends Fragment {

    private String[] labels;
    private TextView number;
    private TextView owner;
    private TextView dimension;
    private TextView place;
    Button save;
    FloatingActionsMenu v;

    EditText znumber;
    EditText zowner;
    EditText zdimension;
    EditText zlocation;

    String modifyReference;
    DataBaseHelper dbObject;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zameen_detail, container, false);
           setLanguage();
       initView(view);

        return view;

    }

    private void initView(View view) {
        v = (FloatingActionsMenu) getActivity().findViewById(R.id.menu);


        number= (TextView)view.findViewById(R.id.view_zlandno);
        owner = (TextView) view.findViewById(R.id.view_zone);
        dimension = (TextView)view.findViewById(R.id.v_zdim);
        place = (TextView)view.findViewById(R.id.view_zloc);
        save = (Button)view.findViewById(R.id.saveBtn);

        znumber = (EditText)view.findViewById(R.id.view_land_no);
        zowner = (EditText)view.findViewById(R.id.view_land_owner);
        zdimension = (EditText)view.findViewById(R.id.view_land_dim);
        zlocation = (EditText)view.findViewById(R.id.view_land_loc);


        dbObject = new DataBaseHelper(getActivity().getApplicationContext());


        znumber.setEnabled(false);
        zowner.setEnabled(false);
        zdimension.setEnabled(false);
        zlocation.setEnabled(false);

    }
    private void setLabels() {
        number.setText(labels[0]);
        owner.setText(labels[1]);
        dimension.setText(labels[2]);
        place.setText(labels[3]);

    }


    private void setLanguage() {

        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_newland);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_newland);
        }
    }

    public void Editable() {
        v = (FloatingActionsMenu) getActivity().findViewById(R.id.menu);
        v.collapse();

        znumber.setEnabled(true);
        zowner.setEnabled(true);
        zdimension.setEnabled(true);
        zlocation.setEnabled(true);

        znumber.setFocusableInTouchMode(true);
        zowner.setFocusableInTouchMode(true);
        zdimension.setFocusableInTouchMode(true);
        zlocation.setFocusableInTouchMode(true);

        makeVisible();
    }

    private void makeVisible() {
        save.setVisibility(View.VISIBLE);
        //Save Action
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save Button Code
                setZameenObject();
                Toast.makeText(getActivity().getApplicationContext(),"Edit Successfully",Toast.LENGTH_SHORT).show();
                stopEditing();
            }
        });

    }

    private void stopEditing() {

        znumber.setEnabled(false);
        zowner.setEnabled(false);
        zdimension.setEnabled(false);
        zlocation.setEnabled(false);
        save.setVisibility(View.GONE);

    }

    private void setZameenObject() {


            ModelLand modelLand = new ModelLand();

            modelLand.setLandNumber(znumber.getText().toString());
            modelLand.setLandOwner(zowner.getText().toString());
            modelLand.setDimensions(zdimension.getText().toString());
            modelLand.setLandLoc(zlocation.getText().toString());
            dbObject.modifyLandtoDb(modelLand,modifyReference);

    }

    public void DeleteEntry() {

        AlertDialog.Builder b=  new  AlertDialog.Builder(getActivity())
                .setTitle(R.string.warning)
                .setMessage(R.string.warningMessage)
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dbObject.deleteLandFromDb(modifyReference);
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

        znumber.setText("");
        zowner.setText("");
        zdimension.setText("");
        zlocation.setText("");

        v.collapse();
        v.setVisibility(View.GONE);

        number.setVisibility(View.GONE);
        owner.setVisibility(View.GONE);
        dimension.setVisibility(View.GONE);
        place.setVisibility(View.GONE);

    }

    public void settingValues(String number, String owner, String dimension, String location) {

        setLabels();

        znumber.setText(number);
        zowner.setText(owner);
        zdimension.setText(dimension);
        zlocation.setText(location);


        //Setting refernce for Db
        modifyReference = znumber.getText().toString();

    }
}
