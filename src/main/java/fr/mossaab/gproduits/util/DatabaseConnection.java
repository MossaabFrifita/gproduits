package fr.mossaab.gproduits.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private static Connection con = null;

    static
    {
        try {
            String url = "jdbc:postgresql://localhost/db_gproduits";
            Properties props = new Properties();
            props.load(DatabaseConnection.class.getClassLoader().getResourceAsStream("database.properties"));
            con = DriverManager.getConnection(url,props);
            System.out.println("Connected to the database!");
        }
        catch ( SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to make connection!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}
