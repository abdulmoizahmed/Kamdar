package com.example.moizahmed.test1.Model;

/**
 * Created by Moiz Ahmed on 2/27/2016.
 */
public class ModelKhad {

    ModelKhad modelKhad;
    DataBaseStarter dbObject;
    String name;
    String company;
    String ID;
    String quantity;
    String expense;
    String date;

    public void setModelKhad(ModelKhad modelKhad)
    {

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


    public void saveObject(ModelKhad modelKhad) {
        this.modelKhad = modelKhad;
        dbObject.insertKhadToDb(modelKhad);
    }
}
