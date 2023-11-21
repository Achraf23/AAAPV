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



    @Override
    public void homepage(String name) {
        System.out.println("connect validator");
        ControllerValidator.super.getVue().homepage_vulnerable(name); //TODO homepage vulnerable
    }
}
