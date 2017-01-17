package dao;

import classes.Niveau;
import connexion.Connexion;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoNiveau extends Dao<Niveau> {

    @Override
    public Niveau ajouter(Niveau obj) {
        Niveau niveau = null;
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO niveau VALUES(null, ?)");
            stm.setString(1, obj.getLibelle());
            ResultSet resultat = stm.executeQuery();
            if (resultat.next())
                niveau = new Niveau(resultat.getInt("idN"), resultat.getString("libelleN"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return niveau;
    }

    @Override
    public Niveau modifier(Niveau obj) {
        Niveau niveau = null;
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE niveau SET libelle = ? WHERE idN = ?");
            stm.setString(1, obj.getLibelle());
            stm.setInt(2, obj.getIdN());
            ResultSet resultat = stm.executeQuery();
            if (resultat.next())
                niveau = new Niveau(resultat.getInt("idN"), resultat.getString("libelleN"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return niveau;
    }

    @Override
    public boolean supprimer(int id) {
        try {
            PreparedStatement stm = connection.prepareStatement("DELETE niveau WHERE idN = ?");
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (this.getById(id) == null);
    }

    @Override
    public Niveau getById(int id) {
        Niveau niveau = null;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM niveau WHERE idN = ?");
            stm.setInt(1, id);
            ResultSet resultat = stm.executeQuery();
            if (resultat.next())
                niveau = new Niveau(resultat.getInt("idN"), resultat.getString("libelleN"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return niveau;
    }

    @Override
    public List<Niveau> getAll() {
        List<Niveau> listeNiveaux = new ArrayList<Niveau>();
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM niveau");
            ResultSet resultat = stm.executeQuery();
            while (resultat.next()) {
                listeNiveaux.add(new Niveau(resultat.getInt("idN"), resultat.getString("libelleN")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeNiveaux;
    }

    @Override
    public boolean existe(Niveau obj) {
        return false;
    }

    public Niveau getByLibelle (String libelleN) {
        Niveau niveau = null;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM niveau WHERE libelleN = ?");
            stm.setString(1, libelleN);
            ResultSet resultat = stm.executeQuery();
            while (resultat.next()) {
                niveau = new Niveau(resultat.getInt("idN"), resultat.getString("libelleN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return niveau;
    }

    public static void getAllNiveaux (ObservableList<String> listeAllNiveaux) {
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement("SELECT * FROM niveau");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listeAllNiveaux.add(rs.getString("libelleN"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getAllNiveauxClasses (ObservableList<Niveau> listeAllNiveaux) {
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement("SELECT * FROM niveau");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listeAllNiveaux.add(new Niveau(rs.getInt("idN"), rs.getString("libelleN")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
