package controller;

import model.Database;
import model.Volunteer;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVolunteer extends ControllerUser{
    public ControllerVolunteer(GUI vue) {
        super(vue);
    }

    @Override
    public void addListener(JButton button){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Acceuil bénévole");
                //lance la page accueil des volunteer
                ControllerVolunteer.super.getVue().signup();
            }
        };
        button.addActionListener(listener);
    }
    @Override
    public void addUser(String name, String firstname, String mail, String password) {
        Volunteer v=new Volunteer(name,firstname,mail,password);
        Database.insertLineIntoUser(v.getId(),name,firstname,mail,password);
    }

    @Override
    public void connectUser(String mail, String password) {

    }
    public void test(){
        System.out.println("connect volunteer");
    }
}
