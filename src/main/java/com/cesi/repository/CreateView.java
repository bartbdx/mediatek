package com.cesi.repository;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Philippe on 03/06/2017.
 */
public class CreateView {
    public void goCreate(String filename){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filename));
            Parent root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("MediateK - Ajout d'une oeuvre");
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
