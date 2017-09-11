package com.example.aff02.newrs;

/**
 * Created by AFF02 on 23-Aug-17.
 */

public class DataModel {

    String name,desc;
    int rupees;

    public DataModel() {
    }

    public DataModel(String name, String desc, int rupees) {
        this.name = name;
        this.desc = desc;
        this.rupees = rupees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRupees() {
        return rupees;
    }

    public void setRupees(int rupees) {
        this.rupees = rupees;
    }
}
