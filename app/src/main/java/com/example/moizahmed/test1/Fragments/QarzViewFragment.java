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
import com.example.moizahmed.test1.Model.ModelLoan;
import com.example.moizahmed.test1.Screens.R;

/**
 * Created by Moiz Ahmed on 5/1/2016.
 */
public class QarzViewFragment extends Fragment {

    private String[] labels;
    private TextView name;
    private TextView land;
    private TextView amount;
    private TextView date;
    Button save;

    EditText zname;
    EditText zland;
    EditText zamount;
    EditText zdate;

    String modifyReference;
    DataBaseHelper dbObject;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_qarz_detail, container, false);
        setLanguage();
        initView(view);

        return view;

    }

    private void initView(View view) {

        name = (TextView)view.findViewById(R.id.txt_loan_name);
        land = (TextView) view.findViewById(R.id.txt_loan_land);
        amount = (TextView)view.findViewById(R.id.txt_loan_amount);
        date = (TextView)view.findViewById(R.id.txt_loan_date);
        save = (Button)view.findViewById(R.id.saveBtn);

        zname = (EditText)view.findViewById(R.id.view_loan_name);
        zland = (EditText)view.findViewById(R.id.view_loan_land);
        zamount = (EditText)view.findViewById(R.id.view_loan_amount);
        zdate = (EditText)view.findViewById(R.id.view_loan_date);


        dbObject = new DataBaseHelper(getActivity().getApplicationContext());


        zname.setEnabled(false);
        zland.setEnabled(false);
        zamount.setEnabled(false);
        zdate.setEnabled(false);

    }
    private void setLabels() {
        name.setText(labels[0]);
        land.setText(labels[1]);
        amount.setText(labels[2]);
        date.setText(labels[3]);

    }


    private void setLanguage() {

        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_rozqarz);
        } else {
            labels = getResources().getStringArray(R.array.sindhi_rozqarz);
        }
    }

    public void Editable() {

        zname.setEnabled(true);
        zland.setEnabled(true);
        zamount.setEnabled(true);
        zdate.setEnabled(true);

        zname.setFocusableInTouchMode(true);
        zland.setFocusableInTouchMode(true);
        zamount.setFocusableInTouchMode(true);
        zdate.setFocusableInTouchMode(true);

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

        zname.setEnabled(false);
        zland.setEnabled(false);
        zamount.setEnabled(false);
        zdate.setEnabled(false);
        save.setVisibility(View.GONE);

    }

    private void setZameenObject() {


        ModelLoan modelLoan = new ModelLoan();

        modelLoan.setName(zname.getText().toString());
        modelLoan.setLandNumber(zland.getText().toString());
        modelLoan.setAmount(zamount.getText().toString());
        modelLoan.setDate(zdate.getText().toString());
        dbObject.modifyLoanToDb(modelLoan,modifyReference);

    }

    public void DeleteEntry() {

        AlertDialog.Builder b=  new  AlertDialog.Builder(getActivity())
                .setTitle(R.string.warning)
                .setMessage(R.string.warningMessage)
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dbObject.deleteLoanFromDb(modifyReference);
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

        zname.setText("");
        zland.setText("");
        zamount.setText("");
        zdate.setText("");

    }

    public void settingValues(String name, String land, String amount, String date) {

        setLabels();

        zname.setText(name);
        zland.setText(land);
        zamount.setText(amount);
        zdate.setText(date);


        //Setting refernce for Db
        modifyReference = zname.getText().toString();

    }
}
