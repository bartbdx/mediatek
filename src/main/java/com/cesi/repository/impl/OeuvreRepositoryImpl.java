package com.cesi.repository.impl;


import com.cesi.model.Oeuvre;
import com.cesi.model.OeuvreListing;
import com.cesi.repository.AbstractConnect;
import com.cesi.repository.Repo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Philippe on 03/06/2017.
 */
public class OeuvreRepositoryImpl implements Repo{

    Connection conn = AbstractConnect.getConnection();

    public OeuvreRepositoryImpl() throws IOException {
    }

    @Override
    public ObservableList getListing() {
        ObservableList<Oeuvre> result = FXCollections.observableArrayList();

        String queryListing = "SELECT * FROM oeuvre ORDER BY id_oeuvre DESC LIMIT 10";
        try {
            ResultSet rs = conn.prepareStatement(queryListing).executeQuery();
            while(rs.next()){
                OeuvreListing o = new OeuvreListing();
                o.setTitre(rs.getString("titre"));
                o.setNote(rs.getInt("note"));
                o.setOrigine(rs.getString("origine"));
                result.add(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return result;
    }

    @Override
    public ObservableList getAll(String tableName, String columnName) {
        return null;
    }
}
