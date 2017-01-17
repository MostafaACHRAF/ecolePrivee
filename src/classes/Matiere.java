package classes;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.List;

/**
 * Created by Mostafa ACHRAF on 12/17/2016.
 */
public class Matiere {

    private int idMat;
    private String nom;
    private double seuil;
    private Module module;
    private List<NoteMatiere> listeNoteMatiere;

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<NoteMatiere> getListeNoteMatiere() {
        return listeNoteMatiere;
    }

    public void setListeNoteMatiere(List<NoteMatiere> listeNoteMatiere) {
        this.listeNoteMatiere = listeNoteMatiere;
    }

    public Matiere (String nom) {
        this.setNom(nom);
    }

    public Matiere (int idMat, String nom) {
        this.setIdMat (idMat);
        this.setNom(nom);
    }

    public Matiere (int idMat, String nom, double seuil) {
        this(idMat, nom);
        this.setSeuil(seuil);
    }

    public int getIdMat () {
        return this.idMat;
    }

    public String getNom () {
        return this.nom;
    }

    public double getSeuil () {
        return this.seuil;
    }

    public void setIdMat (int idMat) {
        this.idMat = idMat;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }

    public void setSeuil (double seuil) {
        this.seuil = seuil;
    }
}
