package controller;

import model.Database;

public abstract class ControllerUser {

    Database db;
    ControllerUser(){
        Database.connectToDatabase();
    }

    public abstract void addUser(String name, String firstname, String mail, String password);

    //Should use static method getUser that returns true if User present
    public abstract void connectUser(String mail, String password);


}
