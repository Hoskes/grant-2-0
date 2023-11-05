package com.example.grant20.models.dataModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Apartment {
    int id;
    String houseName;
    int apartmentNumber;
    String address;
    double area;
    int rooms;
    int entrance;
    int floor;
    String statusSale;
    String complexId;
    String cost;
    String addedValue;
    String houseId;

    public Apartment(int id, String houseName, String address, double area, int rooms, int entrance, int floor, String statusSale) {
        this.id = id;
        this.houseName = houseName;
        this.address = address;
        this.area = area;
        this.rooms = rooms;
        this.entrance = entrance;
        this.floor = floor;
        this.statusSale = statusSale;

    }
    public Apartment(ResultSet resultSet) throws SQLException {
        this.id = resultSet.getInt(1);
        this.houseName = resultSet.getString(2);
        this.apartmentNumber = resultSet.getInt(3);
        this.address = resultSet.getString(4);
        this.area = resultSet.getInt(5);
        this.rooms = resultSet.getInt(6);
        this.entrance = resultSet.getInt(7);
        this.floor = resultSet.getInt(8);
        this.statusSale = resultSet.getString(9);
        this.complexId = resultSet.getString(10);
        this.cost = resultSet.getString(11);
        this.addedValue = resultSet.getString(12);
        this.houseId = resultSet.getString(13);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getCost() {
        return cost;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getAddedValue() {
        return addedValue;
    }

    public void setAddedValue(String addedValue) {
        this.addedValue = addedValue;
    }

    public String getStatusSale() {
        return statusSale;
    }

    public void setStatusSale(String statusSale) {
        this.statusSale = statusSale;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getComplexId() {
        return complexId;
    }

    public void setComplexId(String complexId) {
        this.complexId = complexId;
    }

    public String splitAddressData(int index){
        String address = this.address+"";
        String city = address.substring(address.indexOf("г.") + 3, address.indexOf("ул."));
        city = city.trim();
        // Извлечение названия улицы
        String street = address.substring(address.indexOf("ул.") + 4, address.indexOf("д."));
        street = street.trim();

        // Извлечение номера дома
        String houseNumber = address.substring(address.indexOf("д.") + 2, address.indexOf("кв."));
        houseNumber = houseNumber.trim();

        // Извлечение номера квартиры
        String flatNumber = address.substring(address.indexOf("кв.") + 3);
        flatNumber = flatNumber.trim();
        switch (index){
            case 0:
                return street;
            case 1:
                return houseNumber;
            case 2:
                return flatNumber;
            case 3:
                return city;
        }
        return null;
    }

}
