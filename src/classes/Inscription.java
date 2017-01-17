package classes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Inscription {

    //Attributs :
    private int idI;
    private LocalDate date_insc;
    private String etat;
    private Niveau niveau;
    private Eleve eleve;
    private List<Groupe> listeGroupesI = new ArrayList<Groupe>();

    //Constructeurs :
    public Inscription (int idI, LocalDate date_insc, Niveau niveau, Eleve eleve) {
        this(date_insc, "non affectee", niveau, eleve);
        this.setIdI(idI);
    }

    public Inscription (LocalDate date_insc, String etat, Niveau niveau, Eleve eleve) {//
        this.setDate_insc(date_insc);
        this.setEtat(etat);
        this.setNiveau(niveau);
        this.setEleve(eleve);
    }

    public Inscription (int idI, LocalDate date_insc, Niveau niveau, Eleve eleve, Groupe groupe) {
        this(date_insc, "affectee", niveau, eleve, groupe);
        this.setIdI(idI);
    }

    public Inscription (LocalDate date_insc, String etat, Niveau niveau, Eleve eleve, Groupe groupe) {//
        this(date_insc, etat, niveau, eleve);
        this.setListeGroupesI(groupe);
    }

    public Inscription (LocalDate date_insc, Niveau niveau, Eleve eleve) {//
        this(date_insc, "non affectee", niveau, eleve);
    }

    //Getters :
    public int getIdI() { return  this.idI; }
    public LocalDate getDate_insc() { return this.date_insc; }
    public String getEtat() { return this.etat; }
    public Niveau getNiveau() { return this.niveau; }
    public Eleve getEleve() { return this.eleve; }
    public List<Groupe> getListeGroupesI() { return this.listeGroupesI; }


    //Setters :
    public void setIdI(int idI) { this.idI = idI; }
    public void setDate_insc (LocalDate date_insc) {
        this.date_insc = date_insc;
    }
    public void setEtat (String etat) { this.etat = etat; }
    public void setNiveau (Niveau niveau) { this.niveau = niveau; }
    public void setEleve (Eleve eleve) { this.eleve = eleve; }
    public void setListeGroupesI(Groupe groupe) { this.listeGroupesI.add(groupe); }

    @Override
    public String toString() {
        return "[" + idI + "," + date_insc.toString() + "," + etat + "," + "]";
    }
}
