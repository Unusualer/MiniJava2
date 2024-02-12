package com.mycompany.minijava2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Tablecreate {

    public void run() {
        String url = "jdbc:mysql://localhost:3306/bibliotheque?user=root&password=root"; // Remplacez 'root' avec votre
                                                                                         // mot de passe//

        try (Connection connection = DriverManager.getConnection(url);
                Statement statement = connection.createStatement()) {

            // Création des tables en suivant le schéma fourni
            statement.execute("CREATE TABLE IF NOT EXISTS Adherent (" +
                    "idAd INT AUTO_INCREMENT PRIMARY KEY, " +
                    "CIN VARCHAR(255) NOT NULL UNIQUE, " +
                    "nomAd VARCHAR(255) NOT NULL, " +
                    "age INT NOT NULL, " +
                    "profession VARCHAR(255) NOT NULL)");

            statement.execute("CREATE TABLE IF NOT EXISTS Departement (" +
                    "IdDep INT AUTO_INCREMENT PRIMARY KEY, " +
                    "NomDep VARCHAR(255) NOT NULL, " +
                    "categorie VARCHAR(255) NOT NULL)");

            statement.execute("CREATE TABLE IF NOT EXISTS Livre (" +
                    "idL INT AUTO_INCREMENT PRIMARY KEY, " +
                    "titre VARCHAR(255) NOT NULL, " +
                    "Auteur VARCHAR(255) NOT NULL, " +
                    "IdDep INT, " +
                    "FOREIGN KEY (IdDep) REFERENCES Departement(IdDep))");

            statement.execute("CREATE TABLE IF NOT EXISTS Gerant (" +
                    "idG INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nomG VARCHAR(255) NOT NULL, " +
                    "Sexe CHAR(1), " +
                    "Specialite VARCHAR(255) NOT NULL, " +
                    "IdDep INT, " +
                    "FOREIGN KEY (IdDep) REFERENCES Departement(IdDep))");

            statement.execute("CREATE TABLE IF NOT EXISTS Inscription (" +
                    "IdDep INT, " +
                    "IdAd INT, " +
                    "PRIMARY KEY (IdDep, IdAd), " +
                    "FOREIGN KEY (IdDep) REFERENCES Departement(IdDep), " +
                    "FOREIGN KEY (IdAd) REFERENCES Adherent(IdAd))");

            System.out.println("Tables created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
