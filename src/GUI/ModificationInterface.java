package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Mostafa ACHRAF on 1/1/2017.
 */
public class ModificationInterface {

    private int idE;
    private String cne;
    private String nom;
    private String prenom;
    private String adresse;
    static ObservableList<ModificationInterface> listeInfos = FXCollections.observableArrayList();

    public ModificationInterface(int idE, String cne, String nom, String prenom, String adresse) {
        this.idE = idE;
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getIdE() {
        return idE;
    }

    public void setIdE(int idE) {
        this.idE = idE;
    }
}
