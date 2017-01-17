package GUI;

import connexion.Connexion;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mostafa ACHRAF on 12/17/2016.
 */
public class GestionNotes_Niveaux {
    private int idN;
    private String libelleN;

    public GestionNotes_Niveaux(int idN, String libelleN) {
        this.setIdN(idN);
        this.setLibelleN(libelleN);
    }

    public String getLibelleN () {
        return this.libelleN;
    }

    public int getIdN () {
        return this.idN;
    }

    public void setLibelleN (String libelleN) {
        this.libelleN = libelleN;
    }

    public void setIdN (int idN) {
        this.idN = idN;
    }

    public static void getAllNiveaux (ObservableList<GestionNotes_Niveaux> listeNiveaux) {
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement("SELECT * FROM niveau");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listeNiveaux.add(new GestionNotes_Niveaux(rs.getInt("idN"), rs.getString("libelleN")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
