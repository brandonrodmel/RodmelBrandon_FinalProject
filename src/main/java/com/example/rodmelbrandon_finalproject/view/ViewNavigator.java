package com.example.rodmelbrandon_finalproject.view;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ViewNavigator {

    private static Stage mainStage;

    public static void setStage(Stage stage) {
        mainStage = stage;
        // TODO: ADD ICON
        //mainStage.getIcons().add(new Image(""));
    }

    public static void loadScene(String title, Scene scene) {
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }
}
