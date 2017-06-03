package com.cesi.view;

import com.cesi.model.Oeuvre;
import com.cesi.repository.Repo;
import com.cesi.repository.impl.OeuvreRepositoryImpl;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends com.cesi.repository.CreateView implements Initializable {
    @FXML
    private AnchorPane anchorPaneLeft;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private TableView<Oeuvre> tablelisting;

    @FXML
    private TableColumn<?, ?> titreCol;

    @FXML
    private TableColumn<?, ?> noteCol;

    @FXML
    private TableColumn<?, ?> origineCol;

    private Repo repository;

    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<Oeuvre> items;
        titreCol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        origineCol.setCellValueFactory(new PropertyValueFactory<>("origine"));
        try {
            repository = new OeuvreRepositoryImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
        items = repository.getListing();
        tablelisting.setItems(items);
        try {
            drawerContentAction();
            hamburgerMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hamburgerMenu() {
        HamburgerBackArrowBasicTransition burgerTask = new HamburgerBackArrowBasicTransition(hamburger);
        burgerTask.setRate(-1);
        hamburger.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) ->{
            burgerTask.setRate(burgerTask.getRate() * -1);
            burgerTask.play();

            if(drawer.isShown()) drawer.close(); else drawer.open();

        });
    }

    private void drawerContentAction() throws IOException {
        VBox box = FXMLLoader.load(getClass().getResource("/DrawerleftContent.fxml"));
        drawer.setSidePane(box);

        for (Node node : box.getChildren()){
            if (node.getAccessibleText() != null){
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) ->{
                    switch (node.getAccessibleText()){
                        case "drawB_one" :
                            goCreate("/Create.fxml");
                            break;
                        case "drawB_two" :
                            break;
                        case "drawB_exit" :
                            System.exit(0);
                    }
                });
            }
        }
    }

}
