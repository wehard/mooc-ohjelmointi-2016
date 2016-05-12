
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.Test;

@Points("13")
public class JakajaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void testJakaja() {
        jakajaTest(3, 2);
    }

    @Test
    public void testTulostusEiKovakoodattu() {
        ReflectionUtils.newInstanceOfClass(Jakaja.class);
        io.setSysIn("9\n4\n");
        Jakaja.main(new String[0]);

        String out = io.getSysOut();
        assertTrue("Syötteellä 9 ja 4, ohjelman pitäisi tulostaa laskuoperaatio eli \"9 / 4\". Tulostus oli\n" + out, out.contains("9 / 4") || out.contains("9/4"));
//        jakajaTest(9, 4);
    }

    @Test
    public void testJokuKivaTest() {
        jakajaTest(9, 4);
    }

    @Test
    public void testJakajaNegatiivisella() {
        jakajaTest(3, -2);
    }

    @Test
    public void testJakajaRajoittamattomallaLopulla() {
        jakajaTest(10, 3);
    }

    private void jakajaTest(int ekaLuku, int tokaLuku) {
        ReflectionUtils.newInstanceOfClass(Jakaja.class);
        io.setSysIn(ekaLuku + "\n" + tokaLuku + "\n");
        Jakaja.main(new String[0]);

        String out = io.getSysOut();

        assertTrue("Ohjelmasi ei tulostanut mitään! Sinun piti tulostaa kysymys!", out.trim().length() > 0);

        assertTrue("Tulosteessasi pitäisi olla teksti \"Jakolasku\", nyt ei ollut. Tulosteesi oli: " + out,
                out.contains("akolasku"));

        String jakoMjono = out.substring(out.indexOf("akolasku") + "akolasku".length());
        while(jakoMjono.length() > 0 && !Character.isDigit(jakoMjono.charAt(0))) {
            jakoMjono = jakoMjono.substring(1);
        }

        Matcher m = Pattern.compile("(?s)\\s*?([-.0-9]+)\\s*/\\s*([-.0-9]+)\\s*=\\s*([-.0-9]+)\\s*").matcher(jakoMjono);

        assertTrue("Tulosteesi tulee olla muotoa 'X / Y = Z' jollain numeroilla X, Y ja Z. Nyt se oli: " + jakoMjono,
                m.matches());

        String sa = m.group(1).trim();
        String sb = m.group(2).trim();
        String sc = m.group(3).trim();

        double a, b, c;

        try {
            a = Double.parseDouble(sa);
        } catch (NumberFormatException e) {
            fail("Tulosteessasi ollut merkkijono \"" + sa + "\" ei ole käypä numero!");
            return; // tyhmä java
        }

        try {
            b = Double.parseDouble(sb);
        } catch (NumberFormatException e) {
            fail("Tulosteessasi ollut merkkijono \"" + sb + "\" ei ole käypä numero!");
            return; // tyhmä java
        }

        try {
            c = Double.parseDouble(sc);
        } catch (NumberFormatException e) {
            fail("Tulosteessasi ollut merkkijono \"" + sc + "\" ei ole käypä numero!");
            return; // tyhmä java
        }

        double tulos = 1.0 * a / b;
        assertEquals("Laskun " + a + " / " + b + " tuloksen pitäisi olla "
                + tulos + ", ehdotit että se on: " + c + "\nMuistitko käyttää doubleja?", tulos, c, 0.001);
    }
}
