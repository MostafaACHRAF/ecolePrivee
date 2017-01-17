package GUI;

import connexion.Connexion;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mostafa ACHRAF on 12/17/2016.
 */

public class GestionNotes_Modules {
    private int idM;
    private String libelleM;
    private double moyenne;

    public GestionNotes_Modules (int idM, String libelleM) {
        this.setIdM(idM);
        this.setLibelleM(libelleM);
    }

    public GestionNotes_Modules (String libelleM, double moyenne) {
        this.libelleM = libelleM;
        this.moyenne = moyenne;
    }

    public int getIdM() {
        return this.idM;
    }

    public String getLibelleM () {
        return this.libelleM;
    }

    public void setIdM (int idM) {
        this.idM = idM;
    }

    public void setLibelleM (String libelleM) {
        this.libelleM = libelleM;
    }

    public static void getAllModules (ObservableList<GestionNotes_Modules> listeModules, int idS) {
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement(
                    "SELECT idM, libelleM FROM module WHERE idS = ?"
            );
            stm.setInt(1, idS);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listeModules.add(new GestionNotes_Modules(rs.getInt("idM"), rs.getString("libelleM")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(double moyenne) {
        this.moyenne = moyenne;
    }
}
