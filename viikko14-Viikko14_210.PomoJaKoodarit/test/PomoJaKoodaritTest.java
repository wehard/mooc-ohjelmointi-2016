
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;

@Points("210.1 210.2 210.3 210.4 210.5")
public class PomoJaKoodaritTest {

    @Test
    public void eiTesteja() {
        assertTrue(1 + 1 == 2);
    }
}
