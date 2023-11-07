package com.example.grant20.models.dataModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Admin {
    String mail;
    String name;
    int role;
    int confirm;

    public Admin(String mail, String name, int role, int confirm) {
        this.mail = mail;
        this.name = name;
        this.role = role;
        this.confirm = confirm;
    }

    public Admin(ResultSet resultSet) {
        try {
            this.mail = resultSet.getString(1);
            this.name = resultSet.getString(2);
            this.role = resultSet.getInt(3);
            this.confirm = resultSet.getInt(4);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getConfirm() {
        return confirm;
    }

    public void setConfirm(int confirm) {
        this.confirm = confirm;
    }
}
