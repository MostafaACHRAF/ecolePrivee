package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by Mostafa ACHRAF on 12/25/2016.
 */
public class ReleveeNotesController implements Initializable {

    public TableView tableReleveeNotes;
    public TableColumn<ReleveeNotesInterface, String> colSemesters;
    public TableColumn<ReleveeNotesInterface, String> colModules;
    public TableColumn<ReleveeNotesInterface, String> colMatieres;
    public TableColumn<ReleveeNotesInterface, String> colNotes;
    public TableColumn<ReleveeNotesInterface, String> colMoyennes;
    public Label labelCne;
    public Label labelNom;
    public Label labelPrenom;
    public Label labelNiveau;
    public Label labelGroupe;
    public Label labelSemester;
    public Label labelAnneeUniv;
    public Label labelMoyenneGenerale;

    public ToggleButton btnImprimer;

    private ObservableList<ReleveeNotesInterface> releveeNotes  = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colSemesters.setCellValueFactory(new PropertyValueFactory<ReleveeNotesInterface, String>("semester"));
        colModules.setCellValueFactory(new PropertyValueFactory<ReleveeNotesInterface, String>("module"));
        colMatieres.setCellValueFactory(new PropertyValueFactory<ReleveeNotesInterface, String>("matiere"));
        colNotes.setCellValueFactory(new PropertyValueFactory<ReleveeNotesInterface, String>("note"));
        colMoyennes.setCellValueFactory(new PropertyValueFactory<ReleveeNotesInterface, String>("moyenne"));
        loadData();
    }

    public void loadData () {
        
        Map<String, HashMap<String, Double>> notesModulesS1 = null;
        Map<String, HashMap<String, Double>> notesModulesS2 = null;

        ObservableList<GestionNotes_ReleveeNotes> listeReleveeDetails = GestionNotes_ReleveeNotes.listeDetailsRelevees;

        for (int i = 0; i < listeReleveeDetails.size(); i++) {
            labelCne.setText(listeReleveeDetails.get(i).getCne());
            labelNom.setText(listeReleveeDetails.get(i).getNom());
            labelPrenom.setText(listeReleveeDetails.get(i).getPrenom());
            labelNiveau.setText(listeReleveeDetails.get(i).getNiveau());
            labelGroupe.setText(listeReleveeDetails.get(i).getGroupe());
            labelSemester.setText(listeReleveeDetails.get(i).getSemester());

            notesModulesS1 = listeReleveeDetails.get(i).getNotesModulesS1();
            notesModulesS2 = listeReleveeDetails.get(i).getNotesModulesS2();

            Set<Map.Entry<String, HashMap<String, Double>>> set1 = notesModulesS1.entrySet();
            for (Map.Entry<String, HashMap<String, Double>> e1 : set1) {
                String key1 = e1.getKey();
                listeReleveeDetails.get(i).setModule(key1);
                Map<String, Double> map2 = e1.getValue();
                Set<Map.Entry<String, Double>> set2 = map2.entrySet();
                for (Map.Entry<String, Double> e2 : set2) {
                    String key2 = e2.getKey();
                    Double value2 = e2.getValue();
                    System.out.println(key2 + " - " + value2);
                    listeReleveeDetails.get(i).setModule(key1);
                    labelMoyenneGenerale.setText(listeReleveeDetails.get(i).getMoyenneGenerale());
                    releveeNotes.add(new ReleveeNotesInterface("Semester 1", key1, key2, value2.toString(), listeReleveeDetails.get(i).getMoyenneS1(), listeReleveeDetails.get(i).getMoyenneGenerale()));
                }
            }

            Set<Map.Entry<String, HashMap<String, Double>>> set11 = notesModulesS2.entrySet();
            for (Map.Entry<String, HashMap<String, Double>> e11 : set11) {
                String key11 = e11.getKey();
                Map<String, Double> map22 = e11.getValue();
                Set<Map.Entry<String, Double>> set22 = map22.entrySet();
                for (Map.Entry<String, Double> e22 : set22) {
                    String key22 = e22.getKey();
                    Double value22 = e22.getValue();
                    releveeNotes.add(new ReleveeNotesInterface("Semester 2", key11, key22, value22.toString(), listeReleveeDetails.get(i).getMoyenneS2(), listeReleveeDetails.get(i).getMoyenneGenerale()));
                }
            }
        }
        tableReleveeNotes.setItems(releveeNotes);
    }
}
