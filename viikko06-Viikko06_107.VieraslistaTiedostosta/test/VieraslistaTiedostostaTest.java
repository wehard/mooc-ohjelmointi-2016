
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.ArrayList;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class VieraslistaTiedostostaTest {

    private static final String KLASS = "VieraslistaTiedostosta";

    @Test
    @Points("107")
    public void lueNimetTiedosto() throws Throwable {
        testaaLueNimet("nimet.txt", "ada", "arto", "leena", "testi");
    }

    @Test
    @Points("107")
    public void lueNimetTiedosto2() throws Throwable {
        testaaLueNimet("toiset-nimet.txt", "leo", "jarmo", "alicia");
    }

    public void testaaLueNimet(String tiedosto, String... luettavatNimet) throws Throwable {
        try {
            Reflex.reflect(KLASS).staticMethod("lueNimet").returning(ArrayList.class).taking(String.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle " + KLASS + " metodin public static ArrayList<String> lueNimet(String tiedosto)?");
        }

        ArrayList<String> nimet = new ArrayList<>();

        try {
            nimet = Reflex.reflect(KLASS).staticMethod("lueNimet").returning(ArrayList.class).taking(String.class).invoke(tiedosto);
        } catch (Throwable t) {
            Assert.fail("Metodin lueNimet kutsu epäonnistui. Virhe: " + t.getMessage());
        }

        assertNotNull("Nimien lukeminen epäonnistui. Metodi lueNimet palautti null-viitteen.", nimet);

        assertEquals("Luettavia nimiä piti olla " + luettavatNimet.length + ", nyt niitä oli " + nimet.size(), luettavatNimet.length, nimet.size());

        for (String nimi : luettavatNimet) {
            assertTrue("Kaikkia nimiä ei luettu annetusta tiedostosta.", nimet.contains(nimi));
        }
    }
}
