module com.example.grant20 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.grant20 to javafx.fxml;
    exports com.example.grant20;
    exports com.example.grant20.models;
    opens com.example.grant20.models to javafx.fxml;
    exports com.example.grant20.controllers;
    opens com.example.grant20.controllers to javafx.fxml;
    exports com.example.grant20.controllers.apartments;
    opens com.example.grant20.controllers.apartments to javafx.fxml;
    exports com.example.grant20.controllers.profile;
    opens com.example.grant20.controllers.profile to javafx.fxml;
    exports com.example.grant20.controllers.complexes;
    opens com.example.grant20.controllers.complexes to javafx.fxml;
    exports com.example.grant20.controllers.houses;
    opens com.example.grant20.controllers.houses to javafx.fxml;
    exports com.example.grant20.controllers.reports;
    opens com.example.grant20.controllers.reports to javafx.fxml;
    exports com.example.grant20.models.dataModel;
    opens com.example.grant20.models.dataModel to javafx.fxml;
    exports com.example.grant20.models.features;
    opens com.example.grant20.models.features to javafx.fxml;
    exports com.example.grant20.models.DB;
    opens com.example.grant20.models.DB to javafx.fxml;
    exports com.example.grant20.controllers.admin;
    opens com.example.grant20.controllers.admin to javafx.fxml;
}