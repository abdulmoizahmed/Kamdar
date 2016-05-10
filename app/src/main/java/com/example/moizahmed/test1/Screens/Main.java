package com.example.moizahmed.test1.Screens;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxException;
import com.dropbox.sync.android.DbxFileSystem;
import com.example.moizahmed.test1.R;

import com.example.moizahmed.test1.Model.Language;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class Main extends AppCompatActivity {

    ExpandableRelativeLayout layout;
    ExpandableRelativeLayout rozLayout;
    ExpandableRelativeLayout infoLayout;
    ExpandableRelativeLayout reportLayout;
    private String[] labels;
    private Button fasal;
    private Button khad;
    private Button land;
    private Button machine;
    private Button haari;
    private Button seed;
    private Button dawai;

    //roznamcha
    private String[] rozLabels;
    private Button rozKhad;
    private Button tax;
    private Button servey;
    private Button pani;
    private Button rozMachine;
    private Button rozSeed;
    private Button qarz;

//main
private String[] mainLabels;
    private Button in;
    private Button roz;
    private Button info;
    private Button report;

    //viewButtons
    private Button view_fasal;
    private Button view_zameen;
    private Button view_farmer;
    private Button view_khad;
    private Button view_machine;
    private Button view_seed;
    private Button view_survey;
    private Button view_qarz;

    private Intent menu;

    //Reports Buttons

    private Button view_qarz_report;
    private Button view_survey_report;
    private Button view_land_report;
    private Button view_expense_report;
    private Button make_notifications;
    private Button view_annual_fasl;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
       layout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout);
       rozLayout = (ExpandableRelativeLayout) findViewById(R.id.roznamcha_Layout);
       infoLayout = (ExpandableRelativeLayout) findViewById(R.id.malomat_Layout);
       reportLayout= (ExpandableRelativeLayout) findViewById(R.id.report_Layout);

        setLanguage();
        initUI();
        startListener();

    }

    private void initUI() {
      //main

        in = (Button) findViewById(R.id.indiraj);
        roz = (Button) findViewById(R.id.btn_roz);
        info = (Button) findViewById(R.id.btn_info);
        report = (Button) findViewById(R.id.btn_report);

        //initializing the Language buttons
        in.setText(mainLabels[0]);
        roz.setText(mainLabels[1]);
        report.setText(mainLabels[2]);
        info.setText(mainLabels[3]);


        //new input


        fasal =(Button) findViewById(R.id.btn_newfasl);
        khad =(Button) findViewById(R.id.btn_newkhad);
        land=(Button) findViewById(R.id.btn_newzameen);
        machine=(Button) findViewById(R.id.btn_newmachine);
        haari=(Button) findViewById(R.id.btn_newhaari);
        seed=(Button) findViewById(R.id.btn_newseed);
        dawai=(Button) findViewById(R.id.btn_newpesticides);




//init button language
        land.setText(labels[0]);
        machine.setText(labels[1]);
        seed.setText(labels[2]);
        dawai.setText(labels[3]);
        khad.setText(labels[4]);
        haari.setText(labels[5]);
        fasal.setText(labels[6]);
//roznamcha

        rozKhad = (Button) findViewById(R.id.btn_fertilizer);
        tax = (Button) findViewById(R.id.btn_tax);
        servey = (Button) findViewById(R.id.btn_servey);
        pani = (Button) findViewById(R.id.btn_water);
        rozMachine = (Button) findViewById(R.id.btn_Machine);
        rozSeed = (Button) findViewById(R.id.btn_seed);
        qarz = (Button) findViewById(R.id.btn_newqarz);

        pani.setText(rozLabels[0]);
        rozKhad.setText(rozLabels[1]);
        rozSeed.setText(rozLabels[2]);
        rozMachine.setText(rozLabels[3]);
        tax.setText(rozLabels[4]);
        servey.setText(rozLabels[5]);
        qarz.setText(rozLabels[6]);

        //Maloomat Forms

        view_fasal = (Button) findViewById(R.id.btn_viewfasl);
        view_zameen = (Button)findViewById(R.id.btn_viewland);
        view_farmer = (Button)findViewById(R.id.btn_viewhari);
        view_khad = (Button)findViewById(R.id.btn_viewfertilzier);
        view_machine = (Button)findViewById(R.id.btn_viewmachine);
        view_seed = (Button)findViewById(R.id.btn_viewseed);
        view_survey = (Button)findViewById(R.id.btn_viewservey);
        view_qarz = (Button)findViewById(R.id.btn_viewqarz);


        view_qarz_report = (Button) findViewById(R.id.button15);
        view_survey_report = (Button) findViewById(R.id.btn18);
        view_land_report = (Button) findViewById(R.id.button13);
        view_expense_report = (Button) findViewById(R.id.btn16);
        make_notifications = (Button) findViewById(R.id.button12);
        view_annual_fasl = (Button) findViewById(R.id.btn17);



    }

    private void startListener() {
        //Listener
        fasal.setOnClickListener(new Main.MainButtonListener());
        khad.setOnClickListener(new Main.MainButtonListener());
        land.setOnClickListener(new Main.MainButtonListener());
        machine.setOnClickListener(new Main.MainButtonListener());
        haari.setOnClickListener(new Main.MainButtonListener());
        seed.setOnClickListener(new Main.MainButtonListener());
        dawai.setOnClickListener(new Main.MainButtonListener());

        //roznamchaListener
        pani.setOnClickListener(new MainButtonListener());
        rozKhad.setOnClickListener(new MainButtonListener());
        rozSeed.setOnClickListener(new MainButtonListener());
        rozMachine.setOnClickListener(new MainButtonListener());
        tax.setOnClickListener(new MainButtonListener());
        servey.setOnClickListener(new MainButtonListener());
        qarz.setOnClickListener(new MainButtonListener());

        //Malomat listern

        view_fasal.setOnClickListener(new MainButtonListener());
        view_zameen.setOnClickListener(new MainButtonListener());
        view_farmer.setOnClickListener(new MainButtonListener());
        view_khad.setOnClickListener(new MainButtonListener());
        view_machine.setOnClickListener(new MainButtonListener());
        view_seed.setOnClickListener(new MainButtonListener());
        view_survey.setOnClickListener(new MainButtonListener());
        view_qarz.setOnClickListener(new MainButtonListener());




        view_qarz_report.setOnClickListener(new MainButtonListener());
        view_survey_report.setOnClickListener(new MainButtonListener());
        view_land_report.setOnClickListener(new MainButtonListener());
        view_expense_report.setOnClickListener(new MainButtonListener());
        make_notifications.setOnClickListener(new MainButtonListener());
        view_annual_fasl.setOnClickListener(new MainButtonListener());
    }



    public void OnEntry(View view)
    {
        layout.toggle();
        rozLayout.collapse();
        infoLayout.collapse();
        reportLayout.collapse();
    }

    public void OnRoznamcha(View view)
    {
        rozLayout.toggle();
        layout.collapse();
        infoLayout.collapse();
        reportLayout.collapse();
    }

    public void OnMaloomat(View view)
    {
        infoLayout.toggle();
        layout.collapse();
        rozLayout.collapse();
        reportLayout.collapse();
    }
    public void OnReport(View view)
    {

        reportLayout.toggle();
        rozLayout.collapse();
        layout.collapse();
        infoLayout.collapse();

    }

    public void setLanguage() {
        if (Language.getInstance().getLanguageId() == 0) {
            labels = getResources().getStringArray(R.array.urdu_input);
            rozLabels= getResources().getStringArray(R.array.urdu_roznamcha);
            mainLabels= getResources().getStringArray(R.array.urdu_mainMenu);

        } else {
            labels = getResources().getStringArray(R.array.sindhi_input);
            rozLabels= getResources().getStringArray(R.array.sindhi_roznamcha);
            mainLabels= getResources().getStringArray(R.array.sindhi_mainMenu);
        }
    }


    private class MainButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.btn_newfasl:
                    menu = new Intent(Main.this,new_fasl.class);
                    startActivity(menu);
                    break;
                case R.id.btn_newseed:
                    menu = new Intent(Main.this,new_seed.class);
                    startActivity(menu);
                    break;
                case R.id.btn_newhaari:
                    menu = new Intent(Main.this,new_haari.class);
                    startActivity(menu);
                    break;
                case R.id.btn_newkhad:
                    menu = new Intent(Main.this,new_khad.class);
                    startActivity(menu);
                    break;
                case R.id.btn_newmachine:
                    menu = new Intent(Main.this,new_machine.class);
                    startActivity(menu);
                    break;
                case R.id.btn_newpesticides:
                    menu = new Intent(Main.this,new_dawai.class);
                    startActivity(menu);
                    break;
                case R.id.btn_newzameen:
                    menu = new Intent(Main.this,new_land.class);
                    startActivity(menu);
                    break;
                //roznamcha
                case R.id.btn_servey:
                    menu = new Intent(Main.this,roz_servey.class);
                    startActivity(menu);
                    break;
                case R.id.btn_tax:
                    menu = new Intent(Main.this,roz_tax.class);
                    startActivity(menu);
                    break;
                case R.id.btn_fertilizer:
                    menu = new Intent(Main.this,roz_khad.class);
                    startActivity(menu);
                    break;
                case R.id.btn_water:
                    menu = new Intent(Main.this,roz_pani.class);
                    startActivity(menu);

                    break;
                case R.id.btn_Machine:
                    menu = new Intent(Main.this,roz_machine.class);
                    startActivity(menu);
                    break;
                case R.id.btn_seed:
                    menu = new Intent(Main.this,roz_seed.class);
                    startActivity(menu);
                    break;
                case R.id.btn_newqarz:
                    menu = new Intent(Main.this,roz_qarz.class);
                    startActivity(menu);
                    break;

                case R.id.btn_viewfasl:
                    menu = new Intent(Main.this,ViewFasal.class);
                    startActivity(menu);
                    break;
                case R.id.btn_viewland:
                    menu = new Intent(Main.this,ViewZameen.class);
                    startActivity(menu);
                    break;

                case R.id.btn_viewhari:
                    menu = new Intent(Main.this,ViewHari.class);
                    startActivity(menu);
                    break;
                case R.id.btn_viewfertilzier:
                    menu = new Intent(Main.this,ViewKhad.class);
                    startActivity(menu);
                    break;
                case R.id.btn_viewmachine:
                    menu = new Intent(Main.this,ViewMachine.class);
                    startActivity(menu);
                    break;
                case R.id.btn_viewseed:
                    menu = new Intent(Main.this,ViewSeed.class);
                    startActivity(menu);
                    break;
                case R.id.btn_viewservey:
                    menu = new Intent(Main.this,ViewSurvey.class);
                    startActivity(menu);
                    break;

                case R.id.btn_viewqarz:
                    menu = new Intent(Main.this,ViewQarz.class);
                    startActivity(menu);
                    break;

                case R.id.button15:
                    menu = new Intent(Main.this,QarzReport.class);
                    startActivity(menu);
                    break;
                case R.id.btn18:
                    menu = new Intent(Main.this,SurveyReport.class);
                    startActivity(menu);
                    break;
                case R.id.button13:
                    menu = new Intent(Main.this,LandReport.class);
                    startActivity(menu);
                    break;
                case R.id.btn16:
                    menu = new Intent(Main.this,ExpenseReport.class);
                    startActivity(menu);
                    break;
                case R.id.button12:
                    menu = new Intent(Main.this,Notifications.class);
                    startActivity(menu);
                    break;
                case R.id.btn17:
                    menu = new Intent(Main.this,FaslAnnualReport.class);
                    startActivity(menu);
                    break;

            }
        }
    }

}
