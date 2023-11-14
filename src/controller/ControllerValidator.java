package controller;

import model.Database;
import model.User;
import model.Validator;
import model.Vulnerable;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControllerValidator extends ControllerUser{
    public ControllerValidator(GUI vue) {
        super(vue);
    }

    @Override
    public void addListener(final JButton button){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Acceuil validateur");
                //lance la page accueil des validator
                ControllerValidator.super.getVue().signup(ControllerValidator.this);
            }
        };
        button.addActionListener(listener);
    }



    public void addConnexionListener(JButton b, final JTextField tname, final JTextField tfirstname, final JTextField temail, final JPasswordField tpassword){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("connect vulnerable");
                Validator user = new Validator(tname.getText(), tfirstname.getText(), temail.getText(), String.valueOf(tpassword.getPassword()));
                try {
                    ControllerValidator.super.insertUserIntoDatabase(user);
                    ControllerValidator.super.getVue().homepage_vulnerable(user.getFirstname());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        b.addActionListener(listener);
    }
}

