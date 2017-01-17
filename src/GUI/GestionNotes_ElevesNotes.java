package GUI;

import classes.Matiere;
import connexion.Connexion;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Mostafa ACHRAF on 12/18/2016.
 */
public class GestionNotes_ElevesNotes {
    private String cne;
    private String nomEleve;
    private String prenom;
    private String note;
    private String adresse;
    private String valider;

    public GestionNotes_ElevesNotes(String cne, String nomEleve, String prenom, String adresse, String note, String valider) {
        this.cne = cne;
        this.nomEleve = nomEleve;
        this.prenom = prenom;
        this.adresse = adresse;
        this.note = note;
        this.valider = valider;
    }

    public GestionNotes_ElevesNotes(String cne, String note) {
        this.cne = cne;
        this.note = note;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public static void getAllElevesInfos (ObservableList<GestionNotes_ElevesNotes> listeElevesInfos, int idMat, int idN, int idG) {
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement(
                    ///"SELECT e.cne, e.nom, e.prenom, nn.note, nn.valider FROM eleve e, inscription i, niveau n, groupe g, affectation a, note nn, matiere mat WHERE e.idE = i.idE AND i.idN = n.idN AND i.idI = a.idI AND a.idG = g.idG AND n.idN = ? AND g.idG = ? AND e.idE = nn.idE AND mat.idMat = nn.idMat AND mat.idMat = ?"
                    "SELECT e.idE, e.cne, e.nom, e.prenom, e.adresse FROM eleve e, groupe g, niveau n, affectation a, inscription i WHERE e.idE = i.idE AND i.idN = n.idN AND n.idN = i.idN AND i.idI = a.idI AND a.idG = g.idG AND g.idG = ? AND n.idN = ?"
            );
            stm.setInt(1, idG);
            stm.setInt(2, idN);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PreparedStatement stm2 = Connexion.getInstance().getConnection().prepareStatement("SELECT nn.note, nn.valider FROM eleve e, note_matiere nn, matiere mat WHERE e.idE = nn.idE AND nn.idMat = mat.idMat AND mat.idMat = ? AND e.idE = ?");
                stm2.setInt(1, idMat);
                stm2.setInt(2, rs.getInt("idE"));
                ResultSet rs2 = stm2.executeQuery();
                if (rs2.next()) {
                    listeElevesInfos.add(new GestionNotes_ElevesNotes(rs.getString("cne"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs2.getString("note"), rs2.getString("valider")));
                }

                else {
                    listeElevesInfos.add(new GestionNotes_ElevesNotes(rs.getString("cne"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), "", ""));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void getNotesEleve (String cne, List<Matiere> listeMatieres, ObservableList<GestionNotes_notes> listeNotes, int idM, int annee_univ) {
        try {
            int idMat;
            //listeNotes.clear();
            for (int i = 0; i < listeMatieres.size(); i++) {
                //idMat = listeMatieres.get(i).getIdMat();
                PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement(
                        "SELECT mat.nom, nn.note, m.libelleM, s.libelleS FROM eleve e, matiere mat, note_matiere nn, module m, semester s WHERE e.cne = ? AND nn.idE = e.idE AND nn.idMat = mat.idMat AND mat.idMat = ? AND mat.idM = ? AND mat.idM = m.idM AND m.idS = s.idS AND s.annee_univ = ?"
                );
                stm.setString(1, cne);
                stm.setInt(2, listeMatieres.get(i).getIdMat());
                stm.setInt(3, idM);
                stm.setInt(4, 2016);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) {
                    listeNotes.add(new GestionNotes_notes(rs.getString("nom"), rs.getDouble("note"), rs.getString("libelleS"), rs.getString("libelleM")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
