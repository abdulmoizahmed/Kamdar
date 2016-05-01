package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by umair on 3/13/2016.
 */
public class ModelMachine {


    String modelNumber;
    String name;
    String company;
    String owner;
    String quantity;
    String expense;
    String date;



    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
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

    public Cursor getMachineDetail(Context context, String name)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveMachineDetails(name);;
        return c;
    }


}
