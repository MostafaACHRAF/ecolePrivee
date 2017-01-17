package dao;

import classes.Module;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mostafa ACHRAF on 12/24/2016.
 */
public class DaoModule extends Dao<Module> {
    @Override
    public Module ajouter(Module obj) {
        return null;
    }

    @Override
    public Module modifier(Module obj) {
        return null;
    }

    @Override
    public boolean supprimer(int id) {
        return false;
    }

    @Override
    public Module getById(int id) {
        return null;
    }

    @Override
    public List<Module> getAll() {
        return null;
    }

    @Override
    public boolean existe(Module obj) {
        return false;
    }

    public void getByIdNiveau (int idN, List<Module> listeMoudlesOfNiveau) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM module WHERE idN = ?");
            stm.setInt(1, idN);
            ResultSet modules = stm.executeQuery();
            while (modules.next())
                listeMoudlesOfNiveau.add(new Module(modules.getInt("idM"), modules.getString("libelleM")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getBySemester (int semester, List<Module> listeModulesOfSemester) {
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM module WHERE idS = ?");
            stm.setInt(1, semester);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
                listeModulesOfSemester.add(new Module(rs.getInt("idM"), rs.getString("libelleM")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
