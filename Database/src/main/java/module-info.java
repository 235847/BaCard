module com.example.database {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.database to javafx.fxml;
    exports com.example.database;
}