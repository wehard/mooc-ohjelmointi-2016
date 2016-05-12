
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.ReflectionUtils;
import java.lang.reflect.Method;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("55")
public class EnsimmainenKirjainTest {

    @Rule
    public MockStdio io = new MockStdio();
    public Method metodi;
    public String metodinNimi = "ensimmainenKirjain";

    @Test
    public void metodiOlemassa() {
        String virhe = "ohjelmassasi tulee olla metodi public static char " + metodinNimi + "(String sana)";

        try {
            metodi = ReflectionUtils.requireMethod(
                    EnsimmainenKirjain.class, metodinNimi, String.class);

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
        metodi = ReflectionUtils.requireMethod(EnsimmainenKirjain.class, metodinNimi, String.class);

        char tulos = kutsuWrap(syote, "komento ensimmainenKirjain(\"" + syote + "\");\n\n"
                + "paina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                + "\"Caused by\"\n"
                + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville");


        String oletus = syote.charAt(0) + "";
        String saatu = tulos + "";
        assertEquals(metodinNimi + " parametrilla " + syote, oletus, saatu);
    }

    @Test
    public void testi2() throws Throwable {
        String syote = "ohjelmointi";
        metodi = ReflectionUtils.requireMethod(EnsimmainenKirjain.class, metodinNimi, String.class);
        char tulos = kutsuWrap(syote, "komento ensimmainenKirjain(\"" + syote + "\");\n\n"
                + "paina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                + "\"Caused by\"\n"
                + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville");

        String oletus = syote.charAt(0) + "";
        String saatu = tulos + "";
        assertEquals(metodinNimi + " parametrilla " + syote, oletus, saatu);
    }

    @Test
    public void testi3() throws Throwable {
        String syote = "mooc-verkkokurssi";
        metodi = ReflectionUtils.requireMethod(EnsimmainenKirjain.class, metodinNimi, String.class);
        char tulos = kutsuWrap(syote, "komento ensimmainenKirjain(\"" + syote + "\");\n\n"
                + "paina nappia show backtrace, virheen syy löytyy hieman alempaa kohdasta "
                + "\"Caused by\"\n"
                + "klikkaamalla pääset suoraan virheen aiheuttaneelle koodiriville");


        String oletus = syote.charAt(0) + "";
        String saatu = tulos + "";
        assertEquals(metodinNimi + " parametrilla " + syote, oletus, saatu);
    }

    @Test
    public void mainToimii() {
        io.setSysIn("Pekka");
        EnsimmainenKirjain.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Pekka\" ohjelmasi pitäisi tulostaa Ensimmäinen kirjain: P",
                io.getSysOut().trim().endsWith("P"));

    }

    @Test
    public void mainToimii2() {
        io.setSysIn("Ohjelmointi on kivaa!!!");
        EnsimmainenKirjain.main(new String[0]);
        assertTrue("Käyttäjän syötteellä \"Ohjelmointi on kivaa!!!\" ohjelmasi pitäisi tulostaa Ensimmäinen kirjain: O",
                io.getSysOut().trim().endsWith("O"));

    }

    private char kutsuWrap(String syote, String viesti) throws Throwable {
        try {
            metodi = ReflectionUtils.requireMethod(EnsimmainenKirjain.class, metodinNimi, String.class);
            return ReflectionUtils.invokeMethod(char.class, metodi, null, syote);
        } catch (Throwable t) {
            throw new Exception(viesti, t);
        }

    }
}
