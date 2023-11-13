package controller;

import model.Database;
import model.Validator;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                ControllerValidator.super.getVue().signup();
            }
        };
        button.addActionListener(listener);
    }
    @Override
    public void addUser(String name, String firstname, String mail, String password) {
        Validator v=new Validator(name,firstname,mail,password);
        Database.insertLineIntoUser(v.getId(),name,firstname,mail,password);

    }


    public void test(JButton b){
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("connect validator");
            }
        };
        b.addActionListener(listener);
    }
}
