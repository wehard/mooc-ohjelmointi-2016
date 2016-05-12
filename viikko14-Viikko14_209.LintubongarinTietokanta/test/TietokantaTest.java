
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;

@Points("209.1 209.2 209.3")
public class TietokantaTest {

    @Test
    public void eiTesteja() {
        assertTrue(1 + 1 == 2);
    }
}
