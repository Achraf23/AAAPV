package controller;

import model.Database;

public abstract class ControllerUser {

    Database db;
    ControllerUser(){
        Database.connectToDatabase();
    }

    public abstract void addUser(String name, String firstname, String mail, String password);
    public abstract void connectUser(String mail, String password);
}
