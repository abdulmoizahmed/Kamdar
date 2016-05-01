package com.example.moizahmed.test1.Model;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by umair on 3/13/2016.
 */
public class ModelFarmer {
    String CNIC;
    String name;
    String CropName;
    String salary;
    String Address;
    String Phone;
    String Conditions;
    String Contract;
    String Experience;
    String landNumber;
    String date;

    public String getDate() {
        return date;
    }

    public String getLandNumber() {
        return landNumber;
    }

    public void setLandNumber(String landNumber) {
        this.landNumber = landNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCropName() {
        return CropName;
    }

    public void setCropName(String CropName) {
        this.CropName = CropName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCNIC() {
        return CNIC;
    }

    public void setCNIC(String CNIC) {
        this.CNIC = CNIC;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getConditions() {
        return Conditions;
    }

    public void setConditions(String Conditions) {
        this.Conditions = Conditions;
    }

    public String getContract() {
        return Contract;
    }

    public void setContract(String Contract) {
        this.Contract = Contract;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public Cursor getFarmerDetail(Context context, String name)
    {
        DataBaseHelper db = new DataBaseHelper(context);
        Cursor c = db.retrieveFarmerDetails(name);;
        return c;
    }

}
