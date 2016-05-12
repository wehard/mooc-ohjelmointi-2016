
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.ArrayList;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DesibelimittauksetTiedostostaTest {

    private static final String KLASS = "DesibelimittauksetTiedostosta";
    private static final String PTS = "108";

    @Test
    @Points(PTS)
    public void lueLuvutMetodiOlemassa() throws Throwable {
        try {
            Reflex.reflect(KLASS).staticMethod("lueLuvut").returning(ArrayList.class).taking(String.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle " + KLASS + " metodin public static ArrayList<Integer> lueLuvut(String tiedosto)?");
        }
    }

    @Test
    @Points(PTS)
    public void lueLuvutTiedosto() throws Throwable {
        testaaLueLuvut("mittaukset-1.txt", 300, 9, 20, 15);
    }

    @Test
    @Points(PTS)
    public void lueLuvutTiedosto2() throws Throwable {
        testaaLueLuvut("mittaukset-2.txt", 123, -5, 12, 67, -300, 1902);
    }

    public void testaaLueLuvut(String tiedosto, int... luvut) throws Throwable {
        try {
            Reflex.reflect(KLASS).staticMethod("lueLuvut").returning(ArrayList.class).taking(String.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle " + KLASS + " metodin public static ArrayList<Integer> lueNimet(String tiedosto)?");
        }

        ArrayList<Integer> lukulista = new ArrayList<>();

        try {
            lukulista = Reflex.reflect(KLASS).staticMethod("lueLuvut").returning(ArrayList.class).taking(String.class).invoke(tiedosto);
        } catch (Throwable t) {
            Assert.fail("Metodin lueLuvut kutsu epäonnistui. Virhe: " + t.getMessage());
        }

        assertNotNull("Lukujen lukeminen epäonnistui. Metodi lueLuvut palautti null-viitteen.", lukulista);

        assertEquals("Luettavia lukuja piti olla " + luvut.length + ", nyt niitä oli " + lukulista.size(), luvut.length, lukulista.size());

        for (int luku : luvut) {
            assertTrue("Kaikkia lukuja ei luettu annetusta tiedostosta.", lukulista.contains(luku));
        }
    }

}
