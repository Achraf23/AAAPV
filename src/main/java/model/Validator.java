package model;

public class Validator extends User{

    public Validator(String name, String firstname, String mail, String password) {
        super(name, firstname, mail, password);
        this.type=EnumUser.Validator;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) && this.type.equals(((Validator) obj).type);
    }

}