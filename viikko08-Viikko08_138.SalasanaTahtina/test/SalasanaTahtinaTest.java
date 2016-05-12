
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("138")
public class SalasanaTahtinaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void tahtina1() {
        io.setSysIn("nauris!");
        SalasanaTahtina.main(new String[]{});

        String tulostus = io.getSysOut().toLowerCase();

        assertTrue("Kun käyttäjä syöttää merkkijonon 'nauris!', tulee tulostuksessa olla 7 tähteä. Nyt tulostus oli\n" + tulostus, tulostus.contains("*******"));
        assertFalse("Kun käyttäjä syöttää merkkijonon 'nauris!', tulee tulostuksessa olla 7 tähteä. Nyt tulostus oli\n" + tulostus, tulostus.contains("********"));
    }

    
    @Test
    public void tahtina2() {
        io.setSysIn("saippuakauppias");
        SalasanaTahtina.main(new String[]{});

        String tulostus = io.getSysOut().toLowerCase();

        assertTrue("Kun käyttäjä syöttää merkkijonon 'saippuakauppias', tulee tulostuksessa olla 15 tähteä. Nyt tulostus oli\n" + tulostus, tulostus.contains("***************"));
        assertFalse("Kun käyttäjä syöttää merkkijonon 'saippuakauppias', tulee tulostuksessa olla 15 tähteä. Nyt tulostus oli\n" + tulostus, tulostus.contains("****************"));
    }

    
}
