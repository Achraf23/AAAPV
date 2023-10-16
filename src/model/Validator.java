package model;

public class Validator extends User{

    public Validator(String name, String firstname, String mail, String password) {
        super(name, firstname, mail, password);
    }

    public void validate(Mission m, Volunteer v) {
        //TODO : deplace mission de MissionSelected dans MissionValidated
    }

    public String refuse(Mission m, Volunteer v){
        //TODO : deplace mission de MissionSelected dans MissionValidated et retire nom du volunteer (mettre à nul)
        return "raison du refus";
    }
}