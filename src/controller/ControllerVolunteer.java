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


    public void addConnexionListener(JButton b, JTextField tsurname, JTextField tname, JTextField temail, JPasswordField tpassword){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("connect volunteer");
            }
        };
        b.addActionListener(listener);
    }
}
