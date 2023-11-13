package controller;

import model.*;
import vue.GUI;

import javax.lang.model.type.UnknownTypeException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public abstract class ControllerUser {
    Database db;
    GUI vue;
    ControllerUser(){
        Database.connectToDatabase();
    }


    public void createUser(User u) throws IOException {
        switch (u.type){
            case Validator:
                Validator v=new Validator(u.name,u.firstname,u.mail,u.getPassword());
                break;
            case Volunteer:
                Volunteer userVolunteer=new Volunteer(u.name,u.firstname,u.mail,u.getPassword());
                break;
            case Vulnerable:
                Vulnerable userVulnerable = new Vulnerable(u.name, u.firstname, u.mail, u.getPassword());
                break;
            default:
                throw new IOException("User type not specified");

        }

        Database.insertLineIntoUser(u.getId(),u.name,u.firstname,u.mail,u.getPassword());
    }


    //Should use static method getUser that returns true if User present
    public boolean connectUser(String mail, String password){
        return Database.getUser(mail,password);
    }


}
