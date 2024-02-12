/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.minijava2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author elamr
 */
public class MiniJava2 {
    public static void main(String[] args) {
        // connectiontoDB
        String url = "jdbc:mysql://127.0.0.1/testJava";
        String user = "root";
        String password = "";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }
        // toString
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }
        // setResultSelect
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("SELECT * FROM LIVRE");
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            while (resultSet.next()) {
                // Traitmeent de chaque ligne du resultat
                String valCol = resultSet.getString("idLivre");
                System.out.println(valCol);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }
        // setResultSalact
        ResultSet resultAll = null;
        try {
            resultAll = statement.executeQuery("SELECT * FROM LIVRE");
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (resultAll.next()) {
                String id = resultAll.getString("idLivre");
                String title = resultAll.getString("titreLivre");
                String auteur = resultAll.getString("auteur");
                System.err.println(id + title + auteur);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }

        // INSERT
        String insertQuery = "INSERT INTO LIVRE (titreLivre, auteur) VALUES ('Harry Potter', 'J.K. Rowling')";
        int rowsInserted = 0;
        try {
            rowsInserted = statement.executeUpdate(insertQuery);
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(rowsInserted + " row(s) inserted.");

        // UPDATE
        String updateQuery = "UPDATE LIVRE SET titreLivre = 'New Title' WHERE idLivre = 1";
        int rowsUpdated = 0;
        try {
            rowsUpdated = statement.executeUpdate(updateQuery);
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(rowsUpdated + " row(s) updated.");

        // DELETE
        String deleteQuery = "DELETE FROM LIVRE WHERE idLivre = 2";
        int rowsDeleted = 0;
        try {
            rowsDeleted = statement.executeUpdate(deleteQuery);
        } catch (SQLException ex) {
            Logger.getLogger(MiniJava2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(rowsDeleted + " row(s) deleted.");

        Set<Livre> setLivres = new HashSet<>();

        // Assuming you have a constructor in Livre class
        Livre livre1 = new Livre(1, "Book 1", "Author 1");
        Livre livre2 = new Livre(2, "Book 2", "Author 2");

        setLivres.add(livre1);
        setLivres.add(livre2);

    }
}
