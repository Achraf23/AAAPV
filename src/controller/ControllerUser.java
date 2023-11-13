package controller;

import model.Database;
import vue.GUI;

import javax.swing.*;

public abstract class ControllerUser {
    Database db;
    GUI vue;
    ControllerUser(GUI vue){
        this.vue = vue;
        Database.connectToDatabase();
    }

    public GUI getVue(){
        return this.vue;
    }

    public abstract void addListener(JButton button);

    public abstract void addUser(String name, String firstname, String mail, String password);

    //Should use static method getUser that returns true if User present
    public boolean connectUser(String mail, String password){
        return Database.getUser(mail,password);
    }


    public abstract void test(JButton button);
}
