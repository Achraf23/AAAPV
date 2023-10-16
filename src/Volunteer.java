public class Volunteer extends User{

    public Volunteer(String name, String firstname, String mail, String password) {
        super(name, firstname, mail, password);
    }

    public void selectMission(Mission m){
        //TODO : ajouter dans MissionSelected + retirer de Mission en attendant validation => si validation : deplacer mission dans table MissionValidated sinon on la remet dans mission
    }


}