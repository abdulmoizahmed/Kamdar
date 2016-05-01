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
import com.example.moizahmed.test1.Model.ModelKhad;
import com.example.moizahmed.test1.Screens.R;

/**
 * Created by Moiz Ahmed on 4/30/2016.
 */
public class KhadViewFragment extends Fragment {
//
//    khadNumber
//    khadName
//    khadCompany
//    khadQuantity
//    khadExpense
//    khadDate


//    ekhadNumber
//    ekhadName
//    ekhadCompany
//    ekhadQuantity
//    ekhadExpense
//    ekhadDate


    TextView khadNumber;
    TextView khadName;
    TextView khadCompany;
    TextView khadQuantity;
    TextView khadExpense;
    TextView khadDate;

    EditText ekhadNumber;
    EditText ekhadName;
    EditText ekhadCompany;
    EditText ekhadQuantity;
    EditText ekhadExpense;
    EditText ekhadDate;




    String[] labels;
    Button save;



    String modifyReference;
    DataBaseHelper dbObject;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_khad_detail, container, false);
        setLanguage();
        initView(view);
        return view;

    }

    private void initView(View view) {


        khadNumber = (TextView)view.findViewById(R.id.txt_khad_number);
        khadName = (TextView)view.findViewById(R.id.txt_khad_name);
        khadCompany = (TextView)view.findViewById(R.id.txt_khad_company);
        khadExpense = (TextView)view.findViewById(R.id.txt_khad_expense);
        khadQuantity = (TextView)view.findViewById(R.id.txt_khad_quantity);
        khadDate = (TextView)view.findViewById(R.id.txt_khad_date);


        ekhadNumber = (EditText) view.findViewById(R.id.view_khad_number);
        ekhadName = (EditText)view.findViewById(R.id.view_khad_name);
        ekhadCompany = (EditText)view.findViewById(R.id.view_khad_company);
        ekhadExpense = (EditText)view.findViewById(R.id.view_khad_expense);
        ekhadQuantity = (EditText)view.findViewById(R.id.view_khad_quantity);
        ekhadDate = (EditText)view.findViewById(R.id.view_khad_date);



        save = (Button)view.findViewById(R.id.saveBtn);

        ekhadNumber.setEnabled(false);
        ekhadName.setEnabled(false);
        ekhadCompany.setEnabled(false);
        ekhadQuantity.setEnabled(false);
        ekhadExpense.setEnabled(false);
        ekhadDate.setEnabled(false);


        dbObject = new DataBaseHelper(getActivity().getApplicationContext());



    }
    private void setLabels() {
    khadNumber.setText(labels[0]);
    khadName.setText(labels[1]);
    khadCompany.setText(labels[2]);
    khadQuantity.setText(labels[3]);
    khadExpense.setText(labels[4]);
    khadDate.setText(labels[5]);

    }


    private void setLanguage() {

        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_inputfertilizer);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputfertilizer);
        }
    }

    public void Editable() {

        ekhadNumber.setEnabled(true);
        ekhadName.setEnabled(true);
        ekhadCompany.setEnabled(true);
        ekhadQuantity.setEnabled(true);
        ekhadExpense.setEnabled(true);
        ekhadDate.setEnabled(true);

        ekhadNumber.setFocusableInTouchMode(true);
        ekhadName.setFocusableInTouchMode(true);
        ekhadCompany.setFocusableInTouchMode(true);
        ekhadQuantity.setFocusableInTouchMode(true);
        ekhadExpense.setFocusableInTouchMode(true);
        ekhadDate.setFocusableInTouchMode(true);


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


        ekhadNumber.setEnabled(false);
        ekhadName.setEnabled(false);
        ekhadCompany.setEnabled(false);
        ekhadQuantity.setEnabled(false);
        ekhadExpense.setEnabled(false);
        ekhadDate.setEnabled(false);




        save.setVisibility(View.GONE);

    }

    private void setZameenObject() {


        ModelKhad modelKhad = new ModelKhad();


      modelKhad.setID(ekhadNumber.getText().toString());
      modelKhad.setName(ekhadName.getText().toString());
      modelKhad.setCompany(ekhadCompany.getText().toString());
      modelKhad.setExpense(ekhadExpense.getText().toString());
      modelKhad.setQuantity(ekhadQuantity.getText().toString());
      modelKhad.setDate(ekhadDate.getText().toString());

        dbObject.modifyFertilizerToDb(modelKhad,modifyReference);

    }

    public void DeleteEntry() {

        AlertDialog.Builder b=  new  AlertDialog.Builder(getActivity())
                .setTitle(R.string.warning)
                .setMessage(R.string.warningMessage)
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dbObject.deleteFertilizerFromDb(modifyReference);
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

        ekhadNumber.setText("");
        ekhadName.setText("");
        ekhadCompany.setText("");
        ekhadQuantity.setText("");
        ekhadExpense.setText("");
        ekhadDate.setText("");




    }

    public void settingValues(String number, String name, String company, String quantity, String expense, String date) {

        setLabels();

        ekhadNumber.setText(number);
        ekhadName.setText(name);
        ekhadCompany.setText(company);
        ekhadQuantity.setText(quantity);
        ekhadExpense.setText(expense);
        ekhadDate.setText(date);

        //Setting refernce for Db
        modifyReference = ekhadName.getText().toString();

    }
}
