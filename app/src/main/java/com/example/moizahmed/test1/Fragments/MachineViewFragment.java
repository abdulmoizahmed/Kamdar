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
import com.example.moizahmed.test1.Model.ModelMachine;
import com.example.moizahmed.test1.R;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

/**
 * Created by Moiz Ahmed on 4/30/2016.
 */
public class MachineViewFragment extends Fragment {


    FloatingActionsMenu v ;

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
        View view = inflater.inflate(R.layout.fragment_machine_detail, container, false);
        setLanguage();
        initView(view);
        return view;

    }

    private void initView(View view) {

        v = (FloatingActionsMenu) getActivity().findViewById(R.id.menu);
        khadNumber = (TextView)view.findViewById(R.id.txt_machine_number);
        khadName = (TextView)view.findViewById(R.id.txt_machine_khad);
        khadCompany = (TextView)view.findViewById(R.id.txt_machine_company);
        khadExpense = (TextView)view.findViewById(R.id.txt_machine_expense);
        khadQuantity = (TextView)view.findViewById(R.id.txt_machine_quantity);
        khadDate = (TextView)view.findViewById(R.id.txt_machine_date);


        ekhadNumber = (EditText) view.findViewById(R.id.view_machine_number);
        ekhadName = (EditText)view.findViewById(R.id.view_machine_khad);
        ekhadCompany = (EditText)view.findViewById(R.id.view_machine_company);
        ekhadExpense = (EditText)view.findViewById(R.id.view_machine_expense);
        ekhadQuantity = (EditText)view.findViewById(R.id.view_machine_quantity);
        ekhadDate = (EditText)view.findViewById(R.id.view_machine_date);



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
            labels = getResources().getStringArray(R.array.urdu_inputmachine);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_inputmachine);
        }
    }

    public void Editable() {
        v = (FloatingActionsMenu) getActivity().findViewById(R.id.menu);
        v.collapse();
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


        ModelMachine modelMachine = new ModelMachine();


        modelMachine.setModelNumber(ekhadNumber.getText().toString());
        modelMachine.setName(ekhadName.getText().toString());
        modelMachine.setCompany(ekhadCompany.getText().toString());
        modelMachine.setExpense(ekhadExpense.getText().toString());
        modelMachine.setQuantity(ekhadQuantity.getText().toString());
        modelMachine.setDate(ekhadDate.getText().toString());

        dbObject.modifyMachineToDb(modelMachine,modifyReference);

    }

    public void DeleteEntry() {

        AlertDialog.Builder b=  new  AlertDialog.Builder(getActivity())
                .setTitle(R.string.warning)
                .setMessage(R.string.warningMessage)
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dbObject.deleteMachineFromDb(modifyReference);
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

        v = (FloatingActionsMenu) getActivity().findViewById(R.id.menu);
        v.collapse();
        v.setVisibility(View.GONE);

        khadNumber.setVisibility(View.GONE);
        khadName.setVisibility(View.GONE);
        khadCompany.setVisibility(View.GONE);
        khadQuantity.setVisibility(View.GONE);
        khadExpense.setVisibility(View.GONE);
        khadDate.setVisibility(View.GONE);

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


