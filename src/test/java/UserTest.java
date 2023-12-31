import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    static void testCreateUser(){
        Vulnerable vulnerable = new Vulnerable("b", "b", "b", "b");
        Volunteer volunteer = new Volunteer("c", "c", "c", "c");
        Validator validator = new Validator("d", "d", "d", "d");

        assertEquals(EnumUser.Volunteer, volunteer.type);
        assertEquals(EnumUser.Validator, validator.type);
        assertEquals(EnumUser.Vulnerable, vulnerable.type);
    }

    @Test
    void testIsEqual(){
        User u1 = new User("b", "b", "b", "b");
        User u2 = new User("b", "b", "b", "b");
        User u3 = new User("e", "b", "b", "b");
        assertEquals(true, u1.equals(u2));
        assertEquals(false, u1.equals(u3));

        Vulnerable vul1 = new Vulnerable("b", "b", "b", "b");
        Vulnerable vul2 = new Vulnerable("b", "b", "b", "b");
        Vulnerable vul3 = new Vulnerable("e", "b", "b", "b");

        assertEquals(true, vul1.equals(vul2));
        assertEquals(false, vul1.equals(vul3));

        Volunteer vol1 = new Volunteer("b", "b", "b", "b");

        assertEquals(true, vol1.type!=vul1.type);
    }


}
