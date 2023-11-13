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

    public void createUser(User u) throws IOException {
        switch (u.type){
            case Validator:
                Validator v=new Validator(u.name,u.firstname,u.mail,u.getPassword());
                break;
            case Volunteer:
                Volunteer userVolunteer=new Volunteer(u.name,u.firstname,u.mail,u.getPassword());
                break;
            case Vulnerable:
                Vulnerable userVulnerable = new Vulnerable(u.name, u.firstname, u.mail, u.getPassword());
                break;
            default:
                throw new IOException("User type not specified");

        }

        Database.insertLineIntoUser(u.getId(),u.name,u.firstname,u.mail,u.getPassword());
    }


    //Should use static method getUser that returns true if User present
    public boolean connectUser(String mail, String password){
        return Database.getUser(mail,password);
    }


    public abstract void test(JButton button);
}
