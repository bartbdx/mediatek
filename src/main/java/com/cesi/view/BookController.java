package com.cesi.view;

import com.cesi.model.Oeuvre;
import com.cesi.repository.CreateView;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.StringConverter;


import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Philippe on 05/06/2017.
 */
public class BookController extends CreateView implements Initializable{

    @FXML
    private TextField titreTf;

    @FXML
    private Slider sliderNote;

    @FXML
    private TextArea commentArea;

    @FXML
    private Button saveCloseBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Button btnGenreAjout;

    @FXML
    private ComboBox<?> genreCb;

    @FXML
    private ComboBox<Oeuvre> auteurCb;

    @FXML
    private Button btnAuteurAjout;

    @FXML
    private Slider sliderAchevmnt;

    @FXML
    private ComboBox<?> supportCb;

    @FXML
    private Button btnSupportAjout;

    @FXML
    private TextField origineTf;

    private void displayAuthor(String auteur, String nom_auteur){
        UpdateObjectView authorView = null;
        authorView.displayObject(auteur, nom_auteur);
        auteurCb.setItems((ObservableList<Oeuvre>) authorView);
        auteurCb.setConverter(new StringConverter<Oeuvre>() {
            @Override
            public String toString(Oeuvre object) {
                return null;
            }

            @Override
            public Oeuvre fromString(String string) {
                return null;
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnGenreAjout.setOnAction(event -> goPopup("/ajout.fxml"));
        btnAuteurAjout.setOnAction(event -> goPopup("/ajout.fxml"));
        btnSupportAjout.setOnAction(event -> goPopup("/ajout.fxml"));

    }
}
