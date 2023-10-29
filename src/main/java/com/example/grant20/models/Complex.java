package com.example.grant20.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Complex {

    int id;
    String name;
    String status;
    int house_count;
    String city;

    public Complex(int id, String name, String status, int house_count, String city) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.house_count = house_count;
        this.city = city;

    }
    public Complex(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.name = resultSet.getString(2);
        this.status = resultSet.getString(3);
        this.house_count = resultSet.getInt(4);
        this.city = resultSet.getString(5);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHouse_count() {
        return house_count;
    }

    public void setHouse_count(int house_count) {
        this.house_count = house_count;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
