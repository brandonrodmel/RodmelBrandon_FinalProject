module com.example.rodmelbrandon_finalproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.rodmelbrandon_finalproject to javafx.fxml;
    exports com.example.rodmelbrandon_finalproject.view;
}