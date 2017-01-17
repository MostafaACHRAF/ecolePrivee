package classes;

/**
 * Created by Mostafa ACHRAF on 12/7/2016.
 */
public class User {

    //Attributs :
    private int idU;
    private String login;
    private String password;

    //Constructeurs :
    public User (int idU, String login, String password) {
        this(login, password);
        this.setIdU(idU);
    }

    public User (String login, String password) {
        this.setLogin(login);
        this.setPassword(password);
    }

    //GETTERS :
    public int getIdU() { return this.idU; }
    public String getLogin() { return this.login; }
    public String getPassword() {return this.password; }

    //setters /
    public void setIdU (int idU) { this.idU = idU; }
    public void setLogin (String login) { this.login = login; }
    public void setPassword (String password) { this.password = password; }

    @Override
    public String toString() {
        return "{" + this.login + "}{" + this.password + "}";
    }
}
