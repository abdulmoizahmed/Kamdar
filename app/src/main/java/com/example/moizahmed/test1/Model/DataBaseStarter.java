package com.example.moizahmed.test1.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Moiz Ahmed on 2/5/2016.
 */
public class DataBaseStarter extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Khaatah";

    private String CREATE_LAND = "CREATE TABLE IF NOT EXISTS Land(landNumber TEXT PRIMARY KEY,landOwner VARCHAR,dimensions VARCHAR,landLoc VARCHAR);";
    private String CREATE_CROP = "CREATE TABLE IF NOT EXISTS Crop(cropName TEXT PRIMARY KEY,season VARCHAR,year VARCHAR);";
    private String CREATE_SEED = "CREATE TABLE IF NOT EXISTS Seeds(ID VARCHAR PRIMARY KEY,name VARCHAR,company VARCHAR,quantity VARCHAR,expense VARCHAR,date VARCHAR);";
    private String CREATE_FERTILIZER = "CREATE TABLE IF NOT EXISTS Fertilizer(ID VARCHAR PRIMARY KEY,name VARCHAR ,company VARCHAR,quantity VARCHAR,expense VARCHAR,date VARCHAR);";
    private String CREATE_ISSUESEED = "CREATE TABLE IF NOT EXISTS IssueSeeds(ID VARCHAR,landNumber TEXT,expense VARCHAR,company VARCHAR,quantity VARCHAR,date VARCHAR,FOREIGN KEY(ID) REFERENCES Seeds(ID),FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";
    private String CREATE_ISSUEFERTILIZER = "CREATE TABLE IF NOT EXISTS IssueFertilizer(ID VARCHAR,landNumber TEXT ,company VARCHAR,quantity VARCHAR,expense VARCHAR,date VARCHAR,FOREIGN KEY(ID) REFERENCES Fertilizer(ID),FOREIGN KEY(landNumber) REFERENCES Land(landNumber),FOREIGN KEY(company) REFERENCES Fertilizer(company));";
    private String CREATE_MEDICINE = "CREATE TABLE IF NOT EXISTS Medicine(ID VARCHAR PRIMARY KEY,name VARCHAR ,company VARCHAR,expense VARCHAR,date VARCHAR);";
    private String CREATE_FARMER = "CREATE TABLE IF NOT EXISTS Farmer(CNIC TEXT PRIMARY KEY,landNumber TEXT,cropName TEXT,name VARCHAR ,salary VARCHAR,address TEXT,phone VARCHAR,conditions VARCHAR,contratcType VARCHAR,experience VARCHAR,FOREIGN KEY(landNumber) REFERENCES Land(landNumber), FOREIGN KEY(cropName) REFERENCES Crop(cropName));";
    private String CREATE_SURVEY = "CREATE TABLE IF NOT EXISTS Survey(surveyCode TEXT PRIMARY KEY NOT NULL,landNumber VARCHAR ,company VARCHAR,expense VARCHAR,pH VARCHAR,date VARCHAR,FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";
    private String CREATE_NEWMACHINE = "CREATE TABLE IF NOT EXISTS NewMachine(modelNumber VARCHAR PRIMARY KEY,name VARCHAR,companyName VARCHAR,ownershipStatus VARCHAR,quantity VARCHAR,Expense VARCHAR,date VARCHAR);";
    private String CREATE_ISSUEMACHINE = "CREATE TABLE IF NOT EXISTS IssueMachine(modelNumber VARCHAR,landNumber TEXT,cropName TEXT,duration VARCHAR,expense VARCHAR,date VARCHAR, FOREIGN KEY(modelNumber) REFERENCES NewMachine(modelNumber),FOREIGN KEY(landNumber) REFERENCES Land(landNumber),FOREIGN KEY(cropName) REFERENCES Crop(cropName));";
    private String CREATE_ISSUEMEDICINE = "CREATE TABLE IF NOT EXISTS IssueMedicine(ID VARCHAR,cropName TEXT,quantity VARCHAR,expense VARCHAR,date VARCHAR, FOREIGN KEY(ID) REFERENCES Medicine(ID),FOREIGN KEY(cropName) REFERENCES Crop(cropName));";
    private String CREATE_TAX = "CREATE TABLE IF NOT EXISTS Tax(ID VARCHAR PRIMARY KEY,landNumber TEXT,type VARCHAR,company VARCHAR,expense VARCHAR,date VARCHAR, FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";
    private String CREATE_ISSUEWATER = "CREATE TABLE IF NOT EXISTS IssueWater(landNumber TEXT,duration VARCHAR,date VARCHAR, FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";
    private String CREATE_LOAN = "CREATE TABLE IF NOT EXISTS Loan(CNIC TEXT,landNumber TEXT,amount VARCHAR,date VARCHAR, FOREIGN KEY(CNIC) REFERENCES Farmer(CNIC),FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";

    //constructor
    public DataBaseStarter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//Creation of DataBase
        db.execSQL(CREATE_LAND);
        db.execSQL(CREATE_CROP);
        db.execSQL(CREATE_SEED);
        db.execSQL(CREATE_FERTILIZER);
        db.execSQL(CREATE_ISSUEFERTILIZER);
        db.execSQL(CREATE_TAX);
        db.execSQL(CREATE_FARMER);
        db.execSQL(CREATE_ISSUEMACHINE);
        db.execSQL(CREATE_ISSUEMEDICINE);
        db.execSQL(CREATE_LOAN);
        db.execSQL(CREATE_ISSUESEED);
        db.execSQL(CREATE_ISSUEWATER);
        db.execSQL(CREATE_MEDICINE);
        db.execSQL(CREATE_SURVEY);
        db.execSQL(CREATE_NEWMACHINE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertKhadToDb(ModelKhad modelKhad) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Fertilizer VALUES('" + modelKhad.getID().toString() + "','" + modelKhad.getName().toString() + "','" + modelKhad.getCompany().toString() + "','" + modelKhad.getQuantity().toString() + "','" + modelKhad.getExpense().toString() + "','" + modelKhad.getDate().toString() + "')");
    }


    public void insertFaslToDb(ModelFasl modelFasl) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Crop VALUES('" + modelFasl.getCropName().toString() + "','" + modelFasl.getSeason().toString() + "','" + modelFasl.getYear().toString() + "')");
    }


    public void insertSeedToDb(ModelSeed modelSeed) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Seeds VALUES('" + modelSeed.getID().toString() + "','" + modelSeed.getName().toString() + "','" + modelSeed.getCompany().toString() + "','" + modelSeed.getQuantity().toString() + "','" + modelSeed.getExpense().toString() + "','" + modelSeed.getDate().toString() + "')");
    }

    public void insertLandToDb(ModelLand modelLand) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Land VALUES('" + modelLand.getLandNumber().toString() + "','" + modelLand.getLandOwner().toString() + "','" + modelLand.getDimensions().toString() + "','" + modelLand.getLandLoc().toString() + "')");
    }

    public void insertMedicineToDb(ModelMedicine modelMedicine) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Medicine VALUES('" + modelMedicine.getID().toString() + "','" + modelMedicine.getName().toString() + "','" + modelMedicine.getCompany().toString() + "','" + modelMedicine.getExpense().toString() + "','" + modelMedicine.getDate().toString() + "')");
    }

    public void insertMachineToDb(ModelMachine modelMachine) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO NewMachine VALUES('" + modelMachine.getModelNumber().toString() + "','" + modelMachine.getName().toString() + "','" + modelMachine.getCompany().toString() + "','" + modelMachine.getQuantity().toString() + "','" + modelMachine.getExpense().toString() + "','" + modelMachine.getDate().toString() + "','" + modelMachine.getOwner().toString() + "')");
    }


    public void insertIssueMachineToDb(ModelIssueMachine modelIssueMachine) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueMachine VALUES('" + modelIssueMachine.getModelNumber().toString() + "','" + modelIssueMachine.getLandNumber().toString() + "','" + modelIssueMachine.getCropName().toString() + "','" + modelIssueMachine.getDuration().toString() + "','" + modelIssueMachine.getExpense().toString() + "','" + modelIssueMachine.getDate().toString() + "')");
    }


    public void insertSurveyToDb(ModelSurvey modelSurvey) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Survey VALUES('" + modelSurvey.getSurveyCode().toString() + "','" + modelSurvey.getCompany().toString() + "','" + modelSurvey.getExpense().toString() + "','" + modelSurvey.getPh().toString() + "','" + modelSurvey.getDate().toString() + "','" + modelSurvey.getLandNumber().toString() + "')");
    }

    public void insertFarmerToDb(ModelFarmer modelFarmer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Farmer VALUES('" + modelFarmer.getCNIC().toString() + "','" + modelFarmer.getName().toString() + "','" + modelFarmer.getCropName().toString() + "','" + modelFarmer.getSalary().toString() + "','" + modelFarmer.getAddress().toString() + "','" + modelFarmer.getPhone().toString() + "','" + modelFarmer.getConditions().toString() + "','" + modelFarmer.getContract().toString() + "','" + modelFarmer.getExperience().toString() + "','" + modelFarmer.getLandNumber().toString() + "')");
    }
    public void insertIssueFertilizerToDb(ModelIssueFertilizer modelIssueFertilizer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueFertilizer VALUES('" + modelIssueFertilizer.getID().toString() + "','" + modelIssueFertilizer.getLandNumber().toString() + "','" + modelIssueFertilizer.getCompany().toString() + "','" + modelIssueFertilizer.getQuantity().toString() + "','" + modelIssueFertilizer.getExpense().toString() + "','" + modelIssueFertilizer.getDate().toString() + "')");
    }
    public void insertIssueSeedToDb(ModelIssueSeed modelIssueSeed) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueSeeds VALUES('" + modelIssueSeed.getID().toString() + "','" + modelIssueSeed.getLandNumber().toString() + "','" + modelIssueSeed.getCompany().toString() + "','" + modelIssueSeed.getQuantity().toString() + "','" + modelIssueSeed.getExpense().toString() + "','" + modelIssueSeed.getDate().toString() + "')");
    }



    public void insertIssueMedicineToDb(ModelIssueMedicine modelIssueMedicine) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueMedicine VALUES('" + modelIssueMedicine.getID().toString() + "','" + modelIssueMedicine.getCropName().toString() + "','" + modelIssueMedicine.getQuantity().toString() + "','" + modelIssueMedicine.getExpense().toString() + "','" + modelIssueMedicine.getDate().toString() + "')");
    }

    public void insertTaxToDb(ModelTax modelTax) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Tax VALUES('" + modelTax.getID().toString() + "','" + modelTax.getLandNumber().toString() + "','" + modelTax.getType().toString() + "','" + modelTax.getCompany().toString() + "','" + modelTax.getExpense().toString() + "','" + modelTax.getDate().toString() + "')");
    }

    public void insertLoanToDb(ModelLoan modelLoan) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Loan VALUES('" + modelLoan.getCNIC().toString() + "','" + modelLoan.getLandNumber().toString() + "','" + modelLoan.getAmount().toString() + "','" + modelLoan.getDate().toString() + "')");
    }

    public void insertIssueWaterToDb(ModelIssueWater modelIssueWater) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueWater VALUES('" + modelIssueWater.getLandNumber().toString() + "','" + modelIssueWater.getDuration().toString() + "','" + modelIssueWater.getDate().toString() + "')");
    }








    public Cursor retrieveLandNumber()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT landNumber FROM Land;",null);
        return c;
    }

    public Cursor retrieveFasalName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT cropName FROM Crop;",null);
        return c;
    }



}