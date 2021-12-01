module com.example.getmore {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.getmore to javafx.fxml;
    exports com.example.getmore;
}