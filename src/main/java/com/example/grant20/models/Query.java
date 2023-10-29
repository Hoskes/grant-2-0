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
    public static final String getApartments = "SELECT apartment.id, complex.name, CONCAT(\"ул. \", complex.street, \" д.\", house.number, \" кв.\", apartmentNumber) AS address,\n" +
            "\t\tapartment.area, apartment.rooms, apartment.entrance, apartment.floor, apartment.statusSale\n" +
            "FROM apartment JOIN house ON apartment.houseID=house.id JOIN complex ON house.complexID=complex.id";
    public static final String getHouses = "SELECT house.id, complex.name, complex.street, IF(house.number IS NULL OR house.number = \"\", \"Без номера\", house.number) AS number, complex.statusConstruction, IF(sold_ap.sold IS NULL, 0, sold_ap.sold) AS sold_apartments, IF(not_sold_ap.not_sold IS NULL, 0, not_sold_ap.not_sold) AS not_sold_apartments\n" +
            "FROM house JOIN complex ON house.complexID=complex.id\n" +
            "            LEFT JOIN (SELECT houseID, COUNT(id) AS sold\n" +
            "                  FROM apartment  \n" +
            "                  WHERE statusSale = \"sold\"\n" +
            "                  GROUP BY houseID) sold_ap ON house.id=sold_ap.houseID\n" +
            "            LEFT JOIN (\n" +
            "                SELECT houseID, COUNT(id) AS not_sold\n" +
            "                FROM apartment  \n" +
            "                WHERE statusSale = \"ready\"\n" +
            "                GROUP BY houseID\n" +
            "                ) not_sold_ap ON house.id=not_sold_ap.houseID\n" +
            "ORDER BY complex.name, complex.street, house.number;";

    public static final String getComplexes = "SELECT complex.id, complex.name, complex.statusConstruction, COUNT(house.id) AS house_count, complex.city\n" +
            "FROM complex JOIN house ON complex.id=house.complexID\n" +
            "GROUP BY complex.id\n" +
            "ORDER BY complex.city, complex.statusConstruction";

    public static final String getReport = "SELECT apartment.apartmentNumber, apartment.floor, apartment.statusSale, apartment.cost, complex.name, house.number\n" +
            "FROM apartment JOIN house ON apartment.houseID=house.id JOIN complex ON house.complexID=complex.id;";
}
