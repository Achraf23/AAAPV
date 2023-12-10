import model.Database;
import model.Mission;
import model.Vulnerable;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {
    final Vulnerable v1= new Vulnerable("a","a","a","a");
    final Mission m1 =new Mission(v1,"location","d","desc");

    final Vulnerable v2 = new Vulnerable("b","b","b","b");
    final Mission m2 = new Mission(v2,"location","date","desc");
    static boolean connected=false;

    @BeforeAll
    static void initTest(){
        connected=Database.connectToDatabase();
        if(connected){
            Database.deleteMissions();
            Database.deleteUsers();
        }

    }


    @Test
    void testAddUser(){
        if(connected)
            assertEquals(true,
                    Database.insertLineIntoUser(v1.name,v1.firstname,v1.mail,v1.getPassword(),v1.type));

    }

    @Test
    void testAddMission(){
        if(connected)
            assertEquals(true,Database.insertLineIntoMission(m2));
    }

    @Test
    void testGetAllMissions(){
        if(connected){
            Database.insertLineIntoUser(v1.name,v1.firstname,v1.mail,v1.getPassword(),v1.type);
            Database.insertLineIntoMission(m1);
            assertEquals(1,Database.getAllMissions().size());
        }

    }

    @AfterAll
    static void clearTables(){
        if(connected){
            Database.deleteUsers();
            Database.deleteMissions();
        }
    }



}
