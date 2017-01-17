package dao;

import classes.Eleve;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoEleve extends Dao<Eleve> {

    @Override
    public Eleve ajouter(Eleve obj) {
        Eleve eleve = null;
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO eleve VALUES(null, ?, ?, ?, ?)");
            stm.setString(1, obj.getCne());
            stm.setString(2, obj.getNom());
            stm.setString(3, obj.getPrenom());
            stm.setString(4, obj.getAdresse());
            stm.executeUpdate();

            eleve = this.getByCne(obj.getCne());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eleve;
    }

    @Override
    public Eleve modifier(Eleve obj) {
        Eleve eleve = null;
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE eleve SET cne = ?, nom = ?, prenom = ?, adresse = ? WHERE idE = ?");
            stm.setString(1, obj.getCne());
            stm.setString(2, obj.getNom());
            stm.setString(3, obj.getPrenom());
            stm.setString(4, obj.getAdresse());
            stm.setInt(5, obj.getIdE());
            stm.executeUpdate();
            //if (resultat.next())
                //eleve = new Eleve(resultat.getInt("idE"), resultat.getString("cne"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("adresse"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean supprimer(int id) {
        Eleve eleve = getById(id);

        if (eleve != null) {
            try {
                PreparedStatement stm = connection.prepareStatement("DELETE FROM eleve WHERE idE = ?");
                stm.setInt(1, id);
                stm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Eleve getById(int id) {
        Eleve eleve = null;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM eleve WHERE idE = ?");
            stm.setInt(1, id);
            ResultSet resultat = stm.executeQuery();
            if (resultat.next())
                eleve = new Eleve(resultat.getInt("idE"), resultat.getString("cne"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("adresse"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eleve;
    }

    @Override
    public List<Eleve> getAll() {
        List<Eleve> listeEleves = new ArrayList<Eleve>();
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM eleve");
            ResultSet resultat = stm.executeQuery();
            while (resultat.next()) {
                listeEleves.add(new Eleve(resultat.getInt("idE"), resultat.getString("cne"), resultat.getString("nom"), resultat.getString("prenom"), resultat.getString("adresse")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeEleves;
    }

    @Override
    public boolean existe(Eleve obj) {
        boolean existe = false;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM eleve");
            ResultSet resultat = stm.executeQuery();
            while (resultat.next() && !existe) {
                if (resultat.getString("cne").equals(obj.getCne()))
                    existe = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }

    public Eleve getByCne (String cne) {
        Eleve eleve = null;
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement("SELECT * FROM eleve WHERE cne = ?");
            stm.setString(1, cne);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                eleve = new Eleve(rs.getInt("idE"), rs.getString("cne"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return eleve;
    }
}