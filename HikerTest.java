import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class HikerTest {

    @Before
    public void setup_earth() {
        Hiker.setup();
    }
    @After
    public void destroy(){
        Hiker.tearDown();
    }
    
    @Test
    public void checkPersonNameByQuery(){
        String expected = "Austin Abro";
        String actual = Hiker.getPersonName();
        assertEquals(expected, actual);
    }
    
    @Test
    public void checkPersonNameById(){
        String expected = "Austin Abro";
        String actual = Hiker.getPersonName(1);
        assertEquals(expected, actual);
    }

}
