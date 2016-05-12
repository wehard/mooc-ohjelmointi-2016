
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import org.junit.Test;

public class OstoslistaTest {

    private static final String PTS = "109";

    String klass = "Ostoslista";

    @Test
    public void luokkaSanatulostin() {
        junit.framework.Assert.assertTrue("Toteuta luokka " + klass + ". Varmista että se on muotoa public " + klass + " {..", Reflex.reflect(klass).isPublic());
    }

    @Test
    public void luokallaParametritonKonstruktori() {
        Reflex.reflect(klass).constructor().takingNoParams().requireExists();
    }

    @Points(PTS + ".1")
    @Test
    public void metodiLisaa() {
        Reflex.reflect(klass).method("lisaa").returningVoid().taking(String.class).requirePublic();
    }

    @Points(PTS + ".1")
    @Test
    public void metodiKappalemaara() {
        Reflex.reflect(klass).method("kappalemaara").returning(int.class).taking(String.class).requirePublic();
    }

    @Points(PTS + ".1")
    @Test
    public void lisaaminenKasvattaaKappalemaaraa() throws Throwable {
        metodiLisaa();
        metodiKappalemaara();

        Object ostoslista = luoOstoslista();
        try {
            kappalemaara(ostoslista, "nauris");
        } catch (Throwable t) {
            fail("Tapahtui virhe kun haettiin kappalemäärää tuotteelle, jota ei lisatty. Kappalemäärän pitäisi tällöin olla 0. Virhe: " + t.getMessage());
        }

        assertEquals("Kun ostoslistalle ei ole lisätty tuotetta \"nauris\", tulee sen kappalemäärä olla 0.", 0, kappalemaara(ostoslista, "nauris"));
        lisaa(ostoslista, "nauris");
        assertEquals("Kun ostoslistalle on lisätty tuote \"nauris\" kerran, tulee sen kappalemäärä olla 1.", 1, kappalemaara(ostoslista, "nauris"));
        lisaa(ostoslista, "nauris");
        assertEquals("Kun ostoslistalle on lisätty tuote \"nauris\" kahdesti, tulee sen kappalemäärä olla 2.", 2, kappalemaara(ostoslista, "nauris"));

        for (int i = 1; i < 5; i++) {
            lisaa(ostoslista, "nauris");
            assertEquals("Kun ostoslistalle on lisätty tuote \"nauris\" " + (2 + i) + " kertaa, tulee sen kappalemäärä olla " + (2 + i) + ".", (2 + i), kappalemaara(ostoslista, "nauris"));
        }
    }

    @Points(PTS + ".1")
    @Test
    public void eriEsineillaEriKappalemaarat() throws Throwable {
        metodiLisaa();
        metodiKappalemaara();

        Object ostoslista = luoOstoslista();
        assertEquals("Kun ostoslistalle ei ole lisätty tuotetta \"nauris\", tulee sen kappalemäärä olla 0.", 0, kappalemaara(ostoslista, "nauris"));
        assertEquals("Kun ostoslistalle ei ole lisätty tuotetta \"porkkana\", tulee sen kappalemäärä olla 0.", 0, kappalemaara(ostoslista, "porkkana"));
        lisaa(ostoslista, "nauris");
        assertEquals("Kun ostoslistalle ei ole lisätty tuotetta \"porkkana\", tulee sen kappalemäärä olla 0.", 0, kappalemaara(ostoslista, "porkkana"));
        assertEquals("Kun ostoslistalle on lisätty tuote \"nauris\" kerran, tulee sen kappalemäärä olla 1.", 1, kappalemaara(ostoslista, "nauris"));
    }

    @Points(PTS + ".2")
    @Test
    public void metodiPoista() {
        Reflex.reflect(klass).method("poista").returningVoid().taking(String.class).requirePublic();
    }

    @Points(PTS + ".2")
    @Test
    public void poistoToimii() throws Throwable {
        metodiLisaa();
        metodiKappalemaara();
        metodiPoista();

        Object ostoslista = luoOstoslista();
        lisaa(ostoslista, "nauris");

        for (int i = 2; i < 5; i++) {
            lisaa(ostoslista, "nauris");
            assertEquals("Kun ostoslistalle on lisätty tuote \"nauris\" " + i + " kertaa, tulee sen kappalemäärä olla " + i + ".", i, kappalemaara(ostoslista, "nauris"));
        }

        poista(ostoslista, "nauris");
        assertTrue("Poista-metodin tulee poistaa vain yksi tuotteen kappale, ei kaikkia.", kappalemaara(ostoslista, "nauris") > 0);
        assertEquals("Poista-metodin tulee poistaa vain yksi tuotteen kappale, ei kaikkia.", 3, kappalemaara(ostoslista, "nauris"));

        poista(ostoslista, "nauris");
        assertEquals("Poista-metodin tulee poistaa vain yksi tuotteen kappale, ei kaikkia.", 2, kappalemaara(ostoslista, "nauris"));
    }

    public Object luoOstoslista() throws Throwable {
        return Reflex.reflect(klass).constructor().takingNoParams().invoke();
    }

    public void lisaa(Object ostoslista, String tuote) throws Throwable {
        Reflex.reflect(klass).method("lisaa").returningVoid().taking(String.class).invokeOn(ostoslista, tuote);
    }

    public int kappalemaara(Object ostoslista, String tuote) throws Throwable {
        return Reflex.reflect(klass).method("kappalemaara").returning(int.class).taking(String.class).invokeOn(ostoslista, tuote);
    }

    public void poista(Object ostoslista, String tuote) throws Throwable {
        Reflex.reflect(klass).method("poista").returningVoid().taking(String.class).invokeOn(ostoslista, tuote);
    }
}
