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
import com.example.moizahmed.test1.Model.ModelFarmer;
import com.example.moizahmed.test1.R;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by Moiz Ahmed on 4/30/2016.
 */
public class HariViewFragment extends Fragment {


    TextView tHariName;
    TextView tHariLand;
    TextView tHariCrop;
    TextView tHariDate;
    TextView tHariAddress;
    TextView tHariPhone;
    TextView tHariSalary;
    TextView tHariCondition;
    TextView tHariContract;
    TextView tHariCnic;
    TextView tHariExperience;

    EditText HariName;
    EditText HariLand;
    EditText HariCrop;
    EditText HariDate;
    EditText HariAddress;
    EditText HariPhone;
    EditText HariSalary;
    EditText HariCondition;
    EditText HariContract;
    EditText HariCnic;
    EditText HariExperience;
    FloatingActionsMenu v;


    String[] labels;
    Button save;



    String modifyReference;
    DataBaseHelper dbObject;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hari_detail, container, false);
        setLanguage();
        initView(view);

        return view;

    }

    private void initView(View view) {

        tHariName = (TextView)view.findViewById(R.id.txt_hari_name);
        tHariLand= (TextView)view.findViewById(R.id.txt_hari_zameen);
        tHariCrop= (TextView)view.findViewById(R.id.txt_hari_fasal);
        tHariDate= (TextView)view.findViewById(R.id.txt_hari_date);
        tHariAddress= (TextView)view.findViewById(R.id.txt_hari_address);
        tHariPhone= (TextView)view.findViewById(R.id.txt_hari_phone);
        tHariSalary= (TextView)view.findViewById(R.id.txt_hari_salary);
        tHariCondition= (TextView)view.findViewById(R.id.txt_hari_condition);
        tHariContract= (TextView)view.findViewById(R.id.txt_hari_contract);
        tHariCnic= (TextView)view.findViewById(R.id.txt_hari_cnic);
        tHariExperience= (TextView)view.findViewById(R.id.txt_hari_experience);


        HariName = (EditText)view.findViewById(R.id.view_hari_name);
        HariLand= (EditText)view.findViewById(R.id.view_hari_zameen);
        HariCrop= (EditText)view.findViewById(R.id.view_hari_fasal);
        HariDate= (EditText)view.findViewById(R.id.view_hari_date);
        HariAddress= (EditText)view.findViewById(R.id.view_hari_address);
        HariPhone= (EditText)view.findViewById(R.id.view_hari_phone);
        HariSalary= (EditText)view.findViewById(R.id.view_hari_salary);
        HariCondition= (EditText)view.findViewById(R.id.view_hari_condition);
        HariContract= (EditText)view.findViewById(R.id.view_hari_contract);
        HariCnic= (EditText)view.findViewById(R.id.view_hari_cnic);
        HariExperience= (EditText)view.findViewById(R.id.view_hari_experience);


        save = (Button)view.findViewById(R.id.saveBtn);


        HariName.setEnabled(false);
        HariLand.setEnabled(false);
        HariCrop.setEnabled(false);
        HariDate.setEnabled(false);
        HariAddress.setEnabled(false);
        HariPhone.setEnabled(false);
        HariSalary.setEnabled(false);
        HariCondition.setEnabled(false);
        HariContract.setEnabled(false);
        HariCnic.setEnabled(false);
        HariExperience.setEnabled(false);


        dbObject = new DataBaseHelper(getActivity().getApplicationContext());



    }
    private void setLabels() {
        tHariName.setText(labels[0]);
        tHariLand.setText(labels[1]);
        tHariCrop.setText(labels[2]);
        tHariDate.setText(labels[3]);
        tHariAddress.setText(labels[4]);
        tHariPhone.setText(labels[5]);
        tHariSalary.setText(labels[6]);
        tHariCondition.setText(labels[7]);
        tHariContract.setText(labels[8]);
        tHariCnic.setText(labels[9]);
        tHariExperience.setText(labels[10]);

    }


    private void setLanguage() {

        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputHari);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputHari);
        }
    }

    public void Editable() {
        v = (FloatingActionsMenu) getActivity().findViewById(R.id.menu);
        v.collapse();
        HariName.setEnabled(true);
        HariLand.setEnabled(true);
        HariCrop.setEnabled(true);
        HariDate.setEnabled(true);
        HariAddress.setEnabled(true);
        HariPhone.setEnabled(true);
        HariSalary.setEnabled(true);
        HariCondition.setEnabled(true);
        HariContract.setEnabled(true);
        HariCnic.setEnabled(true);
        HariExperience.setEnabled(true);

        HariName.setFocusableInTouchMode(true);
        HariLand.setFocusableInTouchMode(true);
        HariCrop.setFocusableInTouchMode(true);
        HariDate.setFocusableInTouchMode(true);
        HariAddress.setFocusableInTouchMode(true);
        HariPhone.setFocusableInTouchMode(true);
        HariSalary.setFocusableInTouchMode(true);
        HariCondition.setFocusableInTouchMode(true);
        HariContract.setFocusableInTouchMode(true);
        HariCnic.setFocusableInTouchMode(true);
        HariExperience.setFocusableInTouchMode(true);

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





        HariName.setEnabled(false);
        HariLand.setEnabled(false);
        HariCrop.setEnabled(false);
        HariDate.setEnabled(false);
        HariAddress.setEnabled(false);
        HariPhone.setEnabled(false);
        HariSalary.setEnabled(false);
        HariCondition.setEnabled(false);
        HariContract.setEnabled(false);
        HariCnic.setEnabled(false);
        HariExperience.setEnabled(false);
        save.setVisibility(View.GONE);

    }

    private void setZameenObject() {


        ModelFarmer modelFarmer = new ModelFarmer();

        modelFarmer.setName(HariName.getText().toString());
        modelFarmer.setLandNumber(HariLand.getText().toString());
        modelFarmer.setCropName(HariCrop.getText().toString());
        modelFarmer.setDate(HariDate.getText().toString());
        modelFarmer.setAddress(HariAddress.getText().toString());
        modelFarmer.setPhone(HariPhone.getText().toString());
        modelFarmer.setSalary(HariSalary.getText().toString());
        modelFarmer.setConditions(HariCondition.getText().toString());
        modelFarmer.setContract(HariContract.getText().toString());
        modelFarmer.setCNIC(HariCnic.getText().toString());
        modelFarmer.setExperience(HariExperience.getText().toString());

        dbObject.modifyFarmerToDb(modelFarmer,modifyReference);

    }

    public void DeleteEntry() {

        AlertDialog.Builder b=  new  AlertDialog.Builder(getActivity())
                .setTitle(R.string.warning)
                .setMessage(R.string.warningMessage)
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dbObject.deleteFarmerFromDb(modifyReference);
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

        HariName.setText("");
        HariLand.setText("");
        HariCrop.setText("");
        HariDate.setText("");
        HariAddress.setText("");
        HariPhone.setText("");
        HariSalary.setText("");
        HariCondition.setText("");
        HariContract.setText("");
        HariCnic.setText("");
        HariExperience.setText("");

        v = (FloatingActionsMenu) getActivity().findViewById(R.id.menu);
        v.collapse();
        v.setVisibility(View.GONE);


        tHariName.setVisibility(View.GONE);
        tHariLand.setVisibility(View.GONE);
        tHariCrop.setVisibility(View.GONE);
        tHariDate.setVisibility(View.GONE);
        tHariAddress.setVisibility(View.GONE);
        tHariPhone.setVisibility(View.GONE);
        tHariSalary.setVisibility(View.GONE);
        tHariCondition.setVisibility(View.GONE);
        tHariContract.setVisibility(View.GONE);
        tHariCnic.setVisibility(View.GONE);
        tHariExperience.setVisibility(View.GONE);


    }

    public void settingValues(String cnic, String landNumber, String cropName, String name, String salary, String address, String phone, String conditions, String contract, String experience, String date) {

        setLabels();

        HariName.setText(name);
        HariLand.setText(landNumber);
        HariCrop.setText(cropName);
        HariDate.setText(date);
        HariAddress.setText(address);
        HariPhone.setText(phone);
        HariSalary.setText(salary);
        HariCondition.setText(conditions);
        HariContract.setText(contract);
        HariCnic.setText(cnic);
        HariExperience.setText(experience);

        //Setting refernce for Db
        modifyReference = HariName.getText().toString();

    }
}
