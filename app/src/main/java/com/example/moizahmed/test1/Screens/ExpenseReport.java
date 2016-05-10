package com.example.moizahmed.test1.Screens;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.example.moizahmed.test1.Model.ModelExpenseReport;
import com.example.moizahmed.test1.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExpenseReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense_report);

        getReport();
    }



    public void getReport(){

        int Total = 0;


        ModelExpenseReport modelExpenseReport = new ModelExpenseReport();
        Cursor c1 = modelExpenseReport.getLandNumb(getApplicationContext());
        int landrec = c1.getCount();

        String landNumber = "";



        //oast.makeText(LandReport.this, "Hello Umair :) " + landrec, Toast.LENGTH_SHORT).show();

        TextView tv = (TextView) findViewById(R.id.col1);
        TextView tvb = (TextView) findViewById(R.id.col1b);
        TextView tv2 = (TextView) findViewById(R.id.col2);
        TextView tv3= (TextView) findViewById(R.id.col3);
        TextView tv4 = (TextView) findViewById(R.id.col4);
        TextView tv5 = (TextView) findViewById(R.id.col5);
        TextView tv5b = (TextView) findViewById(R.id.col5b);
        TextView tv6 = (TextView) findViewById(R.id.col6);
        TextView tv7 = (TextView) findViewById(R.id.col7);
        TextView tv8 = (TextView) findViewById(R.id.col8);
        TextView tv9= (TextView) findViewById(R.id.col9);
        TextView tv10 = (TextView) findViewById(R.id.col10);
        TextView tv10b = (TextView) findViewById(R.id.col10b);
        TextView tv11 = (TextView) findViewById(R.id.col11);
        TextView tv12 = (TextView) findViewById(R.id.col12);
        TextView tv13 = (TextView) findViewById(R.id.col13);
        TextView tv13b = (TextView) findViewById(R.id.col13b);
        TextView tv14 = (TextView) findViewById(R.id.col14);
        TextView tv14b = (TextView) findViewById(R.id.col14b);
        TextView tv15 = (TextView) findViewById(R.id.col15);
        TextView tv16 = (TextView) findViewById(R.id.col16);
        TextView tv17 = (TextView) findViewById(R.id.col17);
        TextView tv18 = (TextView) findViewById(R.id.col18);
        TextView tv19 = (TextView) findViewById(R.id.col19);

        TextView r2tv = (TextView) findViewById(R.id.r2col1);
        TextView r2tvb = (TextView) findViewById(R.id.r2col1b);
        TextView r2tv2 = (TextView) findViewById(R.id.r2col2);
        TextView r2tv3= (TextView) findViewById(R.id.r2col3);
        TextView r2tv4 = (TextView) findViewById(R.id.r2col4);
        TextView r2tv5 = (TextView) findViewById(R.id.r2col5);
        TextView r2tv5b = (TextView) findViewById(R.id.r2col5b);
        TextView r2tv6 = (TextView) findViewById(R.id.r2col6);
        TextView r2tv7 = (TextView) findViewById(R.id.r2col7);
        TextView r2tv8 = (TextView) findViewById(R.id.r2col8);
        TextView r2tv9= (TextView) findViewById(R.id.r2col9);
        TextView r2tv10 = (TextView) findViewById(R.id.r2col10);
        TextView r2tv10b = (TextView) findViewById(R.id.r2col10b);
        TextView r2tv11 = (TextView) findViewById(R.id.r2col11);
        TextView r2tv12 = (TextView) findViewById(R.id.r2col12);
        TextView r2tv13 = (TextView) findViewById(R.id.r2col13);
        TextView r2tv13b = (TextView) findViewById(R.id.r2col13b);
        TextView r2tv14 = (TextView) findViewById(R.id.r2col14);
        TextView r2tv14b = (TextView) findViewById(R.id.r2col14b);
        TextView r2tv15 = (TextView) findViewById(R.id.r2col15);
        TextView r2tv16 = (TextView) findViewById(R.id.r2col16);
        TextView r2tv17 = (TextView) findViewById(R.id.r2col17);
        TextView r2tv18 = (TextView) findViewById(R.id.r2col18);
        TextView r2tv19 = (TextView) findViewById(R.id.r2col19);



        StringBuilder col19 = new StringBuilder("زمین نمبر");


        StringBuilder col18 = new StringBuilder("ٹیکس نمبر");
        StringBuilder col17 = new StringBuilder("قسم");
        StringBuilder col16 = new StringBuilder("کمپنی کا نام");
        StringBuilder col15 = new StringBuilder("خرچ");
        StringBuilder col14 = new StringBuilder("تاریخ");
        StringBuilder col14b = new StringBuilder("ٹوٹل خرچ");

        StringBuilder col13b = new StringBuilder("زمین نمبر");
        StringBuilder col13 = new StringBuilder("سروے نمبر");
        StringBuilder col12 = new StringBuilder("کمپنی کا نام");
        StringBuilder col11 = new StringBuilder("خرچ");
        StringBuilder col10 = new StringBuilder("تاریخ");
        StringBuilder col10b = new StringBuilder("ٹوٹل خرچ");

        StringBuilder col9 = new StringBuilder("زمین نمبر");
        StringBuilder col8 = new StringBuilder("انوائس نمبر");
        StringBuilder col7 = new StringBuilder("بوریاں");
        StringBuilder col6 = new StringBuilder("خرچ");
        StringBuilder col5 = new StringBuilder("تاریخ");
        StringBuilder col5b = new StringBuilder("ٹوٹل خرچ");

        StringBuilder col4 = new StringBuilder("زمین نمبر");
        StringBuilder col3 = new StringBuilder("کسان CNIC");
        StringBuilder col2 = new StringBuilder("قرض رقم");
        StringBuilder col1 = new StringBuilder("تاریخ");
        StringBuilder col1b = new StringBuilder("ٹوٹل خرچ");
        StringBuilder col0 = new StringBuilder("زمین ٹوٹل خرچ");


        StringBuilder r2col0 = new StringBuilder("");
        StringBuilder r2col1 = new StringBuilder("");
        StringBuilder r2col1b = new StringBuilder("");
        StringBuilder r2col2 = new StringBuilder("");
        StringBuilder r2col3 = new StringBuilder("");
        StringBuilder r2col4 = new StringBuilder("");
        StringBuilder r2col5 = new StringBuilder("");
        StringBuilder r2col5b = new StringBuilder("");
        StringBuilder r2col6 = new StringBuilder("");
        StringBuilder r2col7 = new StringBuilder("");
        StringBuilder r2col8 = new StringBuilder("");
        StringBuilder r2col9 = new StringBuilder("");
        StringBuilder r2col10 = new StringBuilder("");
        StringBuilder r2col10b = new StringBuilder("");
        StringBuilder r2col11 = new StringBuilder("");
        StringBuilder r2col12 = new StringBuilder("");
        StringBuilder r2col13 = new StringBuilder("");
        StringBuilder r2col13b = new StringBuilder("");
        StringBuilder r2col14 = new StringBuilder("");
        StringBuilder r2col14b = new StringBuilder("");
        StringBuilder r2col15 = new StringBuilder("");
        StringBuilder r2col16 = new StringBuilder("");
        StringBuilder r2col17 = new StringBuilder("");
        StringBuilder r2col18 = new StringBuilder("");
        StringBuilder r2col19 = new StringBuilder("");


        tv.setText(col1);
        tvb.setText(col1b);
        tv2.setText(col2);
        tv3.setText(col3);
        tv4.setText(col4);
        tv5.setText(col5);
        tv5b.setText(col5b);
        tv6.setText(col6);
        tv7.setText(col7);
        tv8.setText(col8);
        tv9.setText(col9);
        tv10.setText(col10);
        tv10b.setText(col10b);
        tv11.setText(col11);
        tv12.setText(col12);
        tv13.setText(col13);
        tv13b.setText(col13b);
        tv14.setText(col14);
        tv14b.setText(col14b);
        tv15.setText(col15);
        tv16.setText(col16);
        tv17.setText(col17);
        tv18.setText(col18);
        tv19.setText(col19);


        Calendar cal = Calendar.getInstance();
        System.out.println("Current time => " + cal.getTime());

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String date1 = df.format(cal.getTime());

        String[] temp = date1.split("/");
        int year = Integer.parseInt(temp[2]);
        year--;
        year--;
        temp[2] = String.valueOf(year);

        String date = temp[0]+"/"+temp[1]+"/"+temp[2];

        while(c1.moveToNext()) {

            String c = c1.getString(0);
            r2col19.append(c + "\n");


            Cursor c2 = modelExpenseReport.getLandReportTax(getApplicationContext(), c, date1);
            int records = c2.getCount();
            //  Toast.makeText(ExpenseReport.this, "records: in " + c + " are " + records, Toast.LENGTH_SHORT).show();
            Cursor d2 = modelExpenseReport.getTaxTotal(getApplicationContext(),c);
            int record = d2.getCount();
            int sum = 0;
            while(d2.moveToNext()){
                sum += Integer.parseInt(d2.getString(0));

            }

//            Toast.makeText(ExpenseReport.this, "tax sum: in " + c + " is " + sum, Toast.LENGTH_SHORT).show();

            c2.moveToFirst();

            if (records > 0) {
                r2col14b.append(sum );
                do {
                    String taxID = c2.getString(0);
                    String type = c2.getString(2);
                    String tComp = c2.getString(3);
                    String tExp = c2.getString(4);
                    String tDate = c2.getString(5);

                    r2col18.append(taxID + "\n");
                    r2col17.append(type + "\n");
                    r2col16.append(tComp + "\n");
                    r2col15.append(tExp + "\n");
                    r2col14.append(tDate + "\n");
                    r2col14b.append("\n");
                    r2col19.append("\n");
                } while (c2.moveToNext());
            }
            r2col18.append("\n");
            r2col17.append("\n");
            r2col16.append("\n");
            r2col15.append("\n");
            r2col14.append("\n");
            r2col14b.append("\n");

        }

        c1.moveToFirst();
        do {

            if(c1.getCount()>0){
            String c = c1.getString(0);
            r2col13b.append(c + "\n");

            Cursor c3 = modelExpenseReport.getLandReportSurvey(getApplicationContext(), c, date1);
            int records = c3.getCount();
            //    Toast.makeText(ExpenseReport.this, "Survey records: in " + c + " are " + records, Toast.LENGTH_SHORT).show();
            Cursor d3 = modelExpenseReport.getSurveyTotal(getApplicationContext(), c);
            int record = d3.getCount();
            int sum = 0;
            while (d3.moveToNext()) {
                sum += Integer.parseInt(d3.getString(0));
            }
            //Toast.makeText(ExpenseReport.this, record + "Survey sum: in " + c + " is " + sum, Toast.LENGTH_SHORT).show();

            c3.moveToFirst();
            if (records > 0) {
                r2col10b.append(sum);
                do {
                    String surID = c3.getString(0);
                    String surComp = c3.getString(1);
                    String surExp = c3.getString(2);
                    String surDate = c3.getString(4);

                    r2col13.append(surID + "\n");
                    r2col12.append(surComp + "\n");
                    r2col11.append(surExp + "\n");
                    r2col10.append(surDate + "\n");
                    r2col10b.append("\n");
                    r2col13b.append("\n");
                } while (c3.moveToNext());

            }
            r2col13.append("\n");
            r2col12.append("\n");
            r2col11.append("\n");
            r2col10.append("\n");
            r2col10b.append("\n");
        }
        }while(c1.moveToNext());


        c1.moveToFirst();
        do {
            if (c1.getCount() > 0){
                String c = c1.getString(0);
            r2col8.append(c + "\n");

            Cursor c4 = modelExpenseReport.getLandReportSeed(getApplicationContext(), c, date1);
            int records = c4.getCount();
            // Toast.makeText(ExpenseReport.this, "seed records: in " + c + " are " + records, Toast.LENGTH_SHORT).show();
            c4.moveToFirst();
            Cursor d3 = modelExpenseReport.getSeedTotal(getApplicationContext(), c);
            int record = d3.getCount();
            int sum = 0;
            while (d3.moveToNext()) {
                sum += Integer.parseInt(d3.getString(0));
            }
            // Toast.makeText(ExpenseReport.this, record + "Survey sum: in " + c + " is " + sum, Toast.LENGTH_SHORT).show();


            if (records > 0) {
                r2col5b.append(sum);
                do {
                    String seedID = c4.getString(0);
                    //String landNo = c4.getString(1);
                    String sQuan = c4.getString(2);
                    String sExp = c4.getString(3);
                    String sDate = c4.getString(4);

                    r2col9.append(seedID + "\n");
                    //  r2col8.append(landNo + "\n");
                    r2col7.append(sQuan + "\n");
                    r2col6.append(sExp + "\n");
                    r2col5.append(sDate + "\n");
                    r2col5b.append("\n");
                    r2col8.append("\n");


                } while (c4.moveToNext());

            }
            r2col9.append("\n");
            //r2col8.append("\n");
            r2col7.append("\n");
            r2col6.append("\n");
            r2col5.append("\n");
            r2col5b.append("\n");
        }
            }while(c1.moveToNext());



         c1.moveToFirst();
        do {

            String c = c1.getString(0);
            r2col3.append(c + "\n");

            Cursor c5 = modelExpenseReport.getLandReportLoan(getApplicationContext(), c, date1);
            int records = c5.getCount();
          //  Toast.makeText(ExpenseReport.this, "loan records: in " + c + " are " + records, Toast.LENGTH_SHORT).show();
            c5.moveToFirst();
            Cursor d3 = modelExpenseReport.getLoanTotal(getApplicationContext(), c);
            int record = d3.getCount();
            int sum = 0;
            while(d3.moveToNext()){
                String str = d3.getString(0);
                str = str.replace("$","");
                str = str.replace("Rs","");
                str = str.replace(",","");

                Log.d("expense","MyStr = " +str );
                sum += Integer.parseInt(str);
            }
             //Toast.makeText(ExpenseReport.this, record + "Survey sum: in " + c + " is " + sum, Toast.LENGTH_SHORT).show();

            if(records > 0) {
                r2col1b.append(sum );
                do {

                    String CNIC = c5.getString(0);
                   // String lLand = c5.getString(1);
                    String lAmount = c5.getString(2);
                    String lDate = c5.getString(3);

                    r2col4.append(CNIC + "\n");
                 //   r2col3.append(lLand + "\n");
                    r2col2.append(lAmount + "\n");
                    r2col1.append(lDate + "\n");
                    r2col1b.append("\n");
                    r2col3.append("\n");

                } while (c5.moveToNext());
            }



            r2col4.append("\n");
           // r2col3.append("\n");
            r2col2.append("\n");
            r2col1.append("\n");
            r2col1b.append("\n");

        }while(c1.moveToNext());





        r2tv.setText(r2col1);
        r2tvb.setText(r2col1b);
        r2tv2.setText(r2col2);
        r2tv3.setText(r2col4);
        r2tv4.setText(r2col3);

        r2tv5b.setText(r2col5b);
        r2tv5.setText(r2col5);
        r2tv6.setText(r2col6);
        r2tv7.setText(r2col7);
        r2tv8.setText(r2col9);
        r2tv9.setText(r2col8);

        r2tv10b.setText(r2col10b);
        r2tv10.setText(r2col10);
        r2tv11.setText(r2col11);
        r2tv12.setText(r2col12);
        r2tv13.setText(r2col13);
        r2tv13b.setText(r2col13b);

        r2tv14b.setText(r2col14b);
        r2tv14.setText(r2col14);
        r2tv15.setText(r2col15);
        r2tv16.setText(r2col16);
        r2tv17.setText(r2col17);
        r2tv18.setText(r2col18);

        r2tv19.setText(r2col19);


    }
}
