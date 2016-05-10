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
public class DataBaseHelper extends SQLiteOpenHelper {

    // Logcat tag
    private static final String LOG = "DatabaseHelper";
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "Khaatah.db";

    private String CREATE_LAND = "CREATE TABLE IF NOT EXISTS Land(landNumber TEXT PRIMARY KEY,landOwner VARCHAR NOT NULL,dimensions VARCHAR,landLoc VARCHAR);";
    private String CREATE_CROP = "CREATE TABLE IF NOT EXISTS Crop(cropName TEXT PRIMARY KEY,season VARCHAR,year VARCHAR);";
    private String CREATE_SEED = "CREATE TABLE IF NOT EXISTS Seeds(ID VARCHAR PRIMARY KEY,name VARCHAR,company VARCHAR,quantity VARCHAR,expense VARCHAR,date VARCHAR);";
    private String CREATE_ISSUESEED = "CREATE TABLE IF NOT EXISTS IssueSeeds(ID VARCHAR,landNumber TEXT,quantity VARCHAR,expense VARCHAR,date VARCHAR,FOREIGN KEY(ID) REFERENCES Seeds(ID),FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";
    private String CREATE_FERTILIZER = "CREATE TABLE IF NOT EXISTS Fertilizer(ID VARCHAR PRIMARY KEY,name VARCHAR ,company VARCHAR,quantity VARCHAR,expense VARCHAR,date VARCHAR);";
    private String CREATE_ISSUEFERTILIZER = "CREATE TABLE IF NOT EXISTS IssueFertilizer(ID VARCHAR,landNumber TEXT ,company VARCHAR,quantity VARCHAR,expense VARCHAR,date VARCHAR,FOREIGN KEY(ID) REFERENCES Fertilizer(ID),FOREIGN KEY(landNumber) REFERENCES Land(landNumber),FOREIGN KEY(company) REFERENCES Fertilizer(company));";
    private String CREATE_MEDICINE = "CREATE TABLE IF NOT EXISTS Medicine(ID VARCHAR PRIMARY KEY,name VARCHAR ,company VARCHAR,expense VARCHAR,date VARCHAR);";
    private String CREATE_FARMER = "CREATE TABLE IF NOT EXISTS Farmer(CNIC TEXT PRIMARY KEY,landNumber TEXT,cropName TEXT,name VARCHAR ,salary VARCHAR,address TEXT,phone VARCHAR,conditions VARCHAR,contratcType VARCHAR,experience VARCHAR,date VARCHAR,FOREIGN KEY(landNumber) REFERENCES Land(landNumber), FOREIGN KEY(cropName) REFERENCES Crop(cropName));";
    private String CREATE_SURVEY = "CREATE TABLE IF NOT EXISTS Survey(surveyCode TEXT PRIMARY KEY NOT NULL,landNumber VARCHAR ,company VARCHAR,expense VARCHAR,pH VARCHAR,date VARCHAR,FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";

    private String CREATE_MACHINES = "CREATE TABLE IF NOT EXISTS NewMachines(modelNumber TEXT PRIMARY KEY,name VARCHAR,companyName VARCHAR,ownershipStatus VARCHAR,Expense VARCHAR,date VARCHAR);";

    private String CREATE_ISSUEMACHINE = "CREATE TABLE IF NOT EXISTS IssueMachine(modelNumber TEXT,landNumber TEXT,cropName TEXT,duration VARCHAR,expense VARCHAR,date VARCHAR, FOREIGN KEY(modelNumber) REFERENCES NewMachine(modelNumber),FOREIGN KEY(landNumber) REFERENCES Land(landNumber),FOREIGN KEY(cropName) REFERENCES Crop(cropName));";
    private String CREATE_ISSUEMEDICINE = "CREATE TABLE IF NOT EXISTS IssueMedicine(ID VARCHAR,cropName TEXT,quantity VARCHAR,expense VARCHAR,date VARCHAR, FOREIGN KEY(ID) REFERENCES Medicine(ID),FOREIGN KEY(cropName) REFERENCES Crop(cropName));";
    private String CREATE_TAX = "CREATE TABLE IF NOT EXISTS Tax(ID VARCHAR PRIMARY KEY,landNumber TEXT,type VARCHAR,company VARCHAR,expense VARCHAR,date VARCHAR, FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";
    private String CREATE_ISSUEWATER = "CREATE TABLE IF NOT EXISTS IssueWater(landNumber TEXT,duration VARCHAR,date VARCHAR, FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";

    private String CREATE_LOAN = "CREATE TABLE IF NOT EXISTS Loan(name TEXT,landNumber TEXT,amount VARCHAR,date VARCHAR, FOREIGN KEY(name) REFERENCES Farmer(CNIC),FOREIGN KEY(landNumber) REFERENCES Land(landNumber));";

    //constructor
    public DataBaseHelper(Context context) {
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
        db.execSQL(CREATE_MACHINES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Land");
        db.execSQL("DROP TABLE IF EXISTS Crop");
        db.execSQL("DROP TABLE IF EXISTS Seeds");
        db.execSQL("DROP TABLE IF EXISTS IssueSeeds");
        db.execSQL("DROP TABLE IF EXISTS Fertilizer");
        db.execSQL("DROP TABLE IF EXISTS IssueFertilizer");
        db.execSQL("DROP TABLE IF EXISTS Medicine");
        db.execSQL("DROP TABLE IF EXISTS Farmer");
        db.execSQL("DROP TABLE IF EXISTS Survey");
        db.execSQL("DROP TABLE IF EXISTS NewMachines");
        db.execSQL("DROP TABLE IF EXISTS IssueMachines");
        db.execSQL("DROP TABLE IF EXISTS Tax");
        db.execSQL("DROP TABLE IF EXISTS IssueWater");
        db.execSQL("DROP TABLE IF EXISTS Loan");

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


    public void insertMachineToDb(ModelMachine modelMachine) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO NewMachines VALUES('" + modelMachine.getModelNumber().toString() + "','" + modelMachine.getName().toString() + "','" + modelMachine.getCompany().toString() + "','" + modelMachine.getQuantity().toString() + "','" + modelMachine.getExpense().toString() + "','" + modelMachine.getDate().toString() + "')");
    }


    public void insertIssueMachineToDb(ModelIssueMachine modelIssueMachine) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueMachine VALUES('" + modelIssueMachine.getModelNumber().toString() + "','" + modelIssueMachine.getLandNumber().toString() + "','" + modelIssueMachine.getCropName().toString() + "','" + modelIssueMachine.getDuration().toString() + "','" + modelIssueMachine.getExpense().toString() + "','" + modelIssueMachine.getDate().toString() + "')");
    }


    public void insertSurveyToDb(ModelSurvey modelSurvey) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Survey VALUES('" + modelSurvey.getSurveyCode().toString() + "','" + modelSurvey.getCompany().toString() + "','" + modelSurvey.getExpense().toString() + "','" + modelSurvey.getPh().toString() + "','" + modelSurvey.getDate().toString() + "','" + modelSurvey.getLandNumber().toString() + "')");
    }

    public void insertMedicineToDb(ModelMedicine modelMedicine) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Medicine VALUES('" + modelMedicine.getID().toString() + "','" + modelMedicine.getName().toString() + "','" + modelMedicine.getCompany().toString() + "','" + modelMedicine.getExpense().toString() + "','" + modelMedicine.getDate().toString() + "')");
    }


    //CNIC TEXT PRIMARY KEY,
    // landNumber TEXT,
    // cropName TEXT,
    // name VARCHAR ,
    // salary VARCHAR,
    // address TEXT,
    // phone VARCHAR,
    // conditions VARCHAR,
    // contratcType VARCHAR,
    // experience VARCHAR
    // ,date VARCHAR,;";

    public void insertFarmerToDb(ModelFarmer modelFarmer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO Farmer VALUES('" + modelFarmer.getCNIC().toString() + "','" + modelFarmer.getLandNumber().toString() + "','" + modelFarmer.getCropName().toString() + "','" + modelFarmer.getName().toString() + "','"+modelFarmer.getSalary() + "','" + modelFarmer.getAddress().toString() + "','" + modelFarmer.getPhone().toString() + "','" + modelFarmer.getConditions().toString() + "','" + modelFarmer.getContract().toString() + "','" + modelFarmer.getExperience().toString() +  "','" + modelFarmer.getDate().toString() + "')");
    }
    public void insertIssueFertilizerToDb(ModelIssueFertilizer modelIssueFertilizer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueFertilizer VALUES('" + modelIssueFertilizer.getID().toString() + "','" + modelIssueFertilizer.getLandNumber().toString() + "','" + modelIssueFertilizer.getCompany().toString() + "','" + modelIssueFertilizer.getQuantity().toString() + "','" + modelIssueFertilizer.getExpense().toString() + "','" + modelIssueFertilizer.getDate().toString() + "')");
    }
    public void insertIssueSeedToDb(ModelIssueSeed modelIssueSeed) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueSeeds VALUES('" + modelIssueSeed.getID().toString() + "','" + modelIssueSeed.getLandNumber().toString() + "','" + modelIssueSeed.getQuantity().toString() + "','" + modelIssueSeed.getExpense().toString() + "','" + modelIssueSeed.getDate().toString() + "')");
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
        db.execSQL("INSERT INTO Loan VALUES('" + modelLoan.getName().toString() + "','" + modelLoan.getLandNumber().toString() + "','" + modelLoan.getAmount().toString() + "','" + modelLoan.getDate().toString() + "')");
    }

    public void insertIssueWaterToDb(ModelIssueWater modelIssueWater) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("INSERT INTO IssueWater VALUES('" + modelIssueWater.getLandNumber().toString() + "','" + modelIssueWater.getDuration().toString() + "','" + modelIssueWater.getDate().toString() + "')");
    }


//Modifying Query Functions
    //UPDATE Customers
    //    SET ContactName='Alfred Schmidt', City='Hamburg'
    //    WHERE CustomerName='Alfreds Futterkiste';

    public void modifyFaslToDb(ModelFasl modelFasl, String modifyReference) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Crop set cropName = '" +modelFasl.getCropName()+ "' , season = '" + modelFasl.getSeason() + "' , year = '" + modelFasl.getYear() + "' Where cropName = '" +modifyReference+ "' ;");

    }
//                                                                                          CNIC TEXT PRIMARY KEY,landNumber TEXT,cropName TEXT,name VARCHAR ,salary VARCHAR,address TEXT,phone                                                     VARCHAR,conditions VARCHAR,contratcType VARCHAR,experience VARCHAR,FOREIGN KEY(landNumber


    public void modifyLandtoDb(ModelLand modelLand, String modifyReference) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Land set landNumber = '" +modelLand.getLandNumber()+ "' , LandOwner = '" + modelLand.getLandOwner() + "' , dimensions = '" + modelLand.getDimensions() + "' , landLoc = '" + modelLand.getLandLoc() + "' Where landNumber = '" +modifyReference+ "' ;");

    }

    public void modifyFarmerToDb(ModelFarmer modelFarmer, String modifyReference) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Farmer set CNIC = '" +modelFarmer.getCNIC()+ "' , landnumber = '" + modelFarmer.getLandNumber() + "' , cropName = '" + modelFarmer.getCropName() + "', name = '" + modelFarmer.getName() + "', salary = '" + modelFarmer.getSalary() + "', address = '" + modelFarmer.getAddress() + "',  phone = '" + modelFarmer.getPhone() + "', conditions = '" + modelFarmer.getConditions() + "', contratcType = '" + modelFarmer.getContract() + "'   Where CNIC = '" +modifyReference+ "' ;");
    }

    public void modifySurveyToDb(ModelSurvey modelSurvey, String modifyReference) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Survey set surveycode = '" +modelSurvey.getSurveyCode()+ "' , landnumber = '" + modelSurvey.getLandNumber() + "' , company = '" + modelSurvey.getCompany() + "', expense = '" + modelSurvey.getExpense() + "', pH = '" + modelSurvey.getPh() + "', date = '" + modelSurvey.getDate() + "'  Where surveyCode = '" +modifyReference+ "' ;");
    }

    public void modifySeedToDb(ModelSeed modelSeed, String modifyReference) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Seeds set ID = '" +modelSeed.getID()+ "' , name = '" + modelSeed.getName() + "' , company = '" + modelSeed.getCompany() + "', quantity = '" + modelSeed.getQuantity() + "', expense = '" + modelSeed.getExpense() + "', date = '" + modelSeed.getDate() + "'  Where ID = '" +modifyReference+ "' ;");
    }

    public void modifyFertilizerToDb(ModelKhad modelKhad, String modifyReference) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Fertilizer set ID = '" +modelKhad.getID()+ "' , name = '" + modelKhad.getName() + "' , company = '" + modelKhad.getCompany() + "', quantity = '" + modelKhad.getQuantity() + "', expense = '" + modelKhad.getExpense() + "', date = '" + modelKhad.getDate() + "'  Where ID = '" +modifyReference+ "' ;");
    }

    //Loan(name TEXT,
    // landNumber TEXT,
    // amount VARCHAR,
    // date VARCHAR

    public void modifyMachineToDb(ModelMachine modelMachine, String modifyReference) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE NewMachines set modelNumber = '" +modelMachine.getModelNumber()+ "' , name = '" + modelMachine.getName() + "' , companyName = '" + modelMachine.getCompany() + "', ownershipStatus = '" + modelMachine.getOwner() + "', Expense = '" + modelMachine.getExpense() + "', date = '" + modelMachine.getDate() + "'  Where modelNumber = '" +modifyReference+ "' ;");
    }


    public void modifyLoanToDb(ModelLoan modelLoan, String modifyReference) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE Loan set name = '" +modelLoan.getName()+ "' , landNumber = '" + modelLoan.getLandNumber() + "' , amount = '" + modelLoan.getAmount() + "', date = '" + modelLoan.getDate() + "'  Where name = '" +modifyReference+ "' ;");
    }
// DELETE Entries From Table
//DELETE FROM table_name
//    WHERE some_column=some_value;

    public void deleteFasalFromDb(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "DELETE FROM Crop Where cropName = '"+name+"' ";
        db.execSQL(query);
    }

    public void deleteLoanFromDb(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "DELETE FROM Loan Where name = '"+name+"' ";
        db.execSQL(query);
    }

    public void deleteLandFromDb(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "DELETE FROM Land Where landNumber = '"+name+"' ";
        db.execSQL(query);
    }

    public void deleteSeedFromDb(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "DELETE FROM Seeds Where name = '"+name+"' ";
        db.execSQL(query);
    }


    public void deleteFertilizerFromDb(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "DELETE FROM Fertilizer Where name = '"+name+"' ";
        db.execSQL(query);
    }

    public void deleteMachineFromDb(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "DELETE FROM NewMachines Where modelNumber = '"+name+"' ";
        db.execSQL(query);
    }


    public void deleteSurveyFromDb(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "DELETE FROM Survey Where surveyCode = '"+name+"' ";
        db.execSQL(query);
    }

    public void deleteFarmerFromDb(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "DELETE FROM Farmer Where CNIC = '"+name+"' ";
        db.execSQL(query);
    }

    //Retrive Queries
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


    public Cursor retrieveFarmerName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM Farmer;",null);
        return c;
    }

    public Cursor retrieveLoanFarmerName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM Loan;",null);
        return c;
    }


    public Cursor retrieveMachineName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT modelNumber FROM NewMachines;",null);
        return c;
    }


    public Cursor retrieveSeedName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM Seeds;",null);
        return c;
    }

    public Cursor retrieveFertilizerName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT name FROM Fertilizer;",null);
        return c;
    }

    public Cursor retrieveFertilizerID()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT ID FROM Fertilizer;",null);
        return c;
    }

    public Cursor retrieveFertilizerCompany()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT company FROM Fertilizer;",null);
        return c;
    }

    public Cursor retrieveSurvyeName()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT surveyCode FROM Survey;",null);
        return c;
    }
//
    //Retrieving Details

    public Cursor retrieveFasalDetails(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Crop Where cropName = '"+name+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveMedicineID(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Medicine Where ID = '"+name+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveLoanDetails(String name)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Loan Where name = '"+name+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveLandDetails(String number) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Land Where landNumber = '"+number+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveFarmerDetails(String number) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Farmer Where name = '" +number+ "' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveFarmerCnic(String number) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Farmer Where CNIC = '" +number+ "' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }


    public Cursor retrieveMachineDetails(String number) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM NewMachines Where modelNumber = '"+number+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveSeedDetails(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Seeds Where name = '"+name+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveSeedID(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Seeds Where ID = '"+name+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveFertilizerDetails(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Fertilizer Where name = '"+name+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveFertilizerIDD(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Fertilizer Where ID = '"+name+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveServeyDetails(String number) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Survey Where surveyCode = '"+number+"' ";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    //Reports Queries...
    public Cursor retrieveLoanReport() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT b.landNumber,b.amount,b.date,a.name,a.CNIC FROM Loan b INNER JOIN Farmer a ON a.name = b.name";
        // String query = "SELECT * FROM Loan";
        Cursor c = db.rawQuery(query,null);
        return c;
    }

    public Cursor retrieveSurveyReport(String land) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT * FROM Survey Where date = '"+land+"'";
        // String query = "SELECT * FROM Survey";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor retrievetaxTotal(String land) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT expense FROM tax Where landNumber = '"+land+"'";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor retrieveSurveyTotal(String land) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT company FROM Survey Where date = '"+land+"'";
        // String query = "SELECT expense FROM Survey";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor retrieveSeedTotal(String land) {
        SQLiteDatabase db = this.getReadableDatabase();

        String query ="SELECT expense FROM IssueSeeds Where landNumber = '"+land+"'";
        // String query = "SELECT expense FROM Survey";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor retrieveLoanTotal(String land) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT amount FROM Loan Where landNumber = '"+land+"'";
        // String query = "SELECT expense FROM Survey";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor retrieveLandReport(String land) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT * FROM Land,Farmer where Land.landNumber = '" +land+ "' AND Farmer.landNumber = '"+land+"'";
        // String query = "SELECT * FROM Survey";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor retrieveExpenseReportTax(String land,String date1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query ="SELECT * FROM Tax WHERE landNumber = '" + land + "' AND date BETWEEN '01/02/2015' AND '" + date1 + "'";
        //  String query = "SELECT * FROM Tax";
        Cursor c = db.rawQuery(query,null);
        return c;
    }
    public Cursor retrieveExpenseReportSurvey(String land,String date1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String SurveyQuery = "SELECT * FROM Survey WHERE date ='" +land+ "'AND pH BETWEEN '01/02/2015' AND '" +date1+ "'";
        //String SurveyQuery = "SELECT * FROM Survey WHERE date ='" +land+ "'";
        Cursor c = db.rawQuery(SurveyQuery,null);
        return c;
    }
    public Cursor retrieveExpenseReportSeed(String land,String date1) {
        SQLiteDatabase db = this.getReadableDatabase();
        String seedQuery = "SELECT * FROM IssueSeeds WHERE landNumber ='" +land+ "'AND date BETWEEN '01/02/2015' AND '"+date1 + "'";
        //String SurveyQuery = "SELECT * FROM Survey WHERE date ='" +land+ "'";
        Cursor c = db.rawQuery(seedQuery,null);
        return c;
    }
    public Cursor retrieveExpenseReportLoan(String land,String date1) {
        SQLiteDatabase db = this.getReadableDatabase();
        //String SurveyQuery = "SELECT * FROM Survey WHERE date ='" +land+ "'";
        String loanQuery = "SELECT * FROM Loan WHERE landNumber ='" +land+ "'AND date BETWEEN '01/02/2015' AND '" +date1 + "'";

        Cursor c = db.rawQuery(loanQuery,null);

        return c;
    }
    public Cursor retrieveAnnualMachine(String crop,String date1) {
        SQLiteDatabase db = this.getReadableDatabase();
        //String SurveyQuery = "SELECT * FROM Survey WHERE date ='" +land+ "'";
        String TaxQuery = "SELECT * FROM IssueMachine WHERE cropName = '" + crop + "' AND date BETWEEN '01/02/2015' AND '" + date1 + "'";

        Cursor c = db.rawQuery(TaxQuery,null);

        return c;
    }

}