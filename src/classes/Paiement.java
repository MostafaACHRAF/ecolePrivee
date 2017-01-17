package classes;

/**
 * Created by Mostafa ACHRAF on 12/30/2016.
 */
public class Paiement {
    private int idP;
    private String mode;
    private double montant;
    private int mois;
    private int annee;
    private Eleve eleve;
    private Niveau niveau;

    public Paiement(int idP, String mode, double montant, int mois, int annee, Eleve eleve, Niveau niveau) {
        this.idP = idP;
        this.mode = mode;
        this.montant = montant;
        this.mois = mois;
        this.annee = annee;
        this.eleve = eleve;
        this.niveau = niveau;
    }

    public Paiement(String mode, double montant, int mois, int annee, Eleve eleve, Niveau niveau) {
        this.mode = mode;
        this.montant = montant;
        this.mois = mois;
        this.annee = annee;
        this.eleve = eleve;
        this.niveau = niveau;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
