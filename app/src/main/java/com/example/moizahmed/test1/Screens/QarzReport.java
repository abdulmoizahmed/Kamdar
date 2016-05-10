package com.example.moizahmed.test1.Screens;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.moizahmed.test1.Model.ModelQarzReport;
import com.example.moizahmed.test1.R;
public class QarzReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qarz_report);

        getReport();
    }

    public void getReport(){


        ModelQarzReport modelQarzReport = new ModelQarzReport();
        Cursor cursor = modelQarzReport.getLoanReport(getApplicationContext());
        int records = cursor.getCount();

      //  Toast.makeText(QarzReport.this, "Hello Umair :) " +records, Toast.LENGTH_SHORT).show();

        TextView tv = (TextView) findViewById(R.id.col1);
        TextView tv2 = (TextView) findViewById(R.id.col2);
        TextView tv3= (TextView) findViewById(R.id.col3);
        TextView tv4 = (TextView) findViewById(R.id.col4);
        TextView tv5 = (TextView) findViewById(R.id.col5);

        TextView r2tv = (TextView) findViewById(R.id.r2col1);
        TextView r2tv2 = (TextView) findViewById(R.id.r2col2);
        TextView r2tv3= (TextView) findViewById(R.id.r2col3);
        TextView r2tv4 = (TextView) findViewById(R.id.r2col4);
        TextView r2tv5 = (TextView) findViewById(R.id.r2col5);


        StringBuilder col5 = new StringBuilder("کسان کا نام");
        StringBuilder col4 = new StringBuilder("کسان سی این ٓا ئی سی");
        StringBuilder col3 = new StringBuilder("زمین نمبر");
        StringBuilder col2 = new StringBuilder("خرچ");
        StringBuilder col1 = new StringBuilder("تاریخ");

        StringBuilder r2col1 = new StringBuilder("");
        StringBuilder r2col2 = new StringBuilder("");
        StringBuilder r2col3 = new StringBuilder("");
        StringBuilder r2col4 = new StringBuilder("");
        StringBuilder r2col5 = new StringBuilder("");


        tv.setText(col1);
        tv2.setText(col2);
        tv3.setText(col3);
        tv4.setText(col4);
        tv5.setText(col5);

        cursor.moveToFirst();

       do
        {
            //Loanreport.append("\n");

            if(cursor.getCount() > 0)
            {
                String a = cursor.getString(cursor.getColumnIndex("name"));
                String b = cursor.getString(cursor.getColumnIndex("CNIC"));
                String c = cursor.getString(cursor.getColumnIndex("landNumber"));
                String d = cursor.getString(cursor.getColumnIndex("amount"));
                String e = cursor.getString(cursor.getColumnIndex("date"));
                r2col5.append(a + "\n");
                r2col4.append(b + "\n");
                r2col3.append(c + "\n");
                r2col2.append(d + "\n");
                r2col1.append(e + "\n");

            }

        }while(cursor.moveToNext());


        r2tv.setText(r2col1);
        r2tv2.setText(r2col2);
        r2tv3.setText(r2col3);
        r2tv4.setText(r2col4);
        r2tv5.setText(r2col5);

    }
}
