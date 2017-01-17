package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    private Connection connection;
    private static Connexion connexion = null;

    private Connexion() {
        System.out.println("nouvelle connexion à la base de donnée");
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur dans le driver jdbc !");
        }
        String url = "jdbc:mysql://localhost/gestionecolepriveejava?useSSL=false";
        try {
            connection = DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
            System.out.println("erreur de connexion à la base de données !");
        }

    }

    public static Connexion getInstance() {
        if (connexion == null)
            connexion = new Connexion();
        return connexion;
    }

    public Connection getConnection() {
        return this.connection;
    }
}


