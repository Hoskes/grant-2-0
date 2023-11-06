import com.example.grant20.models.DB.DBConnect;
import com.example.grant20.models.DB.Query;
import com.example.grant20.models.dataModel.EstimatedCost;
import com.example.grant20.models.dataModel.EvaluationModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.ResultSet;
import java.sql.SQLException;


public class SummsTest {

    @Test
    public void calculateSumms1() {

        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.query1);
        ObservableList<EstimatedCost> list = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                list.add(new EstimatedCost(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        double cost1 = 100;
        double cost2 = 200;
        double cost3 = 300;

        EvaluationModel ev = new EvaluationModel(list);

        double[] array = ev.calculateFlatCost(cost1, cost2, cost3);
        Assertions.assertEquals(7190669.998931885, array[0]);
    }

    @Test
    public void calculateSumms2() {

        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.query1);
        ObservableList<EstimatedCost> list = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                list.add(new EstimatedCost(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        double cost1 = 100;
        double cost2 = 200;
        double cost3 = 300;

        EvaluationModel ev = new EvaluationModel(list);

        double[] array = ev.calculateFlatCost(cost1, cost2, cost3);
        Assertions.assertEquals(1283819.9996948242, array[1]);
    }

    @Test
    public void calculateSumms3() {

        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.query1);
        ObservableList<EstimatedCost> list = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                list.add(new EstimatedCost(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        double cost1 = 100;
        double cost2 = 200;
        double cost3 = 300;

        EvaluationModel ev = new EvaluationModel(list);

        double[] array = ev.calculateFlatCost(cost1, cost2, cost3);
        Assertions.assertEquals(8474489.998626709, array[2]);
    }

    @Test
    public void calculateSumms4() {

        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.query1);
        ObservableList<EstimatedCost> list = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                list.add(new EstimatedCost(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        EvaluationModel ev = new EvaluationModel(list);
        double sum = ev.calculateLoss();
        Assertions.assertEquals(5485000.0, sum);
    }

    @Test
    public void calculateSumms5() {

        ResultSet resultSet = DBConnect.getDBConnect().executeSelect(Query.query2);
        ObservableList<EstimatedCost> list = FXCollections.observableArrayList();
        try {
            while (resultSet.next()) {
                list.add(new EstimatedCost(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        EvaluationModel ev = new EvaluationModel(list);
        double sum = ev.calculateLoss();
        Assertions.assertEquals(9830000.0, sum);
    }


}
