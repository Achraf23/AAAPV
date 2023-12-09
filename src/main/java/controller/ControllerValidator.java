package controller;

import model.*;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class ControllerValidator extends ControllerUser{
    private Validator user = null;
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
    public void insertUserIntoDatabase(User u) throws IOException {
        Database.insertLineIntoUser(u.name,u.firstname,u.mail,u.getPassword(), EnumUser.Validator);
    }

    @Override
    public void homepage(User user) {
        this.user = new Validator(user.name, user.firstname, user.mail, user.getPassword());
        System.out.println("connect validator");

        ArrayList<Mission> allMissions = Database.getAllMissions();
        ArrayList<Mission> myMissions = new ArrayList<>();
        for (Mission m : allMissions){
            if (m.getVolunteer()!=null){
                myMissions.add(m);
            }
        }
        ControllerValidator.super.getVue().homepage_validator(user.firstname, myMissions);
    }
}

