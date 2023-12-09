package controller;
import model.Mission;
import model.Database;
import vue.GUI;
//TODO : inutile pour le moment
import java.util.ArrayList;

public abstract class ControllerMission {
    Database db;
    GUI vue;

    public ControllerMission(GUI vue){
        this.vue = vue;
        Database.connectToDatabase();
    }

    public GUI getVue(){
        return this.vue;
    }

    void insertMissionIntoDatabase(Mission m){
        Database.insertLineIntoMission(m);
    }

    ArrayList<Mission> getAllMissions(){
        return Database.getAllMissions();
    }



}
