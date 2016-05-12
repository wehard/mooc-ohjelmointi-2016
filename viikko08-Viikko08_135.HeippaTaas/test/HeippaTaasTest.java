
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("135")
public class HeippaTaasTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void tulostaaHeippaTaas() {
        HeippaTaas.main(new String[]{});

        assertEquals("Heippa taas!", io.getSysOut().trim());
    }
}
