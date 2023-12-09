package controller;

import model.*;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerVulnerable extends ControllerUser{

    private Vulnerable user = null;

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

    public void addMissionCreationListener(final JButton b, final JTextField tlocation, final JTextField tdate, final JTextField tdescription) {
        final ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("création mission");
                Mission m = new Mission(getUser(), tlocation.getText(), tdate.getText(), tdescription.getText());
                Database.insertLineIntoMission(m);
            }
        };
        b.addActionListener(listener);
    }

    public void addPrintMissionListener(final JButton b) {
        final ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Mission> allMissions = Database.getAllMissions();
                ArrayList<Mission> myMissions = new ArrayList<>();
                for (Mission m : allMissions){
                    if (m.getVulnerable().equals(getUser())){
                        myMissions.add(m);
                    }
                }
                System.out.println(myMissions);
                getVue().mission_vulnerable(myMissions);
            }
        };
        b.addActionListener(listener);
    }

    public void addOpenHelpListener(final JButton b) {
        final ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("accueil demande aide");
                getVue().askForHelp(ControllerVulnerable.this);
            }
        };
        b.addActionListener(listener);
    }

    @Override
    public void insertUserIntoDatabase(User u) throws IOException {
        Database.insertLineIntoUser(u.name,u.firstname,u.mail,u.getPassword(), EnumUser.Vulnerable);
    }

    public Vulnerable getUser(){
        return this.user;
    }
    @Override
    public void homepage(User user) {
        System.out.println("connect vulnerable");
        this.user = new Vulnerable(user.name, user.firstname, user.mail, user.getPassword());
        ControllerVulnerable.super.getVue().homepage_vulnerable(user.firstname, ControllerVulnerable.this);
    }
}
