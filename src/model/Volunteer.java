package model;

public class Volunteer extends User{

    public Volunteer(String name, String firstname, String mail, String password) {
        super(name, firstname, mail, password);
        this.type=EnumUser.Volunteer;
    }

    public void selectMission(Mission m){
        //TODO : ajouter dans MissionSelected + retirer de model.Mission en attendant validation => si validation : deplacer mission dans table MissionValidated sinon on la remet dans mission
    }


}