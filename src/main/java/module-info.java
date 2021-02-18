module com.alxelr {
    requires javafx.controls;
    requires javafx.fxml;
    requires retrofit2;
    requires com.google.gson;
    requires retrofit2.converter.gson;

    opens com.alxelr.Main to javafx.fxml;
    exports com.alxelr.Main;
    opens com.alxelr.GUI to javafx.fxml;
    exports com.alxelr.GUI;
    opens com.alxelr.Database to com.google.gson;
    exports com.alxelr.Database;
    opens com.alxelr.Model to com.google.gson;
    exports com.alxelr.Model;
}