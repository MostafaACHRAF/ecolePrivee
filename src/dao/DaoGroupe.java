package dao;

import classes.Groupe;
import classes.Niveau;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoGroupe extends Dao<Groupe> {

    @Override
    public Groupe ajouter(Groupe obj) {
        Groupe groupe = null;
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO groupe VALUES(null, ?)");
            stm.setString(1, obj.getLibelle());
            stm.executeUpdate();
            groupe = new DaoGroupe().getByLibelle(obj.getLibelle());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }

    @Override
    public Groupe modifier(Groupe obj) {
        Groupe groupe = null;
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE groupe SET libelleG = ? WHERE idG = ?");
            stm.setString(1, obj.getLibelle());
            stm.setInt(2, obj.getIdG());
            ResultSet resultat = stm.executeQuery();
            if (resultat.next())
                groupe = new Groupe(resultat.getInt("idG"), resultat.getString("libelle"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }

    @Override
    public boolean supprimer(int id) {
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("DELETE groupe WHERE idG = ?");
            stm.setInt(1, id);
            stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (this.getById(id) == null);
    }

    @Override
    public Groupe getById(int id) {
        Groupe groupe = null;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM groupe WHERE idG = ?");
            stm.setInt(1, id);
            ResultSet resultat = stm.executeQuery();
            if (resultat.next())
                groupe = new Groupe(resultat.getInt("idG"), resultat.getString("libelleG"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return groupe;
    }

    @Override
    public List<Groupe> getAll() {
        List<Groupe> listeGroupes = new ArrayList<Groupe>();
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM groupe");
            ResultSet resultat = stm.executeQuery();
            while (resultat.next()) {
                listeGroupes.add(new Groupe(resultat.getInt("idG"), resultat.getString("libelleG")));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listeGroupes;
    }
/********************j'ai arrêter ici***************/
    @Override
    public boolean existe(Groupe obj) {
        boolean existe = false;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM groupe");
            ResultSet resultat = stm.executeQuery();
            while (resultat.next() && !existe) {
                if (resultat.getString("libelleG").equals(obj.getLibelle()))
                    existe = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public int getNbrEleves (Groupe groupe) {
        int nbrEleves = 0;
        try {
            PreparedStatement stm = connection.prepareStatement(
                    "SELECT COUNT( DISTINCT i.idI) AS nbrEleves FROM eleve e, inscription i, groupe g, affectation a WHERE a.idI = i.idI AND a.idG = g.idG AND e.idE = i.idE AND g.idG = ?"
            );
            stm.setInt(1, groupe.getIdG());
            ResultSet rs = stm.executeQuery();
            if (rs.next())
                nbrEleves = rs.getInt("nbrEleves");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nbrEleves;
    }

    public Groupe getByLibelle (String libelle) throws SQLException {
        Groupe groupe = null;
        PreparedStatement stm = connection.prepareStatement("SELECT * FROM groupe WHERE libelleG = ?");
        stm.setString(1, libelle);
        ResultSet rs = stm.executeQuery();
        if (rs.next())
            groupe = new Groupe(rs.getInt("idG"), rs.getString("libelleG"));
       return groupe;
    }

    public ObservableList<String> getByNiveau (String niveau) {
        Niveau niv = new DaoNiveau().getByLibelle(niveau);
        ObservableList<String> listeGroupesOfNiveau = FXCollections.observableArrayList();

        try {
            PreparedStatement stm = connection.prepareStatement(
                    "select DISTINCT g.libelleG from niveau n, groupe g, inscription i, affectation a  WHERE  n.idN = ? AND n.idN = i.idN AND i.idI = a.idI AND a.idG = g.idG;"
            );
            stm.setInt(1, niv.getIdN());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listeGroupesOfNiveau.add(rs.getString("libelleG"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listeGroupesOfNiveau;
    }
}
