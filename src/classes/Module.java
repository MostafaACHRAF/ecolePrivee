package classes;

import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by Mostafa ACHRAF on 12/17/2016.
 */
public class Module {

    private int idM;
    private String libelleM;
    private List<Matiere> listeMatieres;
    private List<NoteModule> listeNotesModules;
    private Niveau niveau;
    private Semester semester;

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Module (String libelleM) {
        this.setLibelleM(libelleM);
    }

    public void setListeMatieres(List<Matiere> listeMatieres) {
        this.listeMatieres = listeMatieres;
    }

    public List<NoteModule> getListeNotesModules() {
        return listeNotesModules;
    }

    public void setListeNotesModules(List<NoteModule> listeNotesModules) {
        this.listeNotesModules = listeNotesModules;
    }

    public Module (int idM, String libelleM) {

        this.setIdM(idM);
        this.setLibelleM(libelleM);
    }

    public int getIdM () {
        return this.idM;
    }

    public String getLibelleM () {
        return this.libelleM;
    }

    public List<Matiere> getListeMatieres () {
        return this.listeMatieres;
    }

    public void setIdM (int idM) {
        this.idM = idM;
    }

    public void setLibelleM (String libelleM) {
        this.libelleM = libelleM;
    }

    public void setValidee (String validee) {
        this.setValidee(validee);
    }

    public void setListeMatieres (Matiere matiere) {
        this.listeMatieres.add(matiere);
    }
}
