package controller;

import model.Database;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ControllerUser {

    Database db;
    GUI vue;
    ControllerUser(){
        Database.connectToDatabase();
    }


    public abstract void addUser(String name, String firstname, String mail, String password);

    //Should use static method getUser that returns true if User present
    public abstract void connectUser(String mail, String password);


}
