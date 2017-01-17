package GUI;

import classes.Eleve;
import connexion.Connexion;
import dao.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Mostafa ACHRAF on 12/10/2016.
 */
public class gestionNotesController implements Initializable {

    public Label labelPath;
    public TableView tableNiveaux;
    public TableColumn<GestionNotes_Niveaux, String> colNiveaux;
    public TableView tableGroupes;
    public TableColumn<GestionNotes_Groupes, String> colGroupes;
    public TableView tableModules;
    public TableColumn<GestionNotes_Modules, String> colModules;
    public TableView tableSemester;
    public TableColumn<GestionNotes_Semester, String> colSemester;
    public TableView tableMatieres;
    public TableColumn<GestionNotes_Matieres, String> colMatieres;
    public TableView tablePrincipale;
    public TableColumn<GestionNotes_ElevesNotes, String> colCne;
    public TableColumn<GestionNotes_ElevesNotes, String> colNom;
    public TableColumn<GestionNotes_ElevesNotes, String> colPrenom;
    public TableColumn<GestionNotes_ElevesNotes, String> colNote;
    public TableColumn<GestionNotes_ElevesNotes, String> colValider;

    public Label labelMessage;
    public Button btnEnregistrer;

    private ObservableList<GestionNotes_Niveaux> listeAllNiveaux = FXCollections.observableArrayList();
    private ObservableList<GestionNotes_Groupes> listeAllGroupes = FXCollections.observableArrayList();
    private ObservableList<GestionNotes_Modules> listeAllModules = FXCollections.observableArrayList();
    private ObservableList<GestionNotes_Matieres> listeAllMatieres = FXCollections.observableArrayList();
    private ObservableList<GestionNotes_ElevesNotes> listeAllElevesNotes = FXCollections.observableArrayList();
    private ObservableList<GestionNotes_Semester> listeAllSemesters = FXCollections.observableArrayList();
    private ObservableList<GestionNotes_notes> listeNotesFoOneEleve = FXCollections.observableArrayList();
    private SimpleIntegerProperty index_niveaux = new SimpleIntegerProperty();
    private SimpleIntegerProperty index_groupes = new SimpleIntegerProperty();
    private SimpleIntegerProperty index_modules = new SimpleIntegerProperty();
    private SimpleIntegerProperty index_matieres = new SimpleIntegerProperty();
    private SimpleIntegerProperty index_eleveNote = new SimpleIntegerProperty();
    private SimpleIntegerProperty index_semestre = new SimpleIntegerProperty();
    /**/
    private ObservableList<GestionNotes_ElevesNotes> list = FXCollections.observableArrayList();

    public class InfoSave {
        public double note;
        public GestionNotes_ElevesNotes eleve;

        public InfoSave(GestionNotes_ElevesNotes e, double m) {
            this.eleve = e;
            this.note = m;
        }

        public double getNote() {
            return note;
        }
    }

    private Map<String, InfoSave> CHANGES = new HashMap<String, InfoSave>();



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colNiveaux.setCellValueFactory(new PropertyValueFactory<GestionNotes_Niveaux, String>("libelleN"));
        colGroupes.setCellValueFactory(new PropertyValueFactory<GestionNotes_Groupes, String>("libelleG"));
        colModules.setCellValueFactory(new PropertyValueFactory<GestionNotes_Modules, String>("libelleM"));
        colMatieres.setCellValueFactory(new PropertyValueFactory<GestionNotes_Matieres, String>("nom"));
        colCne.setCellValueFactory(new PropertyValueFactory<GestionNotes_ElevesNotes, String>("cne"));
        colNom.setCellValueFactory(new PropertyValueFactory<GestionNotes_ElevesNotes, String>("nomEleve"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<GestionNotes_ElevesNotes, String>("prenom"));
        colNote.setCellValueFactory(new PropertyValueFactory<GestionNotes_ElevesNotes, String>("note"));

        tablePrincipale.setEditable(true);
        colNote.setEditable(true);

        colNote.setCellFactory(new Callback<TableColumn<GestionNotes_ElevesNotes, String>, TableCell<GestionNotes_ElevesNotes, String>>() {
            @Override
            public TableCell<GestionNotes_ElevesNotes, String> call(TableColumn<GestionNotes_ElevesNotes, String> param) {
                return new EditingCell();
            }
        });

        colNote.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<GestionNotes_ElevesNotes, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<GestionNotes_ElevesNotes, String> event) {
                try {
                    Pattern p = Pattern.compile("[0-9]{1,2}(\\.[0-9]{1,2})?");
                    if(!p.matcher(event.getNewValue()).matches()) throw  new Exception("La note saisie est invalide !");
                    //double note = Double.parseDouble(event.getNewValue());
                    CHANGES.put((event.getTableView().getItems().get(event.getTablePosition().getRow())).getCne(), new InfoSave(((GestionNotes_ElevesNotes) event.getTableView().getItems().get(event.getTablePosition().getRow())), (event.getNewValue().equals("")) ? 0.0 : Double.valueOf(event.getNewValue())));
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur ! Note invalide");
                    alert.setHeaderText(null);
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
            }
        });

        tablePrincipale.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                KeyCode keyCode = keyEvent.getCode();
                if (keyCode == KeyCode.ENTER || keyCode == KeyCode.ESCAPE) {
                    CellField.clearText();
                }
                if (keyCode.isDigitKey()) {
                    int row = tablePrincipale.getSelectionModel().getSelectedIndex();
                    tablePrincipale.edit(row, colNote);
                }
            }
        });


        colValider.setCellValueFactory(new PropertyValueFactory<GestionNotes_ElevesNotes, String>("valider"));
        colSemester.setCellValueFactory(new PropertyValueFactory<GestionNotes_Semester, String>("semester"));
        loadDatabaseData();

        tableNiveaux.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                index_niveaux.set(listeAllNiveaux.indexOf(newValue));
                //charger les groupes du niveau choisi :
                if (tableNiveaux.getSelectionModel().getSelectedItem() != null) {
                    listeAllGroupes.clear();
                    listeAllModules.clear();
                    listeAllMatieres.clear();
                    listeAllSemesters.clear();
                    listeAllElevesNotes.clear();
                    GestionNotes_Groupes.getAllGroupes(listeAllGroupes, listeAllNiveaux.get(index_niveaux.get()).getIdN());
                    tableGroupes.setItems(listeAllGroupes);
                }
            }
        });

        tableGroupes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                index_groupes.set(listeAllGroupes.indexOf(newValue));

                if (tableGroupes.getSelectionModel().getSelectedItem() != null) {
                    listeAllModules.clear();
                    listeAllMatieres.clear();
                    listeAllSemesters.clear();
                    GestionNotes_Semester.getAllSemester(listeAllSemesters, 2016, listeAllNiveaux.get(index_niveaux.get()).getIdN());
                    tableSemester.setItems(listeAllSemesters);
                }

            }
        });

        tableSemester.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                index_semestre.set(listeAllSemesters.indexOf(newValue));
                //charger les modules :
                if (tableSemester.getSelectionModel().getSelectedItem() != null) {
                    listeAllModules.clear();
                    listeAllMatieres.clear();
                    listeAllElevesNotes.clear();
                    GestionNotes_Modules.getAllModules(listeAllModules, listeAllSemesters.get(index_semestre.get()).getIdS());
                    tableModules.setItems(listeAllModules);
                }
            }
        });

        tableModules.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                index_modules.set(listeAllModules.indexOf(newValue));
                //charger les matières du module choisi :
                if (tableModules.getSelectionModel().getSelectedItem() != null) {
                    listeAllMatieres.clear();
                    listeAllElevesNotes.clear();
                    GestionNotes_Matieres.getAllMatieres(listeAllMatieres, listeAllModules.get(index_modules.get()).getIdM());
                    tableMatieres.setItems(listeAllMatieres);
                }
            }
        });

        tableMatieres.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                index_matieres.set(listeAllMatieres.indexOf(newValue));
                //charger les élèves inscrits dans le groupe et le niveau choisi :
                if (tableMatieres.getSelectionModel().getSelectedItem() != null) {
                    listeAllElevesNotes.clear();
                    GestionNotes_ElevesNotes.getAllElevesInfos(listeAllElevesNotes, listeAllMatieres.get(index_matieres.get()).getIdMat(), listeAllNiveaux.get(index_niveaux.get()).getIdN(), listeAllGroupes.get(index_groupes.get()).getIdG());
                    tablePrincipale.setItems(listeAllElevesNotes);
                }
            }
        });

        tablePrincipale.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                index_eleveNote.set(listeAllElevesNotes.indexOf(newValue));
            }
        });


    }

    private void loadDatabaseData() {
        //charger les niveaux :
        GestionNotes_Niveaux.getAllNiveaux(listeAllNiveaux);
        tableNiveaux.setItems(listeAllNiveaux);
    }

    public void save() {
        //
    }

        /*****/

    @FXML
    private void onEditStart() {
        CellField.clearText();
    }


    public void enregisterNotes() {

        if (CHANGES.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERREUR ! Enregistrement du vide !");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez modifier ou ajouter une note. Aucune note n'a été ajoutée ou modifiée");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation ! Modification des notes");
            alert.setHeaderText(null);
            alert.setContentText("Voulez-vous vraiment enregistrer les modifications saisie ?");
            alert.showAndWait();

            DaoEleve daoEleve = new DaoEleve();
            GestionNotes_Matieres matiere = listeAllMatieres.get(index_matieres.get());
            GestionNotes_Niveaux niveau = listeAllNiveaux.get(index_niveaux.get());
            GestionNotes_Groupes groupe = listeAllGroupes.get(index_groupes.get());
            String valider = "";

            if (alert.getResult() == ButtonType.OK) {
                for (Map.Entry<String, InfoSave> entry : CHANGES.entrySet()) {
                    String cle = entry.getKey();
                    InfoSave valeur = entry.getValue();
                    Eleve eleve = daoEleve.getByCne(cle);

                    // traitements
                    try {
                        if (avoirNote(eleve.getIdE(), 2016, matiere.getIdMat())) {
                            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement(
                                    "UPDATE note_matiere SET note = ?, valider = ? WHERE annee_univ = ? AND idE = ? AND idMat = ?"
                            );
                            valider = (valeur.getNote() >= listeAllMatieres.get(index_matieres.get()).getSeuil()) ? "V" : "NV";
                            stm.setDouble(1, valeur.getNote());
                            stm.setString(2, valider);
                            stm.setInt(3, 2016);
                            stm.setInt(4, daoEleve.getByCne(cle).getIdE());
                            stm.setInt(5, matiere.getIdMat());
                            stm.executeUpdate();
                        } else {
                            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement(
                                    "INSERT INTO note_matiere VALUES (null, ?, ?, ?, ?, ?)"
                            );
                            valider = (valeur.getNote() >= listeAllMatieres.get(index_matieres.get()).getSeuil()) ? "V" : "NV";
                            stm.setDouble(1, valeur.getNote());
                            stm.setString(2, valider);
                            stm.setInt(3, daoEleve.getByCne(cle).getIdE());
                            stm.setInt(4, listeAllMatieres.get(index_matieres.get()).getIdMat());
                            stm.setInt(5, 2016);
                            stm.execute();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            listeAllElevesNotes.clear();
            GestionNotes_ElevesNotes.getAllElevesInfos(listeAllElevesNotes, matiere.getIdMat(), niveau.getIdN(), groupe.getIdG());
            tablePrincipale.setItems(listeAllElevesNotes);
        }
    }

    public boolean avoirNote(int idE, int annee_univ, int idMat) {
        boolean oui = false;
        try {
            PreparedStatement stm = Connexion.getInstance().getConnection().prepareStatement(
                    "SELECT * FROM note_matiere WHERE idE = ? AND annee_univ = ? AND idMat = ?"
            );
            stm.setInt(1, idE);
            stm.setInt(2, annee_univ);
            stm.setInt(3, idMat);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
                oui = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return oui;
    }

    public void displayReleveeNotes () throws IOException {

        GestionNotes_ReleveeNotes.getDetails(listeAllSemesters, listeAllElevesNotes, listeNotesFoOneEleve, index_eleveNote, index_niveaux, index_groupes, index_semestre, listeAllNiveaux, listeAllGroupes);

        if (tablePrincipale.getSelectionModel().getSelectedItem() == null) {
            System.out.println("erreur");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ! Veuillez selectionner un élève");
            alert.setHeaderText(null);
            alert.setContentText("On ne peut pas afiicher les details de rien !!!");
            alert.showAndWait();
        }

        else {
            Parent rootHome = FXMLLoader.load(getClass().getResource("releveeNotesInterface.fxml"));
            Stage stageHome = new Stage();
            Scene sceneHome = new Scene(rootHome);
            stageHome.setScene(sceneHome);
            stageHome.setTitle("Gestion des notes");
            stageHome.show();
        }
    }
}