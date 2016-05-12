
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;

@Points("81")
public class NumeropalveluTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testaaYhdellaNimellaEiLoydy() throws Throwable {
        io.setSysIn("123123\nAntti\n\n987\n\n");
        Numeropalvelu.main(new String[0]);
        String out = io.getSysOut();
        assertTrue("Kun numeropalveluun syötetään numerolla 123123 Antti-niminen henkilö, tulee numeroa 987 haettaessa ilmoittaa \"Tuntematon numero\".", out.contains("Tuntematon numero"));
        assertFalse("Kun numeropalveluun syötetään numerolla 123123 Antti-niminen henkilö, tulee numeroa 987 haettaessa ilmoittaa \"Tuntematon numero\".", out.contains("Soittaja on Antti"));
    }

    @Test
    public void testaaYhdellaNimellaLoytyi() throws Throwable {
        io.setSysIn("123123\nAntti\n\n123123\n\n");
        Numeropalvelu.main(new String[0]);
        String out = io.getSysOut();
        assertTrue("Kun numeropalveluun syötetään numerolla 123123 Antti-niminen henkilö, tulee numeroa 123123 haettaessa ilmoittaa \"Soittaja on Antti\".", out.contains("Soittaja on Antti"));
        assertFalse("Kun numeropalveluun syötetään numerolla 123123 Antti-niminen henkilö, tulee numeroa 123123 haettaessa ilmoittaa \"Soittaja on Antti\".", out.contains("Tuntematon numero"));
    }

    @Test
    public void testaaKolmellaNimella() throws Throwable {
        io.setSysIn("123123\nAntti\n345\nTiina\n987\nPekka\n\n123123\n987\n\n");
        Numeropalvelu.main(new String[0]);
        String out = io.getSysOut();
        assertTrue("Kun numeropalveluun syötetään numerot 123123 (Antti), 345 (Tiina) ja 987 (Pekka), tulee numeroa 123123 haettaessa ilmoittaa \"Soittaja on Antti\".", out.contains("Soittaja on Antti"));
        assertTrue("Kun numeropalveluun syötetään numerot 123123 (Antti), 345 (Tiina) ja 987 (Pekka), tulee numeroa 987 haettaessa ilmoittaa \"Soittaja on Pekka\".", out.contains("Soittaja on Pekka"));
        assertFalse("Kun numeropalveluun syötetään numerot 123123 (Antti), 345 (Tiina) ja 987 (Pekka), tulee numeroa 123 haettaessa ilmoittaa \"Tuntematon numero\".", out.contains("Tuntematon numero"));
        assertFalse("Kukaan ei etsinyt numeroa 345 puhelinluettelosta.", out.contains("Soittaja on Tiina"));
    }
}
