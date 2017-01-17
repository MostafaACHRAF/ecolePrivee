package classes;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.ArrayList;
import java.util.List;

public class Niveau {

    //Attributs :
    private int idN;
    private String libelleN;
    private List<Module> listeModules;
    private List<Inscription> listeInscriptionN = new ArrayList<Inscription>();
    private List<Semester> listeSemesters = new ArrayList<Semester>();
    private List<NoteNiveau> listeNotesNiveau = new ArrayList<>();
    private Semester semester1;
    private Semester semester2;
    /*examen*/
    private List<Paiement> listePaiements = new ArrayList<>();
    private List<Montant> listeMontants = new ArrayList<>();
    /*examen*/

    //Constructeurs :
    public Niveau (String libelleN) {
        this.setLibelle(libelleN);
    }

    public Niveau (String libelleN, Inscription insc) {
        this(libelleN);
        this.setListeInscriptionN(insc);
    }

    public Niveau (int idN, String libelleN) {
        this(libelleN);
        this.setIdN(idN);
    }

    public Niveau (int idN, String libelleN, Inscription insc) {
        this(libelleN, insc);
        this.setIdN(idN);
    }

    //Getters :
    public int getIdN() {
        return this.idN;
    }

    public String getLibelle() {
        return this.libelleN;
    }

    public List<Inscription> getListeInscriptionN() {
        return this.listeInscriptionN;
    }

    public List<Module> getListeModules () {
        return this.listeModules;
    }

    //Setters :
    public void setIdN(int idN) {
        this.idN = idN;
    }

    public void setLibelle(String libelle) {
        this.libelleN = libelle;
    }

    public void setListeInscriptionN(Inscription insc) {
        this.listeInscriptionN.add(insc);
    }

    public void setListeModules (Module module) {
        this.listeModules.add(module);
    }

    public int getNbrEleves () {
        return this.listeInscriptionN.size();
    }

    public List<Semester> getListeSemesters() {
        return listeSemesters;
    }

    public void setListeSemesters(List<Semester> listeSemesters) {
        this.listeSemesters = listeSemesters;
    }

    public String getLibelleN() {
        return libelleN;
    }

    public void setLibelleN(String libelleN) {
        this.libelleN = libelleN;
    }

    public void setListeModules(List<Module> listeModules) {
        this.listeModules = listeModules;
    }

    public void setListeInscriptionN(List<Inscription> listeInscriptionN) {
        this.listeInscriptionN = listeInscriptionN;
    }

    public List<NoteNiveau> getListeNotesNiveau() {
        return listeNotesNiveau;
    }

    public void setListeNotesNiveau(List<NoteNiveau> listeNotesNiveau) {
        this.listeNotesNiveau = listeNotesNiveau;
    }

    public Semester getSemester1() {
        return semester1;
    }

    public void setSemester1(Semester semester1) {
        this.semester1 = semester1;
    }

    public Semester getSemester2() {
        return semester2;
    }

    public void setSemester2(Semester semester2) {
        this.semester2 = semester2;
    }

    /*examen*/
    public List<Paiement> getListePaiements() {
        return listePaiements;
    }

    public void setListePaiements(List<Paiement> listePaiements) {
        this.listePaiements = listePaiements;
    }

    public List<Montant> getListeMontants() {
        return listeMontants;
    }

    public void setListeMontants(List<Montant> listeMontants) {
        this.listeMontants = listeMontants;
    }

    /*examen*/
}
