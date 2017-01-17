package GUI;

import classes.User;
import dao.DaoUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

import java.io.IOException;

public class AuthentificationController {
    public ToggleButton btn_connecter;
    public ToggleButton btn_annuler;
    public TextField textField_username;
    public TextField textField_password;
    public Label label;

    DaoUser daoUser = new DaoUser();

    public void authentification(ActionEvent event) throws IOException {
        if (event.getSource() == btn_connecter) {
            if (textField_password.getText().equals("") && textField_password.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur ! Champs vides");
                alert.setHeaderText(null);
                alert.setContentText("Erreur ! Veuillez remplir tous les champs");
                alert.showAndWait();
                textField_username.clear();
                textField_password.clear();
            }
                //label.setText("Erreur !!! Tous les champs sont obligatoires !");

            else {
                User user = daoUser.seConnecter(textField_username.getText(), textField_password.getText());
                if (user == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Erreur ! Données invalides");
                    alert.setHeaderText(null);
                    alert.setContentText("Erreur ! Le mot de passe ou le login est invalides");
                    alert.showAndWait();
                    textField_username.clear();
                    textField_password.clear();
                    //label.setText("Erreur le mot de passe ou login est invalide !");
                }

                else {
                    //System.out.println("bienvenu vous ete connecté :) ");
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    Parent rootHome = FXMLLoader.load(getClass().getResource("interfaceGlobale.fxml"));
                    Stage stageHome = new Stage();
                    Scene sceneHome = new Scene(rootHome);
                    stageHome.setScene(sceneHome);
                    stageHome.setTitle("Bienvenu sur l'accueil");
                    stageHome.show();
                }
            }
        }
        else
            daoUser.seDeconnecter();
    }
}
