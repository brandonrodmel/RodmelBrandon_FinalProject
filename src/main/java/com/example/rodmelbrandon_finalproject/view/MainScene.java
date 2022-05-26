package com.example.rodmelbrandon_finalproject.view;

import com.example.rodmelbrandon_finalproject.model.Electronic;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class MainScene extends Scene {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 800;

    private ImageView welcomeImage = new ImageView(new Image("welcome.png"));
    private Label welcomeLabel = new Label("Welcome to Brandon's Electronics! How may I help you?");
    private Button consoleButton = new Button("Browse Consoles");
    private Button computerButton = new Button("Browse Computers");
    private ListView<Electronic> elctronicsLV = new ListView<>();

    public MainScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setStyle("-fx-background-color: #ffffff;");
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        welcomeImage.setFitWidth(WIDTH);
        welcomeImage.setFitHeight(HEIGHT/4);
        pane.add(welcomeImage, 0, 0, 3, 1);

        welcomeLabel.setTextFill(Color.BLACK);
        pane.add(welcomeLabel, 0, 1);

        pane.add(consoleButton, 0, 2);
        pane.add(computerButton, 1, 2);

        elctronicsLV.setPrefWidth(WIDTH);
        pane.add(elctronicsLV, 0, 3, 3, 1);

        this.setRoot(pane);
        
        consoleButton.setOnAction(event -> changeToConsoleScene());
    }

    private void changeToConsoleScene() {
        ViewNavigator.loadScene("Brandon's Electronics", new ConsoleScene());
    }
}
