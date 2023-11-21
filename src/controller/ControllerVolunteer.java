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

    @Override
    public void homepage(String name) {
        System.out.println("connect volunteer");
        ControllerVolunteer.super.getVue().homepage_vulnerable(name);//TODO homepage vulnerable
    }
}
