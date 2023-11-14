package controller;

import model.Database;
import model.Vulnerable;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControllerVulnerable extends ControllerUser{

    public ControllerVulnerable(GUI vue) {
        super(vue);}

    @Override
    public void addListener(JButton button){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Acceuil vulnérable");
                //lance la page accueil des vulnérables
                ControllerVulnerable.super.getVue().signup(ControllerVulnerable.this);
            }
        };
        button.addActionListener(listener);
    }
    public void addConnexionListener(JButton b, final JTextField tname, final JTextField tfirstname, final JTextField temail, final JPasswordField tpassword){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("connect vulnerable");
                Vulnerable user = new Vulnerable(tname.getText(), tfirstname.getText(), temail.getText(), String.valueOf(tpassword.getPassword()));
                try {
                    ControllerVulnerable.super.insertUserIntoDatabase(user);
                    ControllerVulnerable.super.homepage_vulnerable(user.getFirstname());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        b.addActionListener(listener);
    }

}
