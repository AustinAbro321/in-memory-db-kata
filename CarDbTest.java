import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class CarDbTest {

    @Before
    public void setup_earth() {
        CarDb.setup();
    }
    @After
    public void destroy(){
        CarDb.tearDown();
    }
    
    @Test
    public void checkPersonNameByQuery(){
        String expected = "Austin Abro";
        String actual = CarDb.getPersonName();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkPersonNameById(){
        String expected = "Austin Abro";
        String actual = CarDb.getPersonName(1);
        assertEquals(expected, actual);
    }
    
    @Test
    public void testInsertPerson(){
        int expected = 1;
        int actual = CarDb.insertPerson(11,"Levi Ackerman","LeviAckerman@gmail.com",4);            
        assertEquals(expected, actual);
    }

}
