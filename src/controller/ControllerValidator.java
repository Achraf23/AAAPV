package controller;

import model.Database;
import model.Validator;
import model.Volunteer;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerValidator extends ControllerUser{
    public ControllerValidator() {
        super();
    }

    public void addListener(JButton button){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Acceuil validateur");
                //lance la page accueil des validator
                GUI.Registration page2 = new GUI.Registration();
            }
        };
        button.addActionListener(listener);
    }
    @Override
    public void addUser(String name, String firstname, String mail, String password) {
        Validator v=new Validator(name,firstname,mail,password);
        Database.insertLineIntoUser(v.getId(),name,firstname,mail,password);

    }

    @Override
    public void connectUser(String mail, String password) {

    }
}
