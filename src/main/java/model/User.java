package model;

import java.sql.SQLException;

public class User {
    public String name;
    public String firstname;
    public EnumUser type = null;
    public String mail;
    private String password;
    int id;

    public User(String name, String firstname, String mail, String password) {
        this.name = name;
        this.firstname = firstname;
        this.mail = mail;
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        User u = (User) obj;
        return (this.name.equals(u.name) && this.firstname.equals(u.firstname) && this.mail.equals(u.mail) && this.password.equals(u.password));
    }

    public String getName() {
        return name;
    }

    public String getPassword(){return password;}

    public String getMail() {
        return this.mail;
    }

    public String getFirstname() {
        return this.firstname;
    }
}