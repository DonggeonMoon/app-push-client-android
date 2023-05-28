module com.mdg.cryptoconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mdg.cryptoconverter to javafx.fxml;
    exports com.mdg.cryptoconverter;
}