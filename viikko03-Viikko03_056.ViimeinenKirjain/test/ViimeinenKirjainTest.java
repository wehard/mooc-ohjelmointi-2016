
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("56")
public class ViimeinenKirjainTest {

    @Rule
    public MockStdio io = new MockStdio();
    public Method metodi;
    public String metodinNimi = "viimeinenKirjain";

    @Test
    public void metodiOlemassa() {
        String virhe = "ohjelmassasi tulee olla metodi public static char " + metodinNimi + "(String sana)";

        try {
            metodi = ReflectionUtils.requireMethod(ViimeinenKirjain.class, metodinNimi, String.class);

        } catch (Throwable e) {
            fail(virhe);
        }

        assertTrue(virhe, metodi.toString().contains("static"));
        assertTrue(virhe, char.class == metodi.getReturnType());
        assertTrue(virhe, metodi.toString().contains("public"));
    }

    @Test
    public void testi1() throws Throwable {
        String syote = "koe";
        metodi = ReflectionUtils.requireMethod(ViimeinenKirjain.class, metodinNimi, String.class);
        char tulos = kutsuWrap(syote, "komento viimeinenKirjain(\"" + syote + "\");\n\n"
                + "paina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                + "\"Caused by\"\n"
                + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville");
        String oletus = syote.charAt(syote.length() - 1) + "";
        String saatu = tulos + "";
        assertEquals(metodinNimi + " parametrilla " + syote, oletus, saatu);
    }

    @Test
    public void testi2() throws Throwable {
        String syote = "ohjelmointi";
        metodi = ReflectionUtils.requireMethod(ViimeinenKirjain.class, metodinNimi, String.class);
        char tulos = kutsuWrap(syote, "komento viimeinenKirjain(\"" + syote + "\");\n\n"
                + "paina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                + "\"Caused by\"\n"
                + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville");
        String oletus = syote.charAt(syote.length() - 1) + "";
        String saatu = tulos + "";
        assertEquals(metodinNimi + " parametrilla " + syote, oletus, saatu);
    }

    @Test
    public void testi3() throws Throwable {
        String syote = "mooc-verkkokurssi";
        metodi = ReflectionUtils.requireMethod(ViimeinenKirjain.class, metodinNimi, String.class);
        char tulos = kutsuWrap(syote, "komento viimeinenKirjain(\"" + syote + "\");\n\n"
                + "paina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                + "\"Caused by\"\n"
                + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville");
        String oletus = syote.charAt(syote.length() - 1) + "";
        String saatu = tulos + "";
        assertEquals(metodinNimi + " parametrilla " + syote, oletus, saatu);
    }

    @Test
    public void mainToimii() {
        io.setSysIn("Pekka");
        ViimeinenKirjain.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Pekka\" ohjelmasi pitäisi tulostaa Viimeinen kirjain: a", io.getSysOut().trim().endsWith("a"));

    }

    @Test
    public void mainToimii2() {
        io.setSysIn("Ohjelmointiako");
        ViimeinenKirjain.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Ohjelmointiako\" ohjelmasi pitäisi tulostaa Viimeinen kirjain: o", io.getSysOut().trim().endsWith("o"));

    }

    private char kutsuWrap(String syote, String viesti) throws Throwable {
        try {
            return kutsu(syote);
        } catch (Throwable t) {
            String file = t.getStackTrace()[1].getFileName();
            int line = t.getStackTrace()[1].getLineNumber();

            if (t.getStackTrace()[0].getFileName().contains("Kirjain")) {
                file = t.getStackTrace()[0].getFileName();
                line = t.getStackTrace()[0].getLineNumber();
            }

            throw new Exception(viesti + " aiheutti poikkeuksen " + t + " tiedostossa: " + file + " rivillä: " + line);
        }

    }

    private char kutsu(String syote) throws Throwable {
        metodi = ReflectionUtils.requireMethod(ViimeinenKirjain.class, metodinNimi, String.class);
        return ReflectionUtils.invokeMethod(char.class, metodi, null, syote);
    }
}
