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
                ControllerVolunteer.super.getVue().signup(ControllerVolunteer.this);
            }
        };
        button.addActionListener(listener);
    }
    @Override
    public void addUser(String name, String firstname, String mail, String password) {
        Volunteer v=new Volunteer(name,firstname,mail,password);
        Database.insertLineIntoUser(v.getId(),name,firstname,mail,password);
    }

    public void test(JButton b){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("connect volunteer");
            }
        };
        b.addActionListener(listener);
    }
}
