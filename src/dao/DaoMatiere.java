package dao;

import classes.Matiere;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mostafa ACHRAF on 12/24/2016.
 */
public class DaoMatiere extends Dao<Matiere> {
    @Override
    public Matiere ajouter(Matiere obj) {
        return null;
    }

    @Override
    public Matiere modifier(Matiere obj) {
        return null;
    }

    @Override
    public boolean supprimer(int id) {
        return false;
    }

    @Override
    public Matiere getById(int id) {
        return null;
    }

    @Override
    public List<Matiere> getAll() {
        return null;
    }

    @Override
    public boolean existe(Matiere obj) {
        return false;
    }

    public void getByIdModule (int idM, List<Matiere> listeMatieresOfModule) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM  matiere WHERE idM = ?");
            stm.setInt(1, idM);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
                listeMatieresOfModule.add(new Matiere(rs.getInt("idMat"), rs.getString("nom"), rs.getDouble("seuil")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
