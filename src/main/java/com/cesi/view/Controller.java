package com.cesi.view;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private AnchorPane anchorPaneLeft;

    @FXML
    private JFXHamburger hamburger;

    @FXML
    private JFXDrawer drawer;

    @FXML
    private TableView<?> tablelisting;

    @FXML
    private TableColumn<?, ?> titreCol;

    @FXML
    private TableColumn<?, ?> noteCol;

    @FXML
    private TableColumn<?, ?> origineCol;

    public void initialize(URL location, ResourceBundle resources) {
        try {
            drawerContentAction();
        } catch (IOException e) {
            e.printStackTrace();
        }
        hamburgerMenu();
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
                            goCreate();
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

    public void goCreate(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Create.fxml"));
            Parent root2 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("JAMM - Ajout d'une oeuvre");
            stage.setScene(new Scene(root2));
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
