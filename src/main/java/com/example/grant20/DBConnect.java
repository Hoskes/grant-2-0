package com.example.grant20;
import java.sql.*;
public class DBConnect {
    private static DBConnect dbConnect;
    private static Connection connection;
    private DBConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_2260_dbgrant2",
                    "std_2260_dbgrant2", "9999Send");
        } catch (ClassNotFoundException | SQLException e) {
            ////System.out.println(e);
        }
    }
    public static DBConnect getDBConnect(){
        if (dbConnect == null) {
            dbConnect = new DBConnect();
        }
        return dbConnect;
    }
    public Connection getConnection(){
        return connection;
    }
    public ResultSet execute(String query){
        Statement statement = null;
        try {
            statement = getConnection().createStatement();
            ResultSet result = statement.executeQuery(query);
            System.out.println(result);
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
