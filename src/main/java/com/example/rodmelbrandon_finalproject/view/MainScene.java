package com.example.rodmelbrandon_finalproject.view;

import com.example.rodmelbrandon_finalproject.controller.Controller;
import com.example.rodmelbrandon_finalproject.model.Electronic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.text.NumberFormat;

public class MainScene extends Scene {

    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;

    private ImageView welcomeImage = new ImageView(new Image("electronics.png"));
    private Label welcomeLabel = new Label("Welcome to Brandon's Electronics! How can we help?");

    private Button consoleButton = new Button("Browse consoles");
    private Button computerButton = new Button("Browse computers");

    private ListView<Electronic> elctronicsLV = new ListView<>();

    private Button removeButton = new Button("Remove from cart");
    private Button checkoutButton = new Button("Proceed to checkout");

    private Label checkoutErrLabel = new Label("Cart is empty!");
    private Label checkoutLabel = new Label("");

    private Controller controller = Controller.getInstance();
    private ObservableList<Electronic> cart;
    private Electronic selectedElectronic;

    public MainScene() {
        super(new GridPane(), WIDTH, HEIGHT);
        GridPane pane = new GridPane();
        pane.setHgap(10.0);
        pane.setVgap(5);
        pane.setPadding(new Insets(5));
        pane.setStyle("-fx-background-color: #85929E;");

        welcomeImage.setFitWidth(WIDTH-10);
        welcomeImage.setFitHeight(HEIGHT/1.5);
        pane.add(welcomeImage, 0, 0, 3, 1);

        welcomeLabel.setTextFill(Color.BLACK);
        welcomeLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 20));
        pane.add(welcomeLabel, 0, 1, 3, 1);

        pane.add(consoleButton, 0, 2);
        consoleButton.setOnAction(event -> changeToConsoleScene());
        pane.add(computerButton, 1, 2);
        computerButton.setOnAction(event -> changeToComputerScene());

        cart = controller.getAllElectronics();
        elctronicsLV.setItems(cart);
        elctronicsLV.setPrefWidth(WIDTH);
        elctronicsLV.setPrefHeight(HEIGHT/4);
        pane.add(elctronicsLV, 0, 3, 3, 1);
        elctronicsLV.getSelectionModel().selectedItemProperty().addListener((obsVal, oldVal, newVal) -> selectedElectronic(newVal));

        removeButton.setDisable(true);
        pane.add(removeButton, 0, 4);
        removeButton.setOnAction(event -> removeFromCart());
        pane.add(checkoutButton, 1, 4);
        checkoutButton.setOnAction(event -> checkout());

        checkoutErrLabel.setTextFill(Color.RED);
        checkoutErrLabel.setVisible(false);
        pane.add(checkoutErrLabel, 0, 5);
        checkoutErrLabel.setVisible(false);
        pane.add(checkoutLabel, 1, 5);

        this.setRoot(pane);

    }

    private void checkout() {
        checkoutLabel.setVisible(cart.size() != 0);
        checkoutErrLabel.setVisible(cart.size() == 0);
        if(cart.size() == 0) return;

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        double total=0.0;
        for(int i=0; i<cart.size(); i++) {
            total += cart.get(i).getPrice();
        }
        String receipt = "Your total is " + currency.format(total);
        checkoutLabel.setText(receipt);
    }

    private void selectedElectronic(Electronic newVal) {
        selectedElectronic = newVal;
        removeButton.setDisable(selectedElectronic == null);
    }

    private void removeFromCart() {
        if(selectedElectronic == null)
            return;
        cart.remove(selectedElectronic);
        updateDisplay();
    }

    private void updateDisplay() {
        FXCollections.sort(cart);
        elctronicsLV.refresh();
    }

    private void changeToConsoleScene() {
        ViewNavigator.loadScene("Brandon's Electronics - Consoles", new ConsoleScene());
    }

    private void changeToComputerScene() {
        ViewNavigator.loadScene("Brandon's Electronics - Computers", new ComputerScene());
    }
}
