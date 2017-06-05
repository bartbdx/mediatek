package com.cesi.repository;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Philippe on 05/06/2017.
 */
public class InsertPopup {
    
    public void AddPopup(String table, String column, String value) throws SQLException {
        Connection conn = null;
        try {
            conn = AbstractConnect.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String query = "INSERT INTO ? (?) VALUES (?)";
        PreparedStatement p = conn.prepareStatement(query);
        p.setString(1,table);
        p.setString(2, column);
        p.setString(3, value);
        p.execute();
        p.close();

        
    }

}
