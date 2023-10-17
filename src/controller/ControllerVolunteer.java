package controller;

import model.Database;
import model.Volunteer;

public class ControllerVolunteer extends ControllerUser{
    @Override
    public void addUser(String name, String firstname, String mail, String password) {
        Volunteer v=new Volunteer(name,firstname,mail,password);
        Database.insertLineIntoUser(v.getId(),name,firstname,mail,password);
    }

    @Override
    public void connectUser(String mail, String password) {

    }
}
