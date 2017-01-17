package GUI;

import connexion.Connexion;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mostafa ACHRAF on 12/21/2016.
 */
public class GestionNotes_Semester {
    private int idS;
    private String semester;

    public GestionNotes_Semester(String libelleS) {
        this.semester = libelleS;
    }

    public GestionNotes_Semester(int idS, String libelleS) {
        this.idS = idS;
        semester = libelleS;
    }

    public String getSemester() {
        return semester;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public static void getAllSemester (ObservableList<GestionNotes_Semester> listeSemesters, int annee_univ, int idN) {
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement("SELECT idS, libelleS FROM semester WHERE annee_univ = ? AND idN = ?");
            stm.setInt(1, annee_univ);
            stm.setInt(2, idN);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listeSemesters.add(new GestionNotes_Semester(rs.getInt("idS"), rs.getString("libelleS")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
