package dao;

import classes.User;
import javafx.application.Platform;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa ACHRAF on 12/7/2016.
 */
public class DaoUser extends Dao<User> {
    @Override
    public User ajouter(User obj) {
        return null;
    }

    @Override
    public User modifier(User obj) {
        return null;
    }

    @Override
    public boolean supprimer(int id) {
        return false;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> listeUsers = new ArrayList<User>();
        return null;
    }

    @Override
    public boolean existe(User obj) {
        return false;
    }

    public User seConnecter (String login, String password) {
        User user = null;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM user WHERE login = ? AND password = ?");
            stm.setString(1, login);
            stm.setString(2, password);
            ResultSet resultat = stm.executeQuery();
            if (resultat.next()) {
                user = new User(login, password);
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void seDeconnecter () {
        Platform.exit();
        System.exit(0);
    }
}
