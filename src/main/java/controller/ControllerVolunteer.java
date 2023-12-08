package controller;

import model.*;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ControllerVolunteer extends ControllerUser{
    private Volunteer user = null;
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
    public void insertUserIntoDatabase(User u) throws IOException {
        Database.insertLineIntoUser(u.name,u.firstname,u.mail,u.getPassword(), EnumUser.Volunteer);
    }

    public Volunteer getUser(){
        return this.user;
    }
    @Override
    public void homepage(User user) {
        this.user = new Volunteer(user.name, user.firstname, user.mail, user.getPassword());
        System.out.println("connect volunteer");
        ControllerVolunteer.super.getVue().homepage_volunteer(user.name);
    }
}
