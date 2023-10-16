package model;

public class Mission {
    private Vulnerable vulnerable;
    private static int nbrTotalMission;
    private String location;
    private String date;
    private String description;
    private int id;
    private Volunteer volunteer;

    public Mission(Vulnerable v, String location, String date, String description) {
        this.vulnerable = v;
        this.location = location;
        this.date = date;
        this.description = description;
        this.id = nbrTotalMission++;
        this.volunteer = null;
    }
}
