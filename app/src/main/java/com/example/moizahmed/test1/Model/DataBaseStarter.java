package com.example.moizahmed.test1.Model;

import android.content.ContentValues;
import android.content.Context;
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




}