package dao;

import classes.Eleve;
import classes.Niveau;
import classes.Paiement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mostafa ACHRAF on 12/30/2016.
 */
public class DaoPaiement extends Dao<Paiement> {
    @Override
    public Paiement ajouter(Paiement obj) {
        return null;
    }

    @Override
    public Paiement modifier(Paiement obj) {
        return null;
    }

    @Override
    public boolean supprimer(int id) {
        return false;
    }

    @Override
    public Paiement getById(int id) {
        return null;
    }

    @Override
    public List<Paiement> getAll() {
        return null;
    }

    @Override
    public boolean existe(Paiement obj) {
        return false;
    }

    public List<Paiement> getAllByMode_paiement (String mode, int mois, int annee) {
        List<Paiement> listePaiments = new ArrayList<>();
        DaoEleve daoEleve = new DaoEleve();
        DaoNiveau daoNiveau = new DaoNiveau();
        Eleve eleve = null;
        Niveau niveau = null;

        try {
            PreparedStatement stm = connection.prepareStatement(
                    "SELECT * FROM paiment WHERE mode = ? AND mois = ? AND annee = ?"
            );
            stm.setString(1, mode);
            stm.setInt(2, mois);
            stm.setInt(3, annee);
            ResultSet rs =  stm.executeQuery();
            while (rs.next()) {
                eleve = daoEleve.getById(rs.getInt("idE"));
                niveau = daoNiveau.getById(rs.getInt("idN"));
                listePaiments.add(new Paiement(rs.getInt("idP"), rs.getString("mode"), rs.getDouble("montant"), rs.getInt("mois"), rs.getInt("annee"), eleve, niveau));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listePaiments;
    }
}
