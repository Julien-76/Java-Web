package be.technifutur.servlets.utils;

import java.sql.*;

public class ConnexionPSQL {
	
	private static String DBUrl = "jdbc:postgresql://localhost/technifuturJava";
    private static String user = "postgres";
    private static String password = "123456a.";

    private static Connection instance;

    private ConnexionPSQL() {
    }

    public static Connection getInstance() throws SQLException {                           //Singleton (si nul, on le crée, sinon on renvoie celui existant)
        if (instance == null) {
            instance = DriverManager.getConnection(DBUrl, user, password);
        }
        return instance;
    }

}
