package com.example.grant20.models.dataModel;
import javafx.collections.ObservableList;

import java.util.*;

public class EvaluationModel {
    ObservableList<EstimatedCost> list;

    public EvaluationModel(ObservableList<EstimatedCost> list) {
        this.list = list;
    }

    public double[] calculateFlatCost(double areaC, double roomC, double baseC) {
        double[] result = new double[3];
        double sumSold = 0;
        double sumUnsold = 0;
        for (EstimatedCost e : list) {
            double sum = areaC * e.getArea() + roomC * e.getRooms() + e.getApartmentAddedValue() + e.getHouseAddedValue() + e.getComplexAddedValue() + baseC;
            if (e.getStatusSale().equals("sold")) {
                sumSold += sum;

            } else {
                sumUnsold += sum;
            }
        }
        result[0] = sumSold;
        result[1] = sumUnsold;
        result[2] = sumSold+sumUnsold;
        return result;
    }

    public double calculateLoss() {
        //сортировка списка в формате Комплекс-Дом-Квартира
        HashSet<String> houses = new HashSet<>();
        HashSet<String> complexes = new HashSet<>();
        double sum = 0;
        for (EstimatedCost e : list) {
            System.out.println(e.getComplexName()+" "+e.getHouseNumber()+" "+e.getApartmentNumber()+" "+sum+": ");
            sum+=e.getApartmentAddedValue();
            if(!complexes.add(e.getComplexName())){
                sum+=e.getComplexBuildingCosts();
            }
            if(!houses.add(e.getHouseNumber())){
                sum+=e.getHouseBuildingCosts();
            }
        }
        return sum;
    }
}
