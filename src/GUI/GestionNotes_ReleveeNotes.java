package GUI;

import classes.Matiere;
import classes.Module;
import dao.DaoMatiere;
import dao.DaoModule;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mostafa ACHRAF on 12/25/2016.
 */
public class GestionNotes_ReleveeNotes {
    private String cne;
    private String nom;
    private String prenom;
    private String niveau;
    private String groupe;
    private String semester;
    private String module;
    private String matiere;
    private String note;
    private String moyenne;
    private String moyenneS1;
    private String moyenneS2;
    private String moyenneGenerale;
    private Map<String, HashMap<String, Double>> notesModulesS1;
    private Map<String, HashMap<String, Double>> notesModulesS2;
    static ObservableList<GestionNotes_ReleveeNotes> listeDetailsRelevees = FXCollections.observableArrayList();

    private  ObservableList<GestionNotes_ReleveeNotes> relevee;

    public GestionNotes_ReleveeNotes(String cne, String nom, String prenom, String niveau, String groupe, Map<String, HashMap<String, Double>> notesModulesS1, Map<String, HashMap<String, Double>> notesModulesS2, Double moyenneS1, Double moyenneS2, Double moyenneGenerale) {
        this.cne = cne;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.groupe = groupe;
        this.moyenneS1 = Double.toString(moyenneS1);
        this.moyenneS2 = Double.toString(moyenneS2);
        this.moyenneGenerale = Double.toString(moyenneGenerale);
        this.notesModulesS1 = notesModulesS1;
        this.notesModulesS2 = notesModulesS2;
    }

    public GestionNotes_ReleveeNotes () {
        //
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public Map<String, HashMap<String, Double>> getNotesModulesS1() {
        return notesModulesS1;
    }

    public void setNotesModulesS1(Map<String, HashMap<String, Double>> notesModulesS1) {
        this.notesModulesS1 = notesModulesS1;
    }

    public Map<String, HashMap<String, Double>> getNotesModulesS2() {
        return notesModulesS2;
    }

    public void setNotesModulesS2(Map<String, HashMap<String, Double>> notesModulesS2) {
        this.notesModulesS2 = notesModulesS2;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(String moyenne) {
        this.moyenne = moyenne;
    }

    public String getMoyenneS1() {
        return moyenneS1;
    }

    public void setMoyenneS1(String moyenneS1) {
        this.moyenneS1 = moyenneS1;
    }

    public String getMoyenneS2() {
        return moyenneS2;
    }

    public void setMoyenneS2(String moyenneS2) {
        this.moyenneS2 = moyenneS2;
    }

    public String getMoyenneGenerale() {
        return moyenneGenerale;
    }

    public void setMoyenneGenerale(String moyenneGenerale) {
        this.moyenneGenerale = moyenneGenerale;
    }

    public static void getDetails(ObservableList<GestionNotes_Semester> listeAllSemesters, ObservableList<GestionNotes_ElevesNotes> listeAllElevesNotes, ObservableList<GestionNotes_notes> listeNotesFoOneEleve, SimpleIntegerProperty index_eleveNote, SimpleIntegerProperty index_niveaux, SimpleIntegerProperty index_groupes, SimpleIntegerProperty index_semestre, ObservableList<GestionNotes_Niveaux> listeAllNiveaux, ObservableList<GestionNotes_Groupes> listeAllGroupes) {

        Map<String, HashMap<String, Double>> mapNotesModulesS1 = new HashMap<String, HashMap<String, Double>>();
        Map<String, HashMap<String, Double>> mapNotesModulesS2 = new HashMap<String, HashMap<String, Double>>();
        ObservableList<GestionNotes_ReleveeNotes> listeDetailsRelevees_ = FXCollections.observableArrayList();
        List<Matiere> listeMatiresOfModule = new ArrayList<Matiere>();
        List<Module> listeModulesOfSemester = new ArrayList<Module>();
        //List<GestionNotes_notes> listeNotes = new ArrayList<>();
        int i = index_eleveNote.get();
        //int niveau = listeAllNiveaux.get(index_niveaux.get()).getIdN();
        int module;
        int semester;
        double moyenneModule = 0;
        double moyenneSemester1 = 0;
        double moyenneSemester2 = 0;
        double moyenneGenerale = 0;
        boolean moduleComplet = true;
        boolean semesterComplet = true;
        List<GestionNotes_Modules> listeNotesModules = new ArrayList<GestionNotes_Modules>();

        //pour chaque module de S1 et S2 de l'année universitaire courante :
        for (int t = 0; t < listeAllSemesters.size(); t++) {
            semester = listeAllSemesters.get(t).getIdS();
            listeModulesOfSemester.clear();
            listeNotesModules.clear();

            //Récupérer les modules du semester courant :
            new DaoModule().getBySemester(semester, listeModulesOfSemester);

            //On calcule la moyenne pour chaque module
            for (int j = 0; j < listeModulesOfSemester.size(); j++) {
                moyenneModule = 0;
                module = listeModulesOfSemester.get(j).getIdM();
                //mapNotesMatieres.clear();

                //Récuperer les matières du module courant :
                listeNotesFoOneEleve.clear();
                listeMatiresOfModule.clear();
                new DaoMatiere().getByIdModule(listeModulesOfSemester.get(j).getIdM(), listeMatiresOfModule);

                //Remplire la liste 'ListeNotesFoEleve' qui contient les notes de chaque matières appartienne au module courant de l'élève choisi :
                GestionNotes_ElevesNotes.getNotesEleve(listeAllElevesNotes.get(i).getCne(), listeMatiresOfModule, listeNotesFoOneEleve, module, LocalDate.now().getYear());

                //Remplir Map par les notes des matières de S1
                if (listeAllSemesters.get(t).getSemester().equals("S1")) {
                    Map<String, Double> mapNotesMatieres = new HashMap<String, Double>();
                    for (GestionNotes_notes aListeNotesFoOneEleve : listeNotesFoOneEleve)
                        mapNotesMatieres.put(aListeNotesFoOneEleve.getMatiere(), aListeNotesFoOneEleve.getNote());

                    mapNotesModulesS1.put(listeModulesOfSemester.get(j).getLibelleM(), (HashMap<String, Double>) mapNotesMatieres);
                }

                //Creer Map du deuxième semester :
                else {
                    Map<String, Double> mapNotesMatieres = new HashMap<String, Double>();
                    for (GestionNotes_notes aListeNotesFoOneEleve : listeNotesFoOneEleve)
                        mapNotesMatieres.put(aListeNotesFoOneEleve.getMatiere(), aListeNotesFoOneEleve.getNote());

                    mapNotesModulesS2.put(listeModulesOfSemester.get(j).getLibelleM(), (HashMap<String, Double>) mapNotesMatieres);
                }

                //Calucler la moyenne du module courant :
                for (GestionNotes_notes aListeNotesFoOneEleve : listeNotesFoOneEleve) {
                    moyenneModule += aListeNotesFoOneEleve.getNote();
                }
                if (listeNotesFoOneEleve.size() != 0)
                    moyenneModule = moyenneModule / listeNotesFoOneEleve.size();
                else
                    moduleComplet = false; //si une note est introuvable, on mentionne qu'il reste une matière sans note !

                //Remplir la liste qui rassemble la moyenne de chaque module :
                listeNotesModules.add(new GestionNotes_Modules(listeModulesOfSemester.get(j).getLibelleM(), moyenneModule));
            }

            //Calculer la moyenne du premier semester :
            if (listeAllSemesters.get(t).getSemester().equals("S1")) {

                //Parcourir les notes des modules de S1 :
                for (GestionNotes_Modules listeNotesModule : listeNotesModules) {
                    moyenneSemester1 += listeNotesModule.getMoyenne();
                }
                moyenneSemester1 = (double) Math.round((moyenneSemester1 / listeNotesModules.size()) * 100) / 100;
                if (!moduleComplet)
                    System.out.println("module incomplet");
            }

            //Calculer la moyenne du deuxième semester :
            else {
                //Parcourir les notes des modules de S1 :
                for (GestionNotes_Modules listeNotesModule : listeNotesModules) {
                    moyenneSemester2 += listeNotesModule.getMoyenne();
                }
                moyenneSemester2 = (double) Math.round((moyenneSemester2 / listeNotesModules.size()) * 100) / 100;
                if (!moduleComplet)
                    System.out.println("module incomplet");
            }
        }

        //Calculer la moyenne générale de l'élève dans l'année universitaire courante :
        moyenneGenerale = (double) Math.round(((moyenneSemester1 + moyenneSemester2) / 2) * 100) / 100;
        //System.out.println("-*-*-*-*-*-*-* la moyenne générale de  " + listeAllElevesNotes.get(index_eleveNote.get()).getNomEleve() + " est : " + moyenneGenerale);

            /*Map<String, HashMap<String, Integer>> map1 = new HashMap<String, HashMap<String, Integer>> ();
            //  On utilise la méthode entrySet de l'intertace Map.
            Set<Map.Entry<String, HashMap<String, Double>>> set1 = mapNotesModules.entrySet();
            for (Map.Entry<String, HashMap<String, Double>> e1 : set1) {
                String key1 = e1.getKey();
                System.out.println("***" + key1 + "***");
                Map<String, Double> map2 = e1.getValue();
                Set<Map.Entry<String, Double>> set2 = map2.entrySet();
                for (Map.Entry<String, Double> e2 : set2) {
                    String key2 = e2.getKey();
                    Double value2 = e2.getValue();
                    System.out.println(key2 + " - " + value2);
                }
            }*/

        String cne = listeAllElevesNotes.get(index_eleveNote.get()).getCne();
        String nom = listeAllElevesNotes.get(index_eleveNote.get()).getNomEleve();
        String prenom = listeAllElevesNotes.get(index_eleveNote.get()).getNomEleve();
        String niveau = listeAllNiveaux.get(index_niveaux.get()).getLibelleN();
        String groupe = listeAllGroupes.get(index_groupes.get()).getLibelleG();
        String semester_ = "S1 & S2";//listeAllSemesters.get(index_semestre.get()).getSemester();
        String anneeUniv =  Integer.toString(2016) + "/" + 2017;

        System.out.println("(" + cne + " - " + nom + " - " + prenom + " - " + niveau + " - " + groupe + " - " + semester_ + " - " + anneeUniv);

        //Remplir la liste des informations à afficher :
        listeDetailsRelevees_.add(new GestionNotes_ReleveeNotes(cne, nom, prenom, niveau, groupe, mapNotesModulesS1, mapNotesModulesS2, moyenneSemester1, moyenneSemester2, moyenneGenerale));
        GestionNotes_ReleveeNotes.listeDetailsRelevees = listeDetailsRelevees_;
    }
}
