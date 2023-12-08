package controller;
import model.Mission;
import model.Database;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class MissionController {
    Database db;

    MissionController(){
        Database.connectToDatabase();
    }

    public void insertMissionIntoDatabase(Mission m){
        Database.insertLineIntoMission(m);
    }

    public ArrayList<Mission> getMissions(){
        return Database.getAllMissions();
    }

}
