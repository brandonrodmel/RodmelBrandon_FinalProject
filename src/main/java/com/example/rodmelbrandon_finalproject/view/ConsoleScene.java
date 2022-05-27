package com.example.rodmelbrandon_finalproject.view;

import com.example.rodmelbrandon_finalproject.controller.Controller;
import com.example.rodmelbrandon_finalproject.model.Console;
import com.example.rodmelbrandon_finalproject.model.Electronic;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class ConsoleScene extends Scene {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private Button homeButton = new Button("Return to Home Page");

    private ImageView ps5Image = new ImageView(new Image("ps5.png"));
    private ImageView xboxSeriesXImage = new ImageView(new Image("xboxX.png"));

    private Label ps5Label = new Label("PS5");
    private Label xboxSeriesXLabel = new Label("Xbox Series X");

    private Button addPS5Button = new Button("Add to Cart");
    private Button addXboxSeriesXButton = new Button("Add to Cart");

    private ListView<Electronic> elctronicsLV = new ListView<>();

    private Controller controller = Controller.getInstance();
    private ObservableList<Electronic> cart;
    private Electronic selectedElectronic;

    public ConsoleScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));

        pane.add(homeButton, 0, 0);
        homeButton.setOnAction(event -> changeToMainScene());

        ps5Image.setFitWidth(WIDTH/2);
        ps5Image.setFitHeight(HEIGHT/2);
        pane.add(ps5Image, 0, 1);

        xboxSeriesXImage.setFitWidth(WIDTH/2);
        xboxSeriesXImage.setFitHeight(HEIGHT/4);
        pane.add(xboxSeriesXImage, 1, 1);

        pane.add(ps5Label, 0, 2);
        pane.add(xboxSeriesXLabel, 1, 2);

        pane.add(addPS5Button, 0, 3);
        addPS5Button.setOnAction(event -> addToCart("PS5"));

        pane.add(addXboxSeriesXButton, 1, 3);
        addXboxSeriesXButton.setOnAction(event -> addToCart("Xbox"));

        cart = controller.getAllElectronics();
        elctronicsLV.setItems(cart);
        elctronicsLV.setPrefWidth(WIDTH);
        elctronicsLV.setPrefHeight(HEIGHT/4);
        pane.add(elctronicsLV, 0, 4, 3, 1);

        this.setRoot(pane);
    }

    private void addToCart(String console) {
        if(console == "PS5")
            // TODO : CHANGE TO PS5 OR SWITCH
            cart.add(new Console("Xbox Series X", 500, "12.0 teraflop AMD RDNA 2", "8-core, 3.8 GHz AMD Zen 2", 16, 1000, 1, true, "black"));
        else // XBOX
            cart.add(new Console("Xbox Series X", 500, "12.0 teraflop AMD RDNA 2", "8-core, 3.8 GHz AMD Zen 2", 16, 1000, 1, true, "black"));
    }

    private void changeToMainScene() {
        ViewNavigator.loadScene("Brandon's Electronics", new MainScene());
    }
}
