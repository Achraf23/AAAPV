import model.Database;
import model.Mission;
import model.Vulnerable;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseTest {
    final Vulnerable v= new Vulnerable("a","a","a","a");
    final Mission m =new Mission(v,"location","d","desc");

    @BeforeAll
    static void initTest(){
        Database.connectToDatabase();
    }

    @Test
    void testGetAllMissions(){
        Database.insertLineIntoUser(v.name,v.firstname,v.mail,v.getPassword(),v.type);
        Database.insertLineIntoMission(m);
        assertEquals(1,Database.getAllMissions().size());
    }



}
