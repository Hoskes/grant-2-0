package com.example.grant20.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class House {
    int id;
    String number;
    int addedValue;
    int buildingCosts;
    String complexName;

    public House(int id, String number, int addedValue, int buildingCosts, String complexName) {
        this.id = id;
        this.number = number;
        this.addedValue = addedValue;
        this.buildingCosts = buildingCosts;
        this.complexName = complexName;
    }
    public House(ResultSet resultSet) {
        try {
            this.id = resultSet.getInt(1);
            this.number = resultSet.getString(2);
            this.addedValue = resultSet.getInt(3);;
            this.buildingCosts = resultSet.getInt(4);
            this.complexName = resultSet.getString(5);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(int addedValue) {
        this.addedValue = addedValue;
    }

    public int getBuildingCosts() {
        return buildingCosts;
    }

    public void setBuildingCosts(int buildingCosts) {
        this.buildingCosts = buildingCosts;
    }

    public String getComplexName() {
        return complexName;
    }

    public void setComplexName(String complexName) {
        this.complexName = complexName;
    }
    @Override
    public String toString() {
        return "1"+id+"2"+number+"3"+addedValue+"4"+addedValue+"5"+buildingCosts+"6"+complexName;
    }
}
