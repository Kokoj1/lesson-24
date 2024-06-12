module com.example.uloha_2d_grafika {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.uloha_2d_grafika to javafx.fxml;
    exports com.example.uloha_2d_grafika;
}