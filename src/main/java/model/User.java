package model;

import java.sql.SQLException;

public class User {
    public String name;
    public String firstname;
    private static int nbrTotalUser = 0;
    private int id;;
    public EnumUser type;
    public String mail;
    private String password;

    public User(String name, String firstname, String mail, String password) {
        this.name = name;
        this.firstname = firstname;
        this.id = nbrTotalUser++;
        this.mail = mail;
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getId() {
        return id;
    }
    public User(){

    }

    void register(User u) throws SQLException {


    }

    public void logOut(){
        //TODO : change le visuel : retourne sur ecran pricipal
    }

    /*public abstract void printLaunchScreen();
    pour vulnerable -> add mission / pour volunteer -> toutes les missions / pour validateur -> toutes les missionSelected
    */

    public String getPassword(){return password;}

    public String getMail() {
        return this.mail;
    }
}