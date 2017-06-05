package com.cesi.view;

import com.cesi.model.Oeuvre;
import com.cesi.repository.impl.OeuvreRepositoryImpl;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.util.List;

/**
 * Created by Philippe on 05/06/2017.
 */
public class UpdateObjectView extends OeuvreRepositoryImpl{

    private ObservableList<Oeuvre> objet;

    public UpdateObjectView() throws IOException {
    }

    @FXML
    public List displayObject(String table, String columnName){
        OeuvreRepositoryImpl objetRepo = null;

        try {
            objetRepo = new OeuvreRepositoryImpl();
        } catch (IOException e) {
            e.printStackTrace();
        }
        objet = objetRepo.getAll(table, columnName);
        return objet;
    }

}
