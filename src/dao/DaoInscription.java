package dao;

import classes.Eleve;
import classes.Groupe;
import classes.Inscription;
import classes.Niveau;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoInscription extends Dao<Inscription> {

    @Override
    public Inscription ajouter(Inscription obj) {
        Inscription inscription = null;
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO inscription VALUES(null, ?, ?, ?, ?)");
            stm.setDate(1, Date.valueOf(obj.getDate_insc()));
            stm.setString(2, "non affectee");
            stm.setInt(3, obj.getNiveau().getIdN());
            stm.setInt(4, obj.getEleve().getIdE());
            stm.executeUpdate();

            inscription = this.getByDate(obj.getDate_insc());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inscription;
    }

    @Override
    public Inscription modifier(Inscription obj) {
        Inscription inscription = null;
        DaoNiveau daoNiveau = new DaoNiveau();
        DaoEleve daoEleve = new DaoEleve();
        //Groupe lastGroupe = obj.getListeGroupesI().get(obj.getListeGroupesI().size() - 1);
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE inscription SET date_insc = ?, etat = ?, idN = ?, idE = ? WHERE idI = ?");
            stm.setDate(1, Date.valueOf(obj.getDate_insc()));
            stm.setString(2, obj.getEtat());
            stm.setInt(3, obj.getNiveau().getIdN());
            stm.setInt(4, obj.getEleve().getIdE());
            stm.setInt(5, obj.getIdI());
            stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean supprimer(int id) {
        Inscription insc = getById(id);

        if (insc != null) {
            try {
                PreparedStatement stm = connection.prepareStatement("DELETE FROM inscription WHERE idI = ?");
                stm.setInt(1, id);
                stm.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        }

        else {
            return false;
        }
    }

    @Override
    public Inscription getById(int id) {
        Inscription inscription = null;
        DaoNiveau daoNiveau = new DaoNiveau();
        DaoEleve daoEleve = new DaoEleve();
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM inscription WHERE idI = ?");
            stm.setInt(1, id);
            ResultSet resultat = stm.executeQuery();
            if (resultat.next()) {
                Niveau niveau = daoNiveau.getById(resultat.getInt("idN"));
                Eleve eleve = daoEleve.getById(resultat.getInt("idE"));
                inscription = new Inscription(resultat.getInt("idI"), resultat.getDate("date_insc").toLocalDate(), niveau, eleve);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inscription;
    }

    @Override
    public List<Inscription> getAll() {
        List<Inscription> listeInscriptions = new ArrayList<Inscription>();
        DaoNiveau daoNiveau = new DaoNiveau();
        DaoEleve daoEleve = new DaoEleve();
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM inscription");
            ResultSet resultat = stm.executeQuery();
            while (resultat.next()) {
                Niveau niveau = daoNiveau.getById(resultat.getInt("idN"));
                Eleve eleve = daoEleve.getById(resultat.getInt("idE"));
                listeInscriptions.add(new Inscription(resultat.getInt("idI"), resultat.getDate("date_insc").toLocalDate(), niveau, eleve));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeInscriptions;
    }

    @Override
    public boolean existe(Inscription obj) {
        return false;
    }

    public List<Inscription> getByAnnee(int annee) {
        List<Inscription> listeInscriptions = new ArrayList<Inscription>();
        DaoNiveau daoNiveau = new DaoNiveau();
        DaoEleve daoEleve = new DaoEleve();
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM inscription");
            ResultSet resultat = stm.executeQuery();
            while (resultat.next()) {
                if (resultat.getDate("date_insc").toLocalDate().getYear() == annee) {
                    Niveau niveau = daoNiveau.getById(resultat.getInt("idN"));
                    Eleve eleve = daoEleve.getById(resultat.getInt("idE"));
                    listeInscriptions.add(new Inscription(resultat.getInt("idI"), resultat.getDate("date_insc").toLocalDate(), niveau, eleve));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeInscriptions;
    }

    public Inscription getByDate (LocalDate date) {
        Inscription inscription = null;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM inscription WHERE date_insc = ? ORDER BY idI DESC ");
            stm.setDate(1, Date.valueOf(date));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Eleve eleve = new DaoEleve().getById(rs.getInt("idE"));
                Niveau niveau = new DaoNiveau().getById(rs.getInt("idN"));
                inscription = new Inscription(rs.getInt("idI"), rs.getDate("date_insc").toLocalDate(), niveau, eleve);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return inscription;
    }

    public Groupe autoAffectation (Inscription obj, Niveau niveau) {
        List<Groupe> listeGroupes = new ArrayList<Groupe>();
        String libelle = niveau.getLibelle();
        Groupe groupe = null;
        int nbrGroupes = 0;
        List<Inscription> listeInscriptions = this.getInscriptionOf(libelle);

        try {
            //Selection les groupes constituant le niveau donné :
            PreparedStatement stm2 = connection.prepareStatement(
                    "SELECT DISTINCT g.idG, g.libelleG, COUNT(DISTINCT g.libelleG) AS nbrGroupes FROM groupe g, niveau n, inscription i, affectation a WHERE n.libelleN = ? AND i.idN = n.idN AND i.idI = a.idI and g.idG = a.idG GROUP BY g.idG"
            );
            stm2.setString(1, libelle);
            ResultSet rs2 = stm2.executeQuery();
            while (rs2.next()) {
                listeGroupes.add(new Groupe(rs2.getInt("idG"), rs2.getString("libelleG")));
                nbrGroupes += rs2.getInt("nbrGroupes");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (listeGroupes.size() == 0) {
            groupe = new DaoGroupe().ajouter(new Groupe("groupe 11")); //créer par défaut un groupe qui s'appel groupe 1
            listeGroupes.add(groupe);
            nbrGroupes++;
        }

             if (nbrGroupes == 1) {
                 System.out.println("kkoko");
                Groupe groupe1 = listeGroupes.get(0);
                 groupe = groupe1;
                int nbrEleves = new DaoGroupe().getNbrEleves(groupe1);
                 System.out.println(nbrEleves);
                if (nbrEleves < 32) {
                    //Enregistrer l'affectation dans la base de donnée :
                    try {
                        System.out.println(nbrEleves + "eleves" + "inscription numero : " + obj.getIdI() + " et le groupe : " + groupe1.getIdG());
                        PreparedStatement stm3 = connection.prepareStatement("INSERT INTO affectation VALUES(null, ?, ?)");
                        stm3.setInt(1, obj.getIdI());
                        stm3.setInt(2, groupe1.getIdG());
                        stm3.execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                //Créer un autre groupe est reaffecter les élèves
                else {
                    System.out.println("vous avez depasser les 32 eleves");
                    //
                    //La création d'un nouveau groupe 2 :
                    Groupe groupe2 = new DaoGroupe().ajouter(new Groupe("groupe 11" + (listeGroupes.size() + 1) ));
                    listeGroupes.add(groupe2);
                    nbrGroupes++;
                    System.out.println("la creation du groupe : " + groupe2.getLibelle());
                    //selectionner toutes les inscriptions du niveau donné :
                    try {

                        for (int i = 0; i < listeInscriptions.size(); i++) {
                            System.out.println(listeInscriptions.get(i).getIdI() + "/*/");
                            if (i >= 16) {
                                PreparedStatement stm6 = connection.prepareStatement("UPDATE affectation set idG = ? WHERE idI = ?");
                                stm6.setInt(1, groupe2.getIdG());
                                stm6.setInt(2, listeInscriptions.get(i).getIdI());
                                stm6.executeUpdate();
                            }
                        }

                        //Affecter l'inscription en question :
                        PreparedStatement stm7 = connection.prepareStatement("INSERT INTO affectation VALUES(null, ?, ?)");
                        stm7.setInt(1, obj.getIdI());
                        stm7.setInt(2, groupe2.getIdG());
                        stm7.executeUpdate();
                        groupe = groupe2;

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (nbrGroupes > 1) {
                int total = 0;
                Groupe groupeMin = listeGroupes.get(0);
                for (int i = 0; i < listeGroupes.size(); i++) {
                    if (new DaoGroupe().getNbrEleves(listeGroupes.get(i)) < new DaoGroupe().getNbrEleves(groupeMin))
                        groupeMin = listeGroupes.get(i);
                    total += new DaoGroupe().getNbrEleves(listeGroupes.get(i));
                }

                if (total < 64) {
                    //affecter l'inscription dans le groupe qui a le minimum des élèves :
                    try {
                        PreparedStatement stm8 = connection.prepareStatement("INSERT INTO affectation VALUES(null, ?, ?)");
                        stm8.setInt(1, obj.getIdI());
                        stm8.setInt(2, groupeMin.getIdG());
                        stm8.executeUpdate();
                        groupe = groupeMin;
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                else {
                    int i = 1;
                    int q =0; //quotient
                    int r = 0; //reste

                    do {
                        i++;
                        q = total / i;
                        r = total % i;
                    }while (q >= 32);

                    //la valeur de i représente maintenant le nombre des groupes à créer
                    List<Groupe> listeG = new ArrayList<Groupe>();
                    //creer les nouveaux groupes :
                    for (int j = 0; j < i - listeGroupes.size(); j++) {
                        listeGroupes.add(new DaoGroupe().ajouter(new Groupe("groupe 13" + j)));
                        nbrGroupes++;
                    }
                    //il va faloire reaffecter les inscriptions maintenant :
                    int a = 0, b = total / i, p = 0;
                    Groupe g = listeGroupes.get(0);
                    for (int k = 0; k < listeInscriptions.size(); k++) {
                        if (k < b) {
                            //modifier les affectations en question :
                            try {
                                PreparedStatement stm9 = connection.prepareStatement("INSERT INTO affectation VALUES(null, ?, ?)");
                                stm9.setInt(1, obj.getIdI());
                                stm9.setInt(2, listeGroupes.get(p).getIdG());
                                stm9.executeUpdate();
                                groupe = groupeMin;
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }

                        else {
                            if (r != 0 && k == b)
                                a += b + r;
                            else
                                a += b;
                            p++;
                        }
                    }
                }
            }
        return groupe;
    }

    //sellectionner toutes les inscriptions par libelle du niveau donné :
    public List<Inscription> getInscriptionOf (String libelle) {
        List<Inscription> listeInscriptions = new ArrayList<Inscription>();
        PreparedStatement stm5 = null;
        try {
            stm5 = connection.prepareStatement("SELECT * FROM inscription i, niveau n WHERE n.idN = i.idN AND n.libelleN = ?");
            stm5.setString(1, libelle);
            ResultSet rs5 = stm5.executeQuery();
            while (rs5.next()) {
                listeInscriptions.add(new Inscription(rs5.getInt("idI"), rs5.getDate("date_insc").toLocalDate(), new DaoNiveau().getById(rs5.getInt("idN")), new DaoEleve().getById(rs5.getInt("idE"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  listeInscriptions;
    }

    public boolean hasAnOtherInscription (int idE, LocalDate date_insc, LocalDate dateOuverture, LocalDate dateFermeture) {
        boolean existe = false;
        try {
            PreparedStatement stm = connection.prepareStatement("SELECT * FROM inscription i, eleve e WHERE i.idE = e.idE AND i.date_insc >= ? AND i.date_insc <= ? AND e.idE = ?");
            stm.setDate(1, Date.valueOf(dateOuverture));
            stm.setDate(2, Date.valueOf(dateFermeture));
            stm.setInt(3, idE);
            ResultSet rs = stm.executeQuery();
            if (rs.next())
                existe = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return existe;
    }
}

