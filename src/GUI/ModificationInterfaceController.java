package GUI;

import classes.Eleve;
import dao.DaoEleve;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mostafa ACHRAF on 1/1/2017.
 */
public class ModificationInterfaceController implements Initializable{
    public TextField textFieldCne;
    public TextField textFieldNom;
    public TextField textFieldPrenom;
    public TextField textFieldAdresse;
    public Button btnModifier;
    public Button btnAnnuler;
    ObservableList<ModificationInterface> listeInfos = ModificationInterface.listeInfos;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        textFieldCne.setText(listeInfos.get(0).getCne());
        textFieldNom.setText(listeInfos.get(0).getNom());
        textFieldPrenom.setText(listeInfos.get(0).getPrenom());
        textFieldAdresse.setText(listeInfos.get(0).getAdresse());
    }

    public void modifier (ActionEvent event) {

        //vérifier si un ou plusieurs champs sont vides :
        if (textFieldCne.getText().isEmpty() || textFieldNom.getText().isEmpty() || textFieldPrenom.getText().isEmpty() || textFieldAdresse.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ! des champs vides");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez remplir tous les champs, s'il vous plaît.");
            alert.showAndWait();
        }

        //vérifier si le cne est invalide ou non :
        boolean continuer = true;
        try {
            int cne = Integer.parseInt(textFieldCne.getText());
        }catch (Exception e) {
            Alert alert0 = new Alert(Alert.AlertType.ERROR);
            alert0.setTitle("Erreur ! CNE invalide");
            alert0.setHeaderText(null);
            alert0.setContentText("CNE INVALIDE !");
            alert0.showAndWait();
            continuer = false;
        }

        //vérifier si le nom et le prénom sont valides :
        try {
            int nom = Integer.parseInt(textFieldNom.getText());
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur ! Nom invalide");
            alert.setHeaderText(null);
            alert.setContentText("Le nom de de lélève doit être une chaine de caractères !");
            alert.showAndWait();

            int prenom = Integer.parseInt(textFieldPrenom.getText());
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur ! Prénom invalide");
            alert1.setHeaderText(null);
            alert1.setContentText("le NOM ou le PRENOM est INVALIDES !");
            alert1.showAndWait();
        }catch (Exception e) {
            continuer = true;
        }

        Eleve newEleve = new Eleve(
                listeInfos.get(0).getIdE(),
                textFieldCne.getText(),
                textFieldNom.getText(),
                textFieldPrenom.getText(),
                textFieldAdresse.getText()
        );

        //modifier les informations de l'élève :
        DaoEleve daoEleve = new DaoEleve();
        daoEleve.modifier(newEleve);

        //fermer la fenetre :
        textFieldCne.clear();
        textFieldNom.clear();
        textFieldPrenom.clear();
        textFieldAdresse.clear();
        ((Node)(event.getSource())).getScene().getWindow().hide();

        //actualiser la table principale :
        InterfaceGlobaleController.parent.loadDatabaseData();
    }

    public void close (ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
