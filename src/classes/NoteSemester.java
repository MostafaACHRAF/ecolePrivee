package classes;

/**
 * Created by Mostafa ACHRAF on 12/24/2016.
 */
public class NoteSemester {
    private int idNoteS;
    private double note;
    private String valider;
    private int annee_univ;
    private Eleve eleve;
    private Semester semester;

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Eleve getEleve() {

        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public NoteSemester(int idNoteS, double note, String valider, int annee_univ) {
        this.idNoteS = idNoteS;
        this.note = note;
        this.valider = valider;
        this.annee_univ = annee_univ;
    }

    public NoteSemester(double note, String valider, int annee_univ) {
        this.note = note;
        this.valider = valider;
        this.annee_univ = annee_univ;
    }

    public int getIdNoteS() {
        return idNoteS;
    }

    public void setIdNoteS(int idNoteS) {
        this.idNoteS = idNoteS;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getValider() {
        return valider;
    }

    public void setValider(String valider) {
        this.valider = valider;
    }

    public int getAnnee_univ() {
        return annee_univ;
    }

    public void setAnnee_univ(int annee_univ) {
        this.annee_univ = annee_univ;
    }
}
