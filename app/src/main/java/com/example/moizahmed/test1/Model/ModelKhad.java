package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Moiz Ahmed on 2/27/2016.
 */
public class ModelKhad {

    ModelKhad modelKhad;
    DataBaseHelper dbObject;
    String name;
    String company;
    String ID;
    String quantity;
    String expense;
    String date;

    public void setModelKhad(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getExpense() {
        return expense;
    }

    public void setExpense(String expense) {
        this.expense = expense;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void saveObject() {
    //    dbObject.insertKhadToDb();
    }
    public ModelKhad getModelKhad()
    {
        return  modelKhad;
    }

    public Cursor getKhadDetail(Context context, String name)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveFertilizerDetails(name);;
        return c;
    }


}
