package GUI;

import connexion.Connexion;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mostafa ACHRAF on 12/17/2016.
 */
public class GestionNotes_Groupes {

    private int idG;
    private String libelleG;

    public GestionNotes_Groupes (int idG, String libelleG) {
        this.setIdG(idG);
        this.setLibelleG(libelleG);
    }

    public int getIdG () {
        return this.idG;
    }

    public String getLibelleG () {
        return this.libelleG;
    }

    public void setIdG (int idG) {
        this.idG = idG;
    }

    public void setLibelleG (String libelleG) {
        this.libelleG = libelleG;
    }

    public static void getAllGroupes (ObservableList<GestionNotes_Groupes> listeGroupes, int idN) {
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement(
                    "SELECT DISTINCT g.idG, g.libelleG FROM niveau n, inscription i, affectation a, groupe g WHERE n.idN = i.idN and i.idI = a.idI AND a.idG = g.idG AND n.idN = ?"
            );
            stm.setInt(1, idN);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listeGroupes.add(new GestionNotes_Groupes(rs.getInt("idG"), rs.getString("libelleG")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
