package controller;

import model.Database;
import model.Volunteer;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVolunteer extends ControllerUser{
    public ControllerVolunteer() {
        super();
    }


    public void addListener(JButton button){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Acceuil bénévole");
                //lance la page accueil des volunteer
                GUI.Registration page2 = new GUI.Registration();
            }
        };
        button.addActionListener(listener);
    }


}
