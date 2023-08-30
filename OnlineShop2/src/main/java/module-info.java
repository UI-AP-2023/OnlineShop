module com.example.onlineshop2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.onlineshop2 to javafx.fxml;
    exports com.example.onlineshop2;
}