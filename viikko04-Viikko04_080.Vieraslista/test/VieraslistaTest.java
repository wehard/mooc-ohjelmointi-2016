
import fi.helsinki.cs.tmc.edutestutils.MockInOut;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import java.util.List;
import java.util.Scanner;
import org.junit.Assert;

public class VieraslistaTest {

    @Test
    @Points("80.1")
    public void lueNimetYksi() throws Throwable {
        testaaLueNimet("Chang", "Jani", "Verna", "Pihla");
    }

    @Test
    @Points("80.1")
    public void lueNimetKaksi() throws Throwable {
        testaaLueNimet("Ilari", "Ada-Maaria", "Juha", "Jyri", "Markus", "Mikko", "Sami", "Samu", "Tuomo");
    }

    @Test
    @Points("80.2")
    public void tarkistaNimetYksi() throws Throwable {
        testaaTarkistaNimet(Arrays.asList("Jack"), Arrays.asList("Bauer"));
    }

    @Test
    @Points("80.2")
    public void tarkistaNimetKaksi() throws Throwable {
        testaaTarkistaNimet(Arrays.asList("Ilari", "Ada-Maaria", "Juha", "Jyri", "Markus", "Mikko", "Sami", "Samu", "Tuomo"), Arrays.asList("Chang", "Jani", "Verna", "Pihla"));
    }

    private void testaaLueNimet(String... luettavatNimet) throws Throwable {
        try {
            Reflex.reflect("Vieraslista").staticMethod("lueNimet").returningVoid().taking(Scanner.class, ArrayList.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle Vieraslista metodin public static void lueNimet(Scanner lukija, ArrayList<String> nimet)?");
        }

        ArrayList<String> luetut = new ArrayList<>();

        String nimet = "";
        for (String nimi : luettavatNimet) {
            nimet += nimi + "\n";
        }
        nimet += "\n";

        Scanner s = new Scanner(nimet);

        try {
            Reflex.reflect("Vieraslista").staticMethod("lueNimet").returningVoid().taking(Scanner.class, ArrayList.class).invoke(s, luetut);
        } catch (Throwable t) {
            if (t.getMessage().contains("No line found")) {
                Assert.fail("Varmistathan että nimien lukeminen lopetetaan tyhjään merkkijonoon metodissa lueNimet.");
            }
        }

        Assert.assertTrue("Kun metodia lueNimet kutsutaan, ja syötteeksi annetaan nimet:\n" + nimet + "tulee listan koon olla lukemisen jälkeen 4.", luetut.size() == luettavatNimet.length);

        for (String nimi : luettavatNimet) {
            Assert.assertTrue("Kun metodia lueNimet kutsutaan, ja syötteeksi annetaan nimet:\n" + nimet + "tulee listalla olla nimi " + nimi + ". Nyt ei ollut.", luetut.contains(nimi));

        }
    }

    private void testaaTarkistaNimet(List<String> listalla, List<String> eiListalla) throws Throwable {
        try {
            Reflex.reflect("Vieraslista").staticMethod("tarkistaNimet").returningVoid().taking(Scanner.class, ArrayList.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle Vieraslista metodin public static void tarkistaNimet(Scanner lukija, ArrayList<String> nimet)?");
        }

        ArrayList<String> luetut = new ArrayList<>();

        String nimet = "";
        for (String nimi : listalla) {
            luetut.add(nimi);
            nimet += nimi + "\n";
        }
        nimet += "\n";

        Scanner s = new Scanner(nimet);
        MockInOut mockIo = new MockInOut(nimet);
        String output = mockIo.getOutput();
        try {
            Reflex.reflect("Vieraslista").staticMethod("tarkistaNimet").returningVoid().taking(Scanner.class, ArrayList.class).invoke(s, luetut);
        } catch (Throwable t) {
            if (t.getMessage().contains("No line found")) {
                Assert.fail("Varmistathan että tarkistaminen lopetetaan kun käyttäjä syöttää tyhjän merkkijonon metodissa tarkistaNimet.");
            }
        }
        String newOutput = mockIo.getOutput().replace(output, "");

        Assert.assertFalse("Kun listalla olevia nimiä tarkistetaan, ja kaikki tarkistettavat ovat listalla, tulostuksessa ei pitäisi olla merkkijonoa \"ei ole listalla\"", newOutput.contains("ei ole listalla"));
        Assert.assertTrue("Kun listalla olevia nimiä tarkistetaan, ja kaikki tarkistettavat ovat listalla, tulostuksessa pitäisi olla merkkijono \"on listalla\"", newOutput.contains("on listalla"));

        ////    
        luetut.clear();
        nimet = "";
        for (String nimi : eiListalla) {
            nimet += nimi + "\n";
        }
        nimet += "\n";

        s = new Scanner(System.in);

        mockIo = new MockInOut(nimet);
        output = mockIo.getOutput();
        try {
            Reflex.reflect("Vieraslista").staticMethod("tarkistaNimet").returningVoid().taking(Scanner.class, ArrayList.class).invoke(s, luetut);
        } catch (Throwable t) {
            if (t.getMessage().contains("No line found")) {
                Assert.fail("Varmistathan että tarkistaminen lopetetaan kun käyttäjä syöttää tyhjän merkkijonon metodissa tarkistaNimet.");
            }
        }
        newOutput = mockIo.getOutput().replace(output, "");
        Assert.assertTrue("Kun listalla olevia nimiä tarkistetaan ja tarkistettava ei ole listalla, tulostuksessa pitäisi olla merkkijono \"ei ole listalla\"", newOutput.contains("ei ole listalla"));
        Assert.assertFalse("Kun listalla olevia nimiä tarkistetaan ja tarkistettava ei ole listalla, tulostuksessa ei pitäisi olla merkkijonoa \"on listalla\"", newOutput.contains("on listalla"));

    }

}
