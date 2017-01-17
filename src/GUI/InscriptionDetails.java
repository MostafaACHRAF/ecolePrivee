package GUI;

import dao.DaoInscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import connexion.Connexion;
import javafx.collections.ObservableList;

/**
 * Created by Mostafa ACHRAF on 12/10/2016.
 */
public class InscriptionDetails {

    //Attributs :
    private int idE;
    private String cne;
    private String nom;
    private String adresse;
    private String prenom;

    private int idI;
    private LocalDate date_insc;
    private String etat;

    private int idN;
    private String libelleN;

    private int idG;
    private String libelleG;

    //CONSTRUCTEURS:
    public InscriptionDetails(int idE, int idI, String cne, String nom, String prenom, String adresse, LocalDate date_insc, String etat, String niveau) {
        this.setIdE(idE);
        this.setIdI(idI);
        this.setCne(cne);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setDate_insc(date_insc);
        this.setEtat(etat);
        this.setLibelleN(niveau);
        this.setLibelleG("");
    }

    public InscriptionDetails(int idE, int idI, String cne, String nom, String prenom, String adresse, LocalDate date_insc, String etat, String niveau, String groupe) {
        this(idE, idI, cne, nom, prenom, adresse, date_insc, etat, niveau);
        this.setLibelleG(groupe);
    }

    //Getters :
    public int getIdE() {
        return this.idE;
    }

    public String getCne() {
        return this.cne;
    }

    public String getNom() {
        return this.nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public int getIdI() {
        return this.idI;
    }

    public LocalDate getDate_insc() {
        return this.date_insc;
    }

    public String getEtat() {
        return this.etat;
    }

    public int getIdN() {
        return this.idN;
    }

    public String getLibelleN() {
        return this.libelleN;
    }

    public int getIdG() {
        return this.idG;
    }

    public String getLibelleG() {
        return this.libelleG;
    }

    //SETTERS :
    public void setIdE(int idE) {
        this.idE = idE;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setIdI(int idI) {
        this.idI = idI;
    }

    public void setDate_insc(LocalDate date_insc) {
        this.date_insc = date_insc;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setIdN(int idN) {
        this.idN = idN;
    }

    public void setLibelleN(String libelleN) {
        this.libelleN = libelleN;
    }

    public void setIdG(int idG) {
        this.idG = idG;
    }

    public void setLibelleG(String libelleG) {
        this.libelleG = libelleG;
    }

    public static void getAllInscriptionsDetails(ObservableList<InscriptionDetails> listeDetails) {

        DaoInscription daoInscription = new DaoInscription();

        try {
            Connection connection = Connexion.getInstance().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT  * FROM eleve e, inscription i, niveau n WHERE e.idE = i.idE AND n.idN = i.idN ORDER BY i.idI DESC ");
            //SELECT  * FROM eleve e, inscription i, niveau n, groupe g, affectation a WHERE e.idE = i.idE and n.idN = i.idI and a.idI = i.idI and g.idG = a.idG
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                if (rs.getString("etat").equals("non affectee"))
                    listeDetails.add(new InscriptionDetails(rs.getInt("idE"), rs.getInt("idI"), rs.getString("cne"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getDate("date_insc").toLocalDate(), rs.getString("etat"), rs.getString("libelleN")));
                else {
                    PreparedStatement stm2 = connection.prepareStatement("SELECT  libelleG FROM groupe g, inscription i, affectation a WHERE a.idI = i.idI AND a.idG = g.idG and i.idI = ? ORDER BY i.idI DESC ");
                    stm2.setInt(1, rs.getInt("idI"));
                    ResultSet rs2 = stm2.executeQuery();
                    if (rs2.next())
                        listeDetails.add(new InscriptionDetails(rs.getInt("idE"), rs.getInt("idI"), rs.getString("cne"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"), rs.getDate("date_insc").toLocalDate(), rs.getString("etat"), rs.getString("libelleN"), rs2.getString("libelleG")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "[" + cne + "," + nom + "," + prenom + "," + adresse + "," + date_insc.toString() + "," + etat + "," + libelleN + "," + libelleG + "]";
    }
}
