package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import vue.GUI;
import model.*;
import javax.swing.*;

public abstract class ControllerUser {
    Database db;
    GUI vue;
    public ControllerUser(GUI vue){
        this.vue = vue;
        Database.connectToDatabase();
    }

    public GUI getVue(){
        return this.vue;
    }

    public abstract void addListener(JButton button);

    public abstract void insertUserIntoDatabase(User u) throws IOException;

    public void addConnexionListener(JButton b, final JTextField tname, final JTextField tfirstname, final JTextField temail, final JPasswordField tpassword) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(tname.getText(), tfirstname.getText(), temail.getText(), String.valueOf(tpassword.getPassword()));

                try {
                    String password = Database.getUserPassword(user.getMail());
                    if(password==null){
                        try {
                            insertUserIntoDatabase(user);
                            homepage(user); //lance le bon homepage en fonction du type d'user
                        }catch (IOException ex){
                            System.out.println("Mail already taken");
                            throw new RuntimeException(ex);
                        }
                    }else{
                        if(password.equals(user.getPassword())){
                            homepage(user); //lance le bon homepage en fonction du type d'user
                        }else{
                            System.out.println("erreur mauvais mdp");
                            getVue().errorPassword();
                        }
                    }

                }catch (SQLException s){
                    //No mail matching ==> create User
                    System.out.println("Query exception");
                    throw new RuntimeException();

                }

            }
        };
        b.addActionListener(listener);
    }

    public abstract void homepage(User u);
}
