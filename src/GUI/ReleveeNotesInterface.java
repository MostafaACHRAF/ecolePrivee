package GUI;

/**
 * Created by Mostafa ACHRAF on 12/23/2016.
 */
public class ReleveeNotesInterface {

    private String semester;
    private String module;
    private String matiere;
    private String note;
    private String moyenne;
    private String moyenneGenearle;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public ReleveeNotesInterface(String semester, String module, String matiere, String note, String moyenne, String moyenneGenearle) {
        this.semester = semester;
        this.module = module;
        this.matiere = matiere;
        this.note = note;
        this.moyenne = moyenne;
        this.moyenneGenearle = moyenneGenearle;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(String moyenne) {
        this.moyenne = moyenne;
    }

    public String getMoyenneGenearle() {
        return moyenneGenearle;
    }

    public void setMoyenneGenearle(String moyenneGenearle) {
        this.moyenneGenearle = moyenneGenearle;
    }
}
