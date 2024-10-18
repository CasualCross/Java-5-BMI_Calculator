module main.bmicalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.bmicalculator to javafx.fxml;
    exports main.bmicalculator;
}