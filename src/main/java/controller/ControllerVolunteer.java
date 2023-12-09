package controller;

import model.*;
import vue.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

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

    public void addMissionSelectionListener(final JButton b, final int index) {
        final ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("selection mission");
                ArrayList<Mission> allMissions = Database.getAllMissions();
                Mission m = allMissions.get(index);
                m.setVolunteer(getUser());
                System.out.println("selected mission's volunteer : "+m.getVolunteer());
                Database.updateMission(m);
            }
        };
        b.addActionListener(listener);
    }

    public void addPrintMissionListener(final JButton b) {
        final ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Mission> allMissions = Database.getAllMissions();
                System.out.println(allMissions);
                ArrayList<Mission> myMissions = new ArrayList<>();
                for (Mission m : allMissions){
                    System.out.println("mission's volunteer : "+m.getVolunteer()+" and user : "+getUser());
                    if (m.getVolunteer() != null && m.getVolunteer().equals(getUser())){
                        myMissions.add(m);
                    }
                }
                System.out.println("my missions : "+myMissions);
                getVue().mission_volunteer(myMissions);
                System.out.println(myMissions);
            }
        };
        b.addActionListener(listener);
    }


    @Override
    public void homepage(User user) {
        this.user = new Volunteer(user.name, user.firstname, user.mail, user.getPassword());
        System.out.println("connect volunteer");

        ArrayList<Mission> allMissions = Database.getAllMissions();
        System.out.println(allMissions);
        ArrayList<Mission> emptyMissions = new ArrayList<>();
        for (Mission m : allMissions){
            if (m.getVolunteer()==null){
                emptyMissions.add(m);
            }
        }
        ControllerVolunteer.super.getVue().homepage_volunteer(user.firstname, emptyMissions,ControllerVolunteer.this);
    }
}
