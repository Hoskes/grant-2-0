module com.example.grant20 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.grant20 to javafx.fxml;
    exports com.example.grant20;
}