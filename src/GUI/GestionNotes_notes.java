package GUI;

/**
 * Created by Mostafa ACHRAF on 12/22/2016.
 */
public class GestionNotes_notes {
    private String matiere;
    private double note;
    private String semester;
    private String module;

    public GestionNotes_notes(String matiere, double note, String semester, String module) {
        this.matiere = matiere;
        this.note = note;
        this.semester = semester;
        this.module = module;
    }

    public GestionNotes_notes (String matiere, double note) {
        this.matiere = matiere;
        this.note = note;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getSemester () {
        return this.semester;
    }

    public void setSemester (String semester) {
        this.semester = semester;
    }

    public String getModule () {
        return this.module;
    }

    public void setModule (String module) {
        this.module =module;
    }
}
