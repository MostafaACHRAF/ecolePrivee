package classes;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa ACHRAF on 12/24/2016.
 */
public class Semester {
    private int idS;
    private String libelleS;
    private int annee_univ;
    private List<Module> listeModules = new ArrayList<Module>();
    private Niveau niveau;

    public List<NoteSemester> getListeNotesSemester() {
        return listeNotesSemester;
    }

    public void setListeNotesSemester(List<NoteSemester> listeNotesSemester) {
        this.listeNotesSemester = listeNotesSemester;
    }

    private List<NoteSemester> listeNotesSemester = new ArrayList<>();

    public List<Module> getListeSemester() {
        return listeModules;
    }

    public List<Module> getListeModules() {
        return listeModules;
    }

    public void setListeModules(List<Module> listeModules) {
        this.listeModules = listeModules;
    }

    public Semester(int idS, String libelleS, int annee_univ) {
        this.idS = idS;
        this.libelleS = libelleS;
        this.annee_univ = annee_univ;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public String getLibelleS() {
        return libelleS;
    }

    public void setLibelleS(String libelleS) {
        this.libelleS = libelleS;
    }

    public int getAnnee_univ () {
        return annee_univ;
    }

    public void setAnnee_univ (int annee_univ) {
        this.annee_univ = annee_univ;
    }
}
