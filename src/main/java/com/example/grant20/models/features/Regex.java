package com.example.grant20.models.features;

import javafx.scene.control.TextField;

import java.util.Scanner;

public class Regex {
    private static final String checkName = "[[A-Z][a-z]+|[А-Я][а-я]+]{2,50}";
    public static final String checkPositiveNumbers = "0|([1-9]+[0-9]*)";
    public static final String checkPhone ="^\\+7\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$";
    private static final String checkLog = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String checkPsw = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
    public static boolean checkName(String checkable, String mode){
        if(checkable.matches(mode)){
            return true;
        }
        return false;
    }

    public static String getCheckName() {
        return checkName;
    }
    public static String getCheckLog() {
        return checkLog;
    }
    public static String getCheckPsw() {
        return checkPsw;
    }
    public static void addListenerFormatter(TextField t, String regex) {  //цветовая реакция на заполнение полей
        t.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.matches(regex)) {
                t.setStyle("-fx-text-fill: black; ");
            } else {
                t.setStyle("-fx-text-fill: red; ");
            }
        });
    }
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        while (true){
            System.out.println(t.nextLine().matches("(\\d+.\\d+)?"));
        }
    }
}
