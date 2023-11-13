package controller;

import model.Database;
import model.Vulnerable;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    public void test(JButton b){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("connect vulnerable");
            }
        };
        b.addActionListener(listener);
    }

}
