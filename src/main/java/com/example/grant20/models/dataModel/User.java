package com.example.grant20.models.dataModel;

import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private String name;
    private String mail;
    private int roleId;
    public User(String mail){
        try {
            PreparedStatement query = DBConnect.getDBConnect().getConnection().prepareStatement(Query.createUser);
            query.setString(1,mail);
            ResultSet result = query.executeQuery();
            if(result.next()){
                name = result.getString(1);
                mail = result.getString(2);
                roleId = result.getInt(3);
            }
        } catch (SQLException e) {
            System.out.println("User Enter Trouble");
            throw new RuntimeException(e);
        }

    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public int getRoleId() {
        return roleId;
    }
}
