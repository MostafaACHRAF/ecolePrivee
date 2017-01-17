package GUI;

import classes.Eleve;
import classes.Groupe;
import classes.Inscription;
import classes.Niveau;
import dao.*;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Predicate;

/**
 * Created by Mostafa ACHRAF on 12/10/2016.
 */
public class InterfaceGlobaleController implements Initializable {
    public static InterfaceGlobaleController parent = null;

    public MenuBar MainMenu;
    public Menu menuGestionNotes;
    public Label labelPath;
    public TextField searchBar;
    public TableView mainTable;
    public TableColumn<InscriptionDetails, Integer> colIdE;
    public TableColumn<InscriptionDetails, Integer> colIdI;
    public TableColumn<InscriptionDetails, String> colCne;
    public TableColumn<InscriptionDetails, String> colNom;
    public TableColumn<InscriptionDetails, String> colPrenom;
    public TableColumn<InscriptionDetails, String> colAdresse;
    public TableColumn<InscriptionDetails, String> colDateInsc;
    public TableColumn<InscriptionDetails, String> colEtat;
    public TableColumn<InscriptionDetails, String> colNiveau;
    public TableColumn<InscriptionDetails, String> colGroupe;
    public Label labelMessage;
    public Separator NorthSeparator;
    public Separator SouthSeparator;
    public Button btnSupprimer;
    /*les champs de l'ajout : */
    public TextField cneField;
    public TextField nomField;
    public TextField prenomField;
    public TextField adresseField;
    public DatePicker dateField;
    public ComboBox niveauxBox;
    public Button btnAjouter;

    private ObservableList<InscriptionDetails> listeAllInscriptionsDetails;
    private ObservableList<String> listeAllNiveaux = FXCollections.observableArrayList();
    private ObservableList<String> listeGroupesOfNiveau = FXCollections.observableArrayList();
    private SimpleIntegerProperty index = new SimpleIntegerProperty();
    public Button btnConfirmer;

    private LocalDate dateOuverture = LocalDate.of(2017, 1, 1);
    private LocalDate dateFermeture = LocalDate.of(2017, 12, 31);


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCne.setCellValueFactory(new PropertyValueFactory<InscriptionDetails, String>("cne"));
        colNom.setCellValueFactory(new PropertyValueFactory<InscriptionDetails, String>("nom"));
        colPrenom.setCellValueFactory(new PropertyValueFactory<InscriptionDetails, String>("prenom"));
        colAdresse.setCellValueFactory(new PropertyValueFactory<InscriptionDetails, String>("adresse"));
        colDateInsc.setCellValueFactory(new PropertyValueFactory<InscriptionDetails, String>("date_insc"));
        colEtat.setCellValueFactory(new PropertyValueFactory<InscriptionDetails, String>("etat"));
        colNiveau.setCellValueFactory(new PropertyValueFactory<InscriptionDetails, String>("libelleN"));
        colGroupe.setCellValueFactory(new PropertyValueFactory<InscriptionDetails, String>("libelleG"));
        loadDatabaseData();

        mainTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
            @Override
            public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
                index.set(listeAllInscriptionsDetails.indexOf(newValue));
            }
        });
    }

    public void loadDatabaseData() {

        listeAllInscriptionsDetails = FXCollections.observableArrayList();

        InscriptionDetails.getAllInscriptionsDetails(listeAllInscriptionsDetails);

        mainTable.setItems(listeAllInscriptionsDetails);

        /*remplir comboBox des niveaux*/
        DaoNiveau.getAllNiveaux(listeAllNiveaux);
        niveauxBox.setValue(listeAllNiveaux.get(0));
        niveauxBox.setItems(listeAllNiveaux);
        dateField.setValue(LocalDate.now());

        //System.out.println(dateOuverture.toString() + " " + dateFermeture.toString());
    }

    public void search() {
        FilteredList<InscriptionDetails> filterListe = new FilteredList<InscriptionDetails>(listeAllInscriptionsDetails, e -> true);
        searchBar.setOnKeyReleased(e -> {
            searchBar.textProperty().addListener((observableValue, oldValue, newValue) -> {
                filterListe.setPredicate((Predicate<? super InscriptionDetails>) details -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerData = newValue.toLowerCase();
                    if (details.getCne().contains(newValue)) {
                        return true;
                    } else if (details.getNom().toLowerCase().contains(lowerData)) {
                        return true;
                    } else if (details.getPrenom().toLowerCase().contains(lowerData)) {
                        return true;
                    } else if (details.getAdresse().toLowerCase().contains(lowerData)) {
                        return true;
                    } else if (details.getEtat().toLowerCase().contains(lowerData)) {
                        return true;
                    } else if (details.getLibelleN().toLowerCase().contains(lowerData)) {
                        return true;
                    } else if (details.getLibelleG().toLowerCase().contains(lowerData)) {
                        return true;
                    } else if (details.getDate_insc().toString().toLowerCase().contains(lowerData)) {
                        return true;
                    }

                    return false;
                });
            });

            SortedList<InscriptionDetails> sortedData = new SortedList<InscriptionDetails>(filterListe);
            sortedData.comparatorProperty().bind(mainTable.comparatorProperty());
            mainTable.setItems(sortedData);
        });
    }

    public void delete(ActionEvent event) throws IOException {

        if (mainTable.getSelectionModel().getSelectedItem() == null) {
            //System.out.println("erreur");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ! Veuillez sélectionner une ligne");
            alert.setHeaderText(null);
            alert.setContentText("On ne peut pas supprimer le vide !!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Warning ! Action de supression");
            alert.setHeaderText(null);
            alert.setContentText("Voulez-vous vraiment suprimér cette inscription ?");
            alert.showAndWait();

            if (alert.getResult() == ButtonType.OK) {

                int i = index.get();

                if (i > -1) {
                    DaoEleve daoEleve = new DaoEleve();
                    DaoInscription daoInscription = new DaoInscription();
                    boolean s1 = daoEleve.supprimer(listeAllInscriptionsDetails.get(i).getIdE());
                    boolean s2 = daoInscription.supprimer(listeAllInscriptionsDetails.get(i).getIdI());

                    if (s1 && s2) {
                        labelMessage.setText("L'inscription numéro : " + listeAllInscriptionsDetails.get(i).getIdI() + " à bien été suprimée.");
                    }
                    listeAllInscriptionsDetails.remove(i);
                    mainTable.getSelectionModel().clearSelection();
                }
                //vider la barre de recherche :
                searchBar.clear();
            }
        }
    }

    public void update(ActionEvent event) {

        if (mainTable.getSelectionModel().getSelectedItem() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ! Veuillez sélectionner une inscription quelconque");
            alert.setHeaderText(null);
            alert.setContentText("On ne peut pas editer le vide !!");
            alert.showAndWait();
        }

        else {
            //chrager les donnée de l'élève selectionné :
            int idE = listeAllInscriptionsDetails.get(index.get()).getIdE();
            String cne = listeAllInscriptionsDetails.get(index.get()).getCne();
            String nom = listeAllInscriptionsDetails.get(index.get()).getNom();
            String prenom = listeAllInscriptionsDetails.get(index.get()).getPrenom();
            String adresse = listeAllInscriptionsDetails.get(index.get()).getAdresse();

            ModificationInterface modificationInterface =  new ModificationInterface(idE, cne, nom, prenom, adresse);
            ModificationInterface.listeInfos.clear();
            ModificationInterface.listeInfos.add(modificationInterface);

            Parent rootModification = null;
            try {
                rootModification = FXMLLoader.load(getClass().getResource("modificationInterface.fxml"));
                Stage stageModification = new Stage();
                Scene sceneModification = new Scene(rootModification);
                stageModification.setScene(sceneModification);
                stageModification.setTitle("Page de modification");
                stageModification.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            parent = this;
            labelMessage.setText("La ligne selectionnée à bien été modifier");
        }
    }

    public void add(ActionEvent event) {

        //si les champs est vides erreur :
        if (cneField.getText().isEmpty() || nomField.getText().isEmpty() || prenomField.getText().isEmpty() || adresseField.getText().isEmpty() || dateField.getEditor().getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ! un ou plusieurs champs vides");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs, s'il vous plaît.");
            alert.showAndWait();
        }

        //si les champs remplis mais la date choisi est invalide erreur :
        else if (dateField.getValue().isAfter(dateFermeture) || dateField.getValue().isBefore(dateOuverture)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ! Date invalide !!!");
            alert.setHeaderText(null);
            alert.setContentText(" Vous ne pouvez pas effectuer l'inscription car la date d'ouverture est : " + dateOuverture.toString() + " et la date de fermeture est  : " + dateFermeture);
            alert.showAndWait();
            clearFields();
        }

        //si non si tout est correcte :
        //on verifier si l'eleve est deja inscrit ou non :
        else {
            boolean continuer = true;

            try {
                int cne = Integer.parseInt(cneField.getText());
            }catch (Exception e) {
                Alert alert0 = new Alert(Alert.AlertType.ERROR);
                alert0.setTitle("Erreur ! CNE invalide");
                alert0.setHeaderText(null);
                alert0.setContentText("Le cne de de lélève doit être une suite de chifres !");
                alert0.showAndWait();
                continuer = false;
            }

            try {
                int nom = Integer.parseInt(nomField.getText());
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur ! Nom invalide");
                alert.setHeaderText(null);
                alert.setContentText("Le nom de de lélève doit être une chaine de caractères !");
                alert.showAndWait();

                int prenom = Integer.parseInt(prenomField.getText());
                Alert alert1 = new Alert(Alert.AlertType.ERROR);
                alert1.setTitle("Erreur ! Prénom invalide");
                alert1.setHeaderText(null);
                alert1.setContentText("Le prénom de de lélève doit être une chaine de caractères !");
                alert1.showAndWait();
            }catch (Exception e) {
                continuer = true;
            }
            //System.out.println(continuer);
            Eleve newEleve = new Eleve(cneField.getText(), nomField.getText(), prenomField.getText(), adresseField.getText());
            DaoEleve daoEleve = new DaoEleve();

            //si l'élève n'existe pas deja on le cree :
            if (!daoEleve.existe(newEleve)) {
                //System.out.println("new eleve");
                newEleve = daoEleve.ajouter(newEleve);
                Niveau niveau = new DaoNiveau().getByLibelle(niveauxBox.getValue().toString());
                //on effectuant l'inscription :
                Inscription newInscription = new DaoInscription().ajouter(new Inscription(dateField.getValue(), niveau, newEleve));
                clearFields();
                //affecter l'inscription à un groupe :
                Groupe groupe = new DaoInscription().autoAffectation(newInscription, niveau);
                if (groupe != null) {
                    InscriptionDetails newInscriptionDetails = new InscriptionDetails(
                            newEleve.getIdE(),
                            newInscription.getIdI(),
                            newEleve.getCne(),
                            newEleve.getNom(),
                            newEleve.getPrenom(),
                            newEleve.getAdresse(),
                            newInscription.getDate_insc(),
                            newInscription.getEtat(),
                            niveau.getLibelle(),
                            groupe.getLibelle()
                    );
                    listeAllInscriptionsDetails.add(newInscriptionDetails);
                    //modifier l'etat de l'inscription :
                    newInscriptionDetails.setEtat("affectee");
                    newInscription.setEtat("affectee");
                    new DaoInscription().modifier(newInscription);
                    labelMessage.setText("L'inscription de : " +
                            listeAllInscriptionsDetails.get(listeAllInscriptionsDetails.size() - 1).getNom() +
                            " à bien été ajouté dans le groupe : " +
                            listeAllInscriptionsDetails.get(listeAllInscriptionsDetails.size() - 1).getLibelleG());
                } else {
                    InscriptionDetails newInscriptionDetails = new InscriptionDetails(
                            newEleve.getIdE(),
                            newInscription.getIdI(),
                            newEleve.getCne(),
                            newEleve.getNom(),
                            newEleve.getPrenom(),
                            newEleve.getAdresse(),
                            newInscription.getDate_insc(),
                            newInscription.getEtat(),
                            niveau.getLibelle()
                    );
                    listeAllInscriptionsDetails.add(newInscriptionDetails);
                    labelMessage.setText("L'inscription de : " +
                            listeAllInscriptionsDetails.get(listeAllInscriptionsDetails.size() - 1).getNom() +
                            " à bien été ajouté, mais n'est pas encore affectée !");
                }
                //fin de l'inscription
            }
             /* ************ */
            else {
                //si l'élève existe on le recupere :
                //System.out.println("eleve deja existant");
                newEleve = new DaoEleve().getByCne(cneField.getText());

                Niveau niveau = new DaoNiveau().getByLibelle(niveauxBox.getValue().toString());

                //si l'eleve est deja inscrit dans cette anne universitaire on va pas ajouter l'inscription :
                if (new DaoInscription().hasAnOtherInscription(newEleve.getIdE(), Date.valueOf(dateField.getValue()).toLocalDate(), dateOuverture, dateFermeture)) {
                    //System.out.println("inscription deja existe ");

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur ! Eleve déjà existant !!!");
                    alert.setHeaderText(null);
                    alert.setContentText("Cet élève est déjà inscrit dans " + niveauxBox.getValue() + " dans le groupe : ");
                    alert.showAndWait();
                    clearFields();
                }

                //si l'eleve a valider l'annee il va passer automatiquement au prochaine niveau :
            }
        }
    }

    public void clearFields() {
        cneField.clear();
        nomField.clear();
        prenomField.clear();
        adresseField.clear();
        dateField.getEditor().clear();
    }

    public void loadGestionNotesInterface () throws IOException {
        System.out.println("ok");
        Parent rootGestionNotes = FXMLLoader.load(getClass().getResource("gestionNotes.fxml"));
        Stage stageGestionNotes = new Stage();
        Scene sceneGestionNotes = new Scene(rootGestionNotes);
        stageGestionNotes.setScene(sceneGestionNotes);
        stageGestionNotes.setTitle("Gestion des notes");
        stageGestionNotes.show();
    }

    public void refreshTable() {

        final ObservableList items = mainTable.getItems();
        if( items == null || items.size() == 0) return;

        final Object item = mainTable.getItems().get(0);
        items.remove(0);
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                items.add(0, item);
            }
        });
    }
}
