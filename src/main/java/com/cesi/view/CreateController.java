package com.cesi.view;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
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
        livreBtn.setOnMouseClicked((MouseEvent event) -> {
            try {
                handleButton("/books.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        musiqueBtn.setOnMouseClicked((MouseEvent event) -> {
            try {
                handleButton("/musique.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    public void handleButton(String panes) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(panes));
        Pane fillPane = (Pane) fxmlLoader.load();
        downPane.getChildren().clear();
        downPane.getChildren().add(fillPane);
    }
}
