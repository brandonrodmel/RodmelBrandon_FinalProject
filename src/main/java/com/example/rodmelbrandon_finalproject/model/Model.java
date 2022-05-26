package com.example.rodmelbrandon_finalproject.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class Model {

    public static final File BINARY_FILE = new File("Electronics.dat");

    public static boolean binaryFileHasData() {
        return BINARY_FILE.exists() && BINARY_FILE.length() >= 1L;
    }

    public static ObservableList<Electronic> populateListFromBinaryFile() {
        ObservableList<Electronic> allElectronicsList = FXCollections.observableArrayList();

        if(binaryFileHasData()) {
            try {
                ObjectInputStream fileReader = new ObjectInputStream(new FileInputStream(BINARY_FILE));
                Electronic[] temp = (Electronic[]) fileReader.readObject();
                allElectronicsList.addAll(temp);
                fileReader.close();
            } catch(IOException | ClassNotFoundException e) {
                System.out.println("error opening binary file for reading");
            }
        }
        return allElectronicsList;
    }

    public static boolean writeDataToBinaryFile(ObservableList<Electronic> allElectronicsList) {
        try {
            ObjectOutputStream fileWriter = new ObjectOutputStream(new FileOutputStream(BINARY_FILE));
            Electronic[] temp = new Electronic[allElectronicsList.size()];
            for(int i=0; i< temp.length; i++)
                temp[i] = allElectronicsList.get(i);
            fileWriter.writeObject(temp);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
