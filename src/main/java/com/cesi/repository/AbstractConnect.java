package com.cesi.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Philippe on 03/06/2017.
 */
public abstract class AbstractConnect {

    private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver" ;
    static Connection conn;
    InputStream iS;
    private Properties prop;
    private String propFilename;

    public AbstractConnect() {
        try {
            Class.forName(COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() throws IOException {
        String host = null;
        String dbname = null;
        String user = null;
        String passwd = null;
        try {
            prop = new Properties();
            propFilename = "config.properties";
            iS = getClass().getResourceAsStream(propFilename);
            if (iS != null) {
                try {
                    prop.load(iS);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            host = prop.getProperty("host");
            dbname = prop.getProperty("dbname");
            user = prop.getProperty("user");
            passwd = prop.getProperty("passwd");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            iS.close();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbname, user, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}
