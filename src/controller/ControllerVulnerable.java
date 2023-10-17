package controller;

import model.Database;
import model.Vulnerable;

public class ControllerVulnerable extends ControllerUser{
    @Override
    public void addUser(String name, String firstname, String mail, String password) {
        Vulnerable v = new Vulnerable(name, firstname, mail, password);
        Database.insertLineIntoUser(v.getId(),name,firstname,mail,password);


        //ajouter à la table

    }

    @Override
    public void connectUser(String mail, String password) {

    }
}
