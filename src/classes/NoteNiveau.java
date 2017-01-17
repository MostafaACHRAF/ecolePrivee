package classes;

import java.util.SplittableRandom;

/**
 * Created by Mostafa ACHRAF on 12/24/2016.
 */
public class NoteNiveau {
    private int idNoteNiveau;
    private double note;
    private String reussi;
    private Eleve eleve;
    private Niveau niveau;

    public NoteNiveau(double note, String reussi, Niveau niveau, Eleve eleve) {
        this.note = note;
        this.reussi = reussi;
        this.eleve = eleve;
        this.niveau = niveau;
    }

    public NoteNiveau(int idNoteNiveau, double note, String reussi, Niveau niveau, Eleve eleve) {
        this.idNoteNiveau = idNoteNiveau;
        this.note = note;
        this.reussi = reussi;
        this.eleve = eleve;
        this.niveau = niveau;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getReussi() {
        return reussi;
    }

    public void setReussi(String reussi) {
        this.reussi = reussi;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public int getIdNoteNiveau() {

        return idNoteNiveau;
    }

    public void setIdNoteNiveau(int idNoteNiveau) {
        this.idNoteNiveau = idNoteNiveau;
    }
}
