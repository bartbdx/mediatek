package com.cesi.view;

import com.cesi.repository.CreateView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Philippe on 05/06/2017.
 */


public class PopupAdd extends CreateView implements Initializable{


    
    @FXML
    private TextField createTf;

    @FXML
    private Button saveBtn;




    @FXML
    public void sceneClose(){
        Stage stage = (Stage) saveBtn.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
