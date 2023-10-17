package controller;

import model.Database;
import model.Validator;
import model.Volunteer;

public class ControllerValidator extends ControllerUser{
    @Override
    public void addUser(String name, String firstname, String mail, String password) {
        Validator v=new Validator(name,firstname,mail,password);
        Database.insertLineIntoUser(v.getId(),name,firstname,mail,password);

    }

    @Override
    public void connectUser(String mail, String password) {

    }
}
