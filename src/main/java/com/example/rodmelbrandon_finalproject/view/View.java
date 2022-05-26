package com.example.rodmelbrandon_finalproject.view;

import com.example.rodmelbrandon_finalproject.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ViewNavigator.setStage(stage);
        ViewNavigator.loadScene("Brandon's Electronics", new MainScene());
    }

    @Override
    public void stop() throws Exception {
        Controller.getInstance().saveData();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
