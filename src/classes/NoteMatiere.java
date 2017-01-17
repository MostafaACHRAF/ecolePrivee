package classes;

/**
 * Created by Mostafa ACHRAF on 12/17/2016.
 */
public class NoteMatiere {
    private int idNoteMat;
    private double note;
    private String valider;
    private Eleve eleve;
    private Matiere matiere;

    public double getNote() {
        return note;
    }

    public int getAnnee_univ() {
        return annee_univ;
    }

    public void setAnnee_univ(int annee_univ) {
        this.annee_univ = annee_univ;
    }

    private int annee_univ;

    public NoteMatiere(int idNoteMat, double note, String valider, Eleve eleve, Matiere matiere) {
        this(note, valider, eleve, matiere);
        this.setIdNoteMat(idNoteMat);
    }

    public NoteMatiere(double note, String valider, Eleve eleve, Matiere matiere) {
        this.note = note;
        this.valider = valider;
        this.eleve = eleve;
        this.matiere = matiere;
    }

    public int getIdNoteMat() {
        return idNoteMat;
    }

    public String getValider () {
        return this.valider;
    }

    public Eleve getEleve () {
        return this.eleve;
    }

    public Matiere getMatiere () {
        return this.matiere;
    }

    public void setIdNoteMat (int idNoteMat) {
        this.idNoteMat = idNoteMat;
    }

    public void setValider (String valider) {
        this.valider = valider;
    }

    public void setNote (double note) {
        this.note = note;
    }

    public void setEleve (Eleve eleve) {
        this.eleve = eleve;
    }

    public void setMatiere (Matiere matiere) {
        this.matiere = matiere;
    }
}
