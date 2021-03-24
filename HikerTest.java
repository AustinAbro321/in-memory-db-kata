import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

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
    public void checkCarName(){
        String expected = "Jeep Cherokee";
        String actual = Hiker.getCarName();
        assertEquals(expected, actual);
    }
        
    @Test
    public void checkEmailsWithoutNull(){
        List<String> expected = new ArrayList<String>();
        expected.add("Austin.Abro@stellantis.com");
        expected.add("Chris.Gallivan@stellantis.com");
        List<String> actual = Hiker.getListOfEmails();
        Assert.assertEquals(expected,actual);
    }

}
