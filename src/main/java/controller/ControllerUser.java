package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import vue.GUI;
import model.*;
import javax.swing.*;

public abstract class ControllerUser {
    Database db;
    GUI vue;
    ControllerUser(GUI vue){
        this.vue = vue;
        Database.connectToDatabase();
    }

    public GUI getVue(){
        return this.vue;
    }

    public abstract void addListener(JButton button);

    public void insertUserIntoDatabase(User u) throws IOException {
        Database.insertLineIntoUser(u.name,u.firstname,u.mail,u.getPassword());
    }

    public void addConnexionListener(JButton b, final JTextField tname, final JTextField tfirstname, final JTextField temail, final JPasswordField tpassword) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = new User(tname.getText(), tfirstname.getText(), temail.getText(), String.valueOf(tpassword.getPassword()));
                try {
                    String data = Database.associatedPassword(user.getMail());
                    if (data == null){
                        insertUserIntoDatabase(user);
                    }

                    else if (!data.equals(user.getPassword())){
                            System.out.println("erreur mauvais mdp");
                    }
                    homepage(user.getFirstname()); //lance le bon homepage en fonction du type d'user
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        b.addActionListener(listener);
    }

    public abstract void homepage(String name);
}
