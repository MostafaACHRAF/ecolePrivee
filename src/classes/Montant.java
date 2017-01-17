package classes;

/**
 * Created by Mostafa ACHRAF on 12/30/2016.
 */
public class Montant {
    private int idMontant;
    private double montant;
    private int annee_univ;
    private Niveau niveau;

    public Montant(int idMontant, double montant, int annee_univ) {
        this.idMontant = idMontant;
        this.montant = montant;
        this.annee_univ = annee_univ;
    }

    public Montant(double montant, int annee_univ) {
        this.montant = montant;
        this.annee_univ = annee_univ;
    }

    public int getIdMontant() {
        return idMontant;
    }

    public void setIdMontant(int idMontant) {
        this.idMontant = idMontant;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public int getAnnee_univ() {
        return annee_univ;
    }

    public void setAnnee_univ(int annee_univ) {
        this.annee_univ = annee_univ;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
