
public class Vulnerable extends User{
    public Vulnerable(String name, String firstname, String mail, String password) {
        super(name, firstname, mail, password);
    }

    public void addMission(String location, String date, String description){
        Mission m = new Mission(this, location, date, description);
        //TODO (ajouter dans la bdd la mission)
    }

}