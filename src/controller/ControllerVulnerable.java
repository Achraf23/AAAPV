package controller;

import model.Database;
import model.Vulnerable;
import vue.GUI;
import model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControllerVulnerable extends ControllerUser{

    public ControllerVulnerable() {
        super();}

    public void addListener(JButton button){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Acceuil vulnérable");
                //lance la page accueil des vulnérables
                GUI.Registration page2 = new GUI.Registration();
            }
        };
        button.addActionListener(listener);
    }



}
