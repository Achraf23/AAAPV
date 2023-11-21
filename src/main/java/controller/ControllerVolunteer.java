package controller;

import model.Database;
import model.Validator;
import model.Volunteer;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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


    public void addConnexionListener(JButton b, final JTextField tname, final JTextField tfirstname, final JTextField temail, final JPasswordField tpassword) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("connect vulnerable");
                Volunteer user = new Volunteer(tname.getText(), tfirstname.getText(), temail.getText(), String.valueOf(tpassword.getPassword()));
                try {
                    ControllerVolunteer.super.insertUserIntoDatabase(user);
                    ControllerVolunteer.super.getVue().homepage_vulnerable(user.getFirstname());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        b.addActionListener(listener);
    }
}
