package controller;
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


    public abstract void addConnexionListener(JButton button, JTextField tsurname, JTextField tname, JTextField temail, JPasswordField tpassword);
}
