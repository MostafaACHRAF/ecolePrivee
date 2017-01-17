package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Authentification.fxml"));
        primaryStage.setTitle("Authentification");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        //DaoEleve daoEleve = new DaoEleve();
    }

    public static void main(String[] args) {
        launch(args);
        /*DaoPaiement daoPaiement = new DaoPaiement();
        List<Paiement> listePaiments = daoPaiement.getAllByMode_paiement("cheque", 12, 2016);

        for (Paiement listePaiment : listePaiments)
            System.out.println(
                    listePaiment.getMode() + " " + listePaiment.getAnnee() + " " + listePaiment.getMois() + " " + listePaiment.getMontant() +  " " + listePaiment.getEleve().getNom() + " " + listePaiment.getEleve().getPrenom() + " " + listePaiment.getNiveau().getLibelleN());*/
    }
}
