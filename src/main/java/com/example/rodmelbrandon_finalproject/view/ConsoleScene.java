package com.example.rodmelbrandon_finalproject.view;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ConsoleScene extends Scene {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 800;

    private Button homeButton = new Button("Return to Home Page");

    public ConsoleScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: #ffffff;");
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(homeButton, 0, 0);

        homeButton.setOnAction(event -> changeToMainScene());

        this.setRoot(pane);
    }

    private void changeToMainScene() {
        ViewNavigator.loadScene("Brandon's Electronics", new MainScene());
    }
}
