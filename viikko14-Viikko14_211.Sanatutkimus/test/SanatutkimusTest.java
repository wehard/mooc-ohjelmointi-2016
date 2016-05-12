
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;

@Points("211.1 211.2 211.3 211.4 211.5 211.6 211.7 211.8 211.9")
public class SanatutkimusTest {

    @Test
    public void eiTesteja() {
        assertTrue(1 + 1 == 2);
    }
}
