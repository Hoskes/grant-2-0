package com.example.grant20.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Query {
    public static final String checkAuth = "SELECT 1 FROM authentication WHERE mail=? AND password =?";
    public static final String createUser = "SELECT mail,name,role FROM employee WHERE mail=?";
    public static final String auth_log = "test@mail.ru";
    public static final String auth_psw = "Username1234!";
    public static final String getApartments = "SELECT * FROM apartment";
}
