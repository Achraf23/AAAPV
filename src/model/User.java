package model;

import java.sql.SQLException;

public abstract class User {
    private String name;
    private String firstname;
    private static int nbrTotalUser = 0;
    private int id;;
    private String mail;
    private String password;

    public User(String name, String firstname, String mail, String password) {
        this.name = name;
        this.firstname = firstname;
        this.id = nbrTotalUser++;
        this.mail = mail;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    public User(){

    }

    void register(User u) throws SQLException {
        Database d= new Database();
        d.insertLineTable();


    }

    public void logOut(){
        //TODO : change le visuel : retourne sur ecran pricipal
    }

    /*public abstract void printLaunchScreen();
    pour vulnerable -> add mission / pour volunteer -> toutes les missions / pour validateur -> toutes les missionSelected
    */

}