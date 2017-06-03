package com.cesi.view;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Philippe on 03/06/2017.
 */
public class CreateController implements Initializable {

    @FXML
    private BorderPane createbp;

    @FXML
    private JFXButton livreBtn;

    @FXML
    private JFXButton musiqueBtn;

    @FXML
    private JFXButton videoBtn;

    @FXML
    private JFXButton jeuxBtn;

    @FXML
    private Pane downPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
