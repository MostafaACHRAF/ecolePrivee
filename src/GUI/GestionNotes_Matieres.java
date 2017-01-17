package GUI;

import connexion.Connexion;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mostafa ACHRAF on 12/17/2016.
 */
public class GestionNotes_Matieres {

    private int idMat;
    private String nom;
    private double seuil;

    public GestionNotes_Matieres (String nom, double seuil) {
        this.setNom(nom);
        this.seuil = seuil;
    }

    public GestionNotes_Matieres (int idMat, String nom, double seuil) {
        this(nom, seuil);
        this.setIdMat(idMat);
    }

    public int getIdMat () {
        return this.idMat;
    }

    public String getNom () {
        return this.nom;
    }

    public void setIdMat (int idMat) {
        this.idMat = idMat;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }

    public double getSeuil() {
        return seuil;
    }

    public void setSeuil(double seuil) {
        this.seuil = seuil;
    }

    public static void getAllMatieres (ObservableList<GestionNotes_Matieres> listeMatieres, int idM) {
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement("SELECT * FROM matiere WHERE idM = ?");
            stm.setInt(1, idM);
            ResultSet rs = stm.executeQuery();
            while (rs.next())
                listeMatieres.add(new GestionNotes_Matieres(rs.getInt("idMat"), rs.getString("nom"), rs.getDouble("seuil")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
