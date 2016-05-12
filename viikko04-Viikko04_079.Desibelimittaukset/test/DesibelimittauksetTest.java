
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.Test;
import java.util.Random;
import java.util.Scanner;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DesibelimittauksetTest {

    @Test
    @Points("79.1")
    public void lueLuvutMetodiOlemassa() throws Throwable {
        try {
            Reflex.reflect("Desibelimittaukset").staticMethod("lueLuvut").returningVoid().taking(Scanner.class, ArrayList.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle Desibelimittaukset metodin public static void lueLuvut(Scanner lukija, ArrayList<Integer> luvut)?");
        }
    }

    @Test
    @Points("79.1")
    public void lueKolmeLukua() throws Throwable {
        testaaLueLuvut(1, 5, 8);
    }

    @Test
    @Points("79.1")
    public void lueViisiLukua() throws Throwable {
        testaaLueLuvut(Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE);
    }

    @Test
    @Points("79.2")
    public void valitseLuvutValiltaMetodiOlemassa() throws Throwable {
        try {
            Reflex.reflect("Desibelimittaukset").staticMethod("valitseLuvutValilta").returning(ArrayList.class).taking(ArrayList.class, int.class, int.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle Desibelimittaukset metodin public static ArrayList<Integer> valitseLuvutValilta(ArrayList<Integer> luvut, int pienin, int suurin)?");
        }
    }

    @Test
    @Points("79.2")
    public void valitseLuvutValiltaMetodiEiMuutaAlkuperaistaListaa() throws Throwable {
        ArrayList<Integer> luvut = new ArrayList<>();
        ArrayList<Integer> luvutAlkup = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int luku = rnd.nextInt();
            luvut.add(luku);
            luvutAlkup.add(luku);
        }

        kutsuValitseLuvutValilta(luvut, -1, 1);
        assertEquals("Metodin valitseLuvutValilta ei tule muokata sille parametrina annetun listan sisältöä.\nPalauta metodista uusi lista johon annettuun väliin sopivat luvut on valittu.", luvut, luvutAlkup);
    }

    @Test
    @Points("79.2")
    public void valitseLuvutValiltaPalauttaaValillaOlevatLuvut() throws Throwable {
        ArrayList<Integer> luvut = new ArrayList<>();
        Collections.addAll(luvut, 1, 2, 3, 4, 5);

        ArrayList<Integer> palautetutLuvut = kutsuValitseLuvutValilta(luvut, 0, 6);

        assertTrue("Kun metodille valitseLuvutValilta annetussa listassa on viisi lukua, ja kaikki luvut tulee valita listalle, tulee palautettavassa listassa olla myös viisi lukua.", palautetutLuvut.size() == 5);
        Collections.sort(luvut);
        Collections.sort(palautetutLuvut);
        assertEquals("Jos metodi valitseLuvutValilta valitsee kaikki luvut palautettavalle listalle, tulee valittujen lukujen olla samat kuin parametrina annetussa listassa. Nyt näin ei ollut.", luvut, palautetutLuvut);
    }

    @Test
    @Points("79.2")
    public void valitseLuvutValiltaSisallyttaaAlarajan() throws Throwable {
        ArrayList<Integer> luvut = new ArrayList<>();
        Collections.addAll(luvut, 1, 2);

        ArrayList<Integer> palautetutLuvut = kutsuValitseLuvutValilta(luvut, 1, 3);

        assertTrue("Kun metodille valitseLuvutValilta annetussa listassa on luvut 1 ja 2, ja metodia pyydetään valitsemaan listalta luvut siten, että pienin valittava on 1 ja suurin valittava on 3, tulee sekä luku 1 että 2 olla palautettavassa listassa.", palautetutLuvut.size() == 2);
        Collections.sort(luvut);
        Collections.sort(palautetutLuvut);
        assertEquals("Jos metodi valitseLuvutValilta valitsee kaikki luvut palautettavalle listalle, tulee valittujen lukujen olla samat kuin parametrina annetussa listassa. Nyt näin ei ollut.", luvut, palautetutLuvut);
    }

    @Test
    @Points("79.2")
    public void valitseLuvutValiltaSisallyttaaYlarajan() throws Throwable {
        ArrayList<Integer> luvut = new ArrayList<>();
        Collections.addAll(luvut, 1, 2);

        ArrayList<Integer> palautetutLuvut = kutsuValitseLuvutValilta(luvut, 0, 2);

        assertTrue("Kun metodille valitseLuvutValilta annetussa listassa on luvut 1 ja 2, ja metodia pyydetään valitsemaan listalta luvut siten, että pienin valittava on 0 ja suurin valittava on 2, tulee sekä luku 1 että 2 olla palautettavassa listassa.", palautetutLuvut.size() == 2);
        Collections.sort(luvut);
        Collections.sort(palautetutLuvut);
        assertEquals("Jos metodi valitseLuvutValilta valitsee kaikki luvut palautettavalle listalle, tulee valittujen lukujen olla samat kuin parametrina annetussa listassa. Nyt näin ei ollut.", luvut, palautetutLuvut);
    }

    @Test
    @Points("79.2")
    public void valitseLuvutValiltaSisallyttaaAlaJaYlarajan() throws Throwable {
        ArrayList<Integer> luvut = new ArrayList<>();
        Collections.addAll(luvut, 1, 2);

        ArrayList<Integer> palautetutLuvut = kutsuValitseLuvutValilta(luvut, 1, 2);

        assertTrue("Kun metodille valitseLuvutValilta annetussa listassa on luvut 1 ja 2, ja metodia pyydetään valitsemaan listalta luvut siten, että pienin valittava on 1 ja suurin valittava on 2, tulee sekä luku 1 että 2 olla palautettavassa listassa.", palautetutLuvut.size() == 2);
        Collections.sort(luvut);
        Collections.sort(palautetutLuvut);
        assertEquals("Jos metodi valitseLuvutValilta valitsee kaikki luvut palautettavalle listalle, tulee valittujen lukujen olla samat kuin parametrina annetussa listassa. Nyt näin ei ollut.", luvut, palautetutLuvut);
    }

    @Test
    @Points("79.2")
    public void valitseLuvutValiltaValitseeAlkiotListalta() throws Throwable {
        ArrayList<Integer> luvut = new ArrayList<>();
        Collections.addAll(luvut, -10, 11, 8, 62, 4);

        ArrayList<Integer> palautetutLuvut = kutsuValitseLuvutValilta(luvut, 0, 25);

        assertTrue("Kun metodille valitseLuvutValilta annetussa listassa on luvut -10, 11, 8, 62 ja 4, ja metodia pyydetään valitsemaan listalta luvut siten, että pienin valittava on 0 ja suurin valittava on 25, tulee palautettavassa listassa olla kolme lukua.", palautetutLuvut.size() == 3);
        assertTrue("Kun metodille valitseLuvutValilta annetussa listassa on luvut -10, 11, 8, 62 ja 4, ja metodia pyydetään valitsemaan listalta luvut siten, että pienin valittava on 0 ja suurin valittava on 25, tulee palautettavassa listassa olla luku 4.", palautetutLuvut.contains(4));
        assertTrue("Kun metodille valitseLuvutValilta annetussa listassa on luvut -10, 11, 8, 62 ja 4, ja metodia pyydetään valitsemaan listalta luvut siten, että pienin valittava on 0 ja suurin valittava on 25, tulee palautettavassa listassa olla luku 8.", palautetutLuvut.contains(8));
        assertTrue("Kun metodille valitseLuvutValilta annetussa listassa on luvut -10, 11, 8, 62 ja 4, ja metodia pyydetään valitsemaan listalta luvut siten, että pienin valittava on 0 ja suurin valittava on 25, tulee palautettavassa listassa olla luku 11.", palautetutLuvut.contains(11));
    }

    @Test
    @Points("79.3")
    public void keskiarvoMetodiOlemassa() throws Throwable {
        try {
            Reflex.reflect("Desibelimittaukset").staticMethod("keskiarvo").returning(double.class).taking(ArrayList.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle Desibelimittaukset metodin public static double keskiarvo(ArrayList<Integer> luvut)?");
        }
    }

    @Test
    @Points("79.3")
    public void kolmenLuvunKeskiarvo() throws Throwable {
        testaaKeskiarvo(-5, 0, 5);
    }

    @Test
    @Points("79.3")
    public void viidenLuvunKeskiarvo() throws Throwable {
        testaaKeskiarvo(31, 3, 118, 32, 44);
    }

    
    @Test
    @Points("79.3")
    public void satunnaistenLukujenKeskiarvo() throws Throwable {
        Integer[] luvut = new Integer[10];
        for (int i = 0; i < luvut.length; i++) {
            luvut[i] = new Random().nextInt(100);
        }
        
        testaaKeskiarvo(luvut);
    }

    
    private void testaaKeskiarvo(Integer... luvut) throws Throwable {
        ArrayList<Integer> lista = new ArrayList<>();
        Collections.addAll(lista, luvut);

        Double ka = kutsuKeskiarvo(lista);
        assertNotNull("Keskiarvon laskeminen luvuilla " + lista + " epäonnistui.", ka);
        double kesk = lista.stream().mapToDouble(i -> i).average().getAsDouble();

        assertEquals("Lukujen " + lista + " keskiarvon pitäisi olla noin " + kesk + ", nyt metodi palautti " + ka + ".", kesk, ka, 0.001);
    }

    private void testaaLueLuvut(int... luettavatLuvut) throws Throwable {
        lueLuvutMetodiOlemassa();

        ArrayList<Integer> luetutLuvut = new ArrayList<>();

        String luvut = "";
        for (int luku : luettavatLuvut) {
            luvut += luku + "\n";
        }
        luvut += "\n";

        Scanner lukija = new Scanner(luvut);

        kutsuLueLuvut(lukija, luetutLuvut);

        Assert.assertTrue("Kun metodia lueLuvut kutsutaan, ja syötteeksi annetaan luvut:\n" + luvut + "tulee listan koon olla lukemisen jälkeen " + luettavatLuvut.length + ".", luetutLuvut.size() == luettavatLuvut.length);

        for (int luku : luettavatLuvut) {
            Assert.assertTrue("Kun metodia lueLuvut kutsutaan, ja syötteeksi annetaan luvut:\n" + luvut + "tulee listalla olla luku " + luku + ". Nyt ei ollut.", luetutLuvut.contains(luku));

        }
    }

    public void kutsuLueLuvut(Scanner s, ArrayList<Integer> luetutLuvut) {
        try {
            Reflex.reflect("Desibelimittaukset").staticMethod("lueLuvut").returningVoid().taking(Scanner.class, ArrayList.class).invoke(s, luetutLuvut);
        } catch (Throwable t) {
            if (t.getMessage().contains("No line found")) {
                Assert.fail("Varmistathan että lukujen lukeminen lopetetaan tyhjään merkkijonoon metodissa lueLuvut.");
            }
        }
    }

    public ArrayList<Integer> kutsuValitseLuvutValilta(ArrayList<Integer> luvut, int pienin, int suurin) {
        ArrayList<Integer> tulos = null;
        try {
            tulos = Reflex.reflect("Desibelimittaukset").staticMethod("valitseLuvutValilta").returning(ArrayList.class).taking(ArrayList.class, int.class, int.class).invoke(luvut, pienin, suurin);
        } catch (Throwable t) {
            Assert.fail("Metodin \"public static ArrayList<Integer> valitseLuvutValilta(ArrayList<Integer> luvut, int pienin, int suurin)\" kutsuminen epäonnistui.\nKokeile metodiasi\nArrayList<Integer> lista = new ArrayList<>();\nlista.add(1);\nlista.add(5)\n;valitseLuvutValilta(lista, -1, 1);");
        }

        assertNotNull("Metodin valitseLuvutValilta tulee palauttaa ArrayList-tyyppinen lista. Nyt lista oli \"null\".", tulos);

        return tulos;
    }

    public Double kutsuKeskiarvo(ArrayList<Integer> luvut) {
        try {
            return Reflex.reflect("Desibelimittaukset").staticMethod("keskiarvo").returning(double.class).taking(ArrayList.class).invoke(luvut);
        } catch (Throwable t) {
            Assert.fail("Metodin \"public static double keskiarvo(ArrayList<Integer> luvut)\" kutsuminen epäonnistui.\nKokeile metodiasi\nArrayList<Integer> lista = new ArrayList<>();\nlista.add(-5);\nlista.add(0)\n;keskiarvo(lista);");
        }

        return null;
    }
}
