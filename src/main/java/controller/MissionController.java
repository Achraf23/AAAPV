package controller;
import model.Mission;
import model.Database;

public class MissionController {
    Database db;

    MissionController(){
        Database.connectToDatabase();
    }

    void insertMissionIntoDatabase(Mission m){
        Database.insertLineIntoMission(m.getId(),m.getLocation(),m.getDate(),m.getDescription());

    }

}
