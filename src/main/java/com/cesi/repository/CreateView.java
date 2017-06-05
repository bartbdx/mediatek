package com.cesi.repository;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Philippe on 03/06/2017.
 */
public class CreateView extends InsertPopup{
    public void goCreate(String link){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(link));
            Parent root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("MediateK - Ajout d'une oeuvre");
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void goPopup(String link){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(link));
            Parent root3 = fxmlLoader.load();
            Stage stage = new Stage();
            //stage.setTitle("MediateK - Ajout d'une oeuvre");
            stage.setScene(new Scene(root3));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
