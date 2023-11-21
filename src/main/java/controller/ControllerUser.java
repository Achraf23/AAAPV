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
        Database.insertLineIntoUser(u.getId(),u.name,u.firstname,u.mail,u.getPassword());
    }


    //Should use static method getUser that returns true if User present
    public boolean connectUser(String mail, String password){
        return Database.getUser(mail,password);
    }


    public void addConnexionListener(JButton b, final JTextField tname, final JTextField tfirstname, final JTextField temail, final JPasswordField tpassword) {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Volunteer user = new Volunteer(tname.getText(), tfirstname.getText(), temail.getText(), String.valueOf(tpassword.getPassword()));
                try {

                    insertUserIntoDatabase(user);
                    homepage(user.getFirstname());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        };
        b.addActionListener(listener);
    }

    public abstract void homepage(String name);
}
