package com.company;

import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

/**
 * Created by Виталик on 23.05.2016.
 */
public class JDBCTest {

    private static final String DB_URL = "jdbc:mysql://localhost/db_lesson2";
    private static final String USER = "root";
    private static final String PASS = "root";

    @Test
    public void testConnection() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(conn);

        Statement statement = conn.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM ORDERS");
        while(resultSet.next()) {
            int gty = resultSet.getInt("QTY");
            System.out.println("QTY = " + gty);
        }

        resultSet.close();
        statement.close();
        conn.close();
    }

}

