package classes;

/**
 * Created by Mostafa ACHRAF on 12/24/2016.
 */
public class NoteModule {
    private int idNoteMat;
    private double note;
    private String valider;
    private Eleve eleve;
    private Module module;

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public NoteModule(double note, String valider) {
        this.note = note;
        this.valider = valider;
    }

    public NoteModule(int idNoteMat, double note, String valider) {

        this.idNoteMat = idNoteMat;
        this.note = note;
        this.valider = valider;
    }

    public int getIdNoteMat() {
        return idNoteMat;
    }

    public void setIdNoteMat(int idNoteMat) {
        this.idNoteMat = idNoteMat;
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
}
