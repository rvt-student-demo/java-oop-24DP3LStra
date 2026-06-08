package rvt; // Obligāti!
import java.sql.*;

public class DatabaseConnection {
    public static Connection connect() throws SQLException {
        // Iegūstam projekta saknes mapi (tur, kur ir pom.xml)
        String rootPath = System.getProperty("user.dir");
        // Izveidojam pilnu ceļu līdz datubāzes failam
        String url = "jdbc:sqlite:" + rootPath + "/veikals.db";
        
        return DriverManager.getConnection(url);
    }
}