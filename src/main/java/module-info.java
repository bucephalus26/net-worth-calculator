module com.networthcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.networthcalculator to javafx.fxml;
    exports com.networthcalculator;
}