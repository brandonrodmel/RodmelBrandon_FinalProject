package com.example.rodmelbrandon_finalproject.controller;

import com.example.rodmelbrandon_finalproject.model.Electronic;
import com.example.rodmelbrandon_finalproject.model.Model;
import javafx.collections.ObservableList;

public class Controller {

    private static Controller theInstance;
    private ObservableList<Electronic> allElectronics;

    private Controller() {}

    public static Controller getInstance() {
        if(theInstance == null) {
            theInstance = new Controller();
            theInstance.allElectronics = Model.populateListFromBinaryFile();
        }
        return theInstance;
    }

    public ObservableList<Electronic> getAllElectronics() {
        return allElectronics;
    }

    public void saveData() {
        Model.writeDataToBinaryFile(allElectronics);
    }
}
