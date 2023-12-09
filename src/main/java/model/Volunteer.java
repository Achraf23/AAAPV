package model;

public class Volunteer extends User{

    public Volunteer(String name, String firstname, String mail, String password) {
        super(name, firstname, mail, password);
        this.type=EnumUser.Volunteer;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.type.equals(((Volunteer) obj).type);
    }

}