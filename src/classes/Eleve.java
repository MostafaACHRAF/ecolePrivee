package classes;

import java.util.ArrayList;
import java.util.List;

public class Eleve {

    //Attributs :
    private int idE;
    private String cne;
    private String nom;
    private String prenom;
    private String adresse;
    private List<Inscription> listeInscE = new ArrayList<Inscription>();
    private List<NoteMatiere> listeNotesMatiers = new ArrayList<>();
    private List<NoteNiveau> listeNotesNiveaux = new ArrayList<>();
    /*examen*/
    private List<Paiement> listePaiments = new ArrayList<>();
    /*examen*/

    //Constructeurs :
    public Eleve (int idE, String cne, String nom, String prenom, String adresse) {
        this(cne, nom, prenom, adresse);
        this.setIdE(idE);
    }
    public Eleve (String cne, String nom, String prenom, String adresse) {
        this.setCne(cne);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
    }

    //Getters :
    public int getIdE() { return this.idE; }
    public String getCne() { return this.cne; }
    public String getNom() {
        return this.nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public String getAdresse() {
        return this.adresse;
    }
    public List<Inscription> getListeInscE() { return this.listeInscE; }

    //Setters :
    public void setIdE (int idE) { this.idE = idE; }
    public void setCne(String cne) {
        this.cne = cne;
    }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public void setListeInscE(Inscription insc) { this.listeInscE.add(insc); }

    public void setListeInscE(List<Inscription> listeInscE) {
        this.listeInscE = listeInscE;
    }

    public List<NoteMatiere> getListeNotesMatiers() {
        return listeNotesMatiers;
    }

    public void setListeNotesMatiers(List<NoteMatiere> listeNotesMatiers) {
        this.listeNotesMatiers = listeNotesMatiers;
    }

    public List<NoteNiveau> getListeNotesNiveaux() {
        return listeNotesNiveaux;
    }

    public void setListeNotesNiveaux(List<NoteNiveau> listeNotesNiveaux) {
        this.listeNotesNiveaux = listeNotesNiveaux;
    }

    /*examen*/
    public List<Paiement> getListePaiments() {
        return listePaiments;
    }

    public void setListePaiments(List<Paiement> listePaiments) {
        this.listePaiments = listePaiments;
    }
    /*examen*/
}
