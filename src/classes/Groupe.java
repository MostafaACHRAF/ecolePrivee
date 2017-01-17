package classes;

import java.util.ArrayList;
import java.util.List;

public class Groupe {

    //Attributs :
    private int idG;
    private String libelle;
    private List<Inscription> listeInscG = new ArrayList<Inscription>();

    //Constructeurs :
    public Groupe (String libelle) {
        this.setLibelle(libelle);
    }

    public Groupe (int idG, String libelle) {
        this(libelle);
        this.setIdG(idG);
    }

    //Getters :
    public int getIdG() { return this.idG; }
    public String getLibelle() { return  this.libelle; }
    public List<Inscription> getListeInscG() { return this.listeInscG; }

    //Setters :
    public void setIdG(int idG) { this.idG = idG; }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    public void setListeInscG(Inscription insc) { this.listeInscG.add(insc); }
}