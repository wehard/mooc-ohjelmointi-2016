
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import fi.helsinki.cs.tmc.edutestutils.Reflex;
import java.util.HashMap;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;

public class KahvikassaTest {

    final String LUOKKA = "Kahvikassa";
    final String HAETIEDOT = "haeTiedot";
    final String MUUTASALDOA = "muutaSaldoa";

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    @Points("82.1")
    public void metodiHaeTiedotOlemassa() throws Throwable {
        try {
            Reflex.reflect(LUOKKA).staticMethod(HAETIEDOT).returningVoid().taking(HashMap.class, String.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle " + LUOKKA + " metodin public static void " + HAETIEDOT + "(HashMap<String, Integer> kassa, String nimi)?");
        }
    }

    @Test
    @Points("82.1")
    public void metodiHaeTiedotTulostaaLuodaanTunnus() throws Throwable {
        HashMap<String, Integer> data = new HashMap<>();
        kutsuHaeTiedot(data, "Ada");
        assertTrue("Kun metodille haeTiedot annetaan parametrina HashMap-olio sekä nimi \"Ada\", jota ei ole HashMapissa, tulee ohjelman tulostaa \"Luodaan tunnus Ada.\".", io.getSysOut().contains("Luodaan tunnus Ada"));
    }

    @Test
    @Points("82.1")
    public void metodiHaeTiedotLisaaTunnuksen() throws Throwable {
        HashMap<String, Integer> data = new HashMap<>();
        kutsuHaeTiedot(data, "Ada");
        assertTrue("Kun metodille haeTiedot annetaan parametrina HashMap-olio sekä nimi \"Ada\", jota ei ole HashMapissa, tulee ohjelman lisätä HashMap-olioon avain \"Ada\", jonka arvona on 0.", data.containsKey("Ada"));
        assertTrue("Kun metodille haeTiedot annetaan parametrina HashMap-olio sekä nimi \"Ada\", jota ei ole HashMapissa, tulee ohjelman lisätä HashMap-olioon avain \"Ada\", jonka arvona on 0.", data.get("Ada") == 0);
    }

    @Test
    @Points("82.1")
    public void metodiHaeTiedotTulostaaJuotujenKahvienMaaran() throws Throwable {
        HashMap<String, Integer> data = new HashMap<>();
        kutsuHaeTiedot(data, "Ada");
        assertTrue("Metodin haeTiedot tulee tulostaa juotujen kahvien määrä.", io.getSysOut().contains("Juotuja kahveja 0"));
    }

    @Test
    @Points("82.1")
    public void metodiHaeTiedotEiYlikirjoitaOlemassaOlevaaTunnusta() throws Throwable {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Ada", 10);
        kutsuHaeTiedot(data, "Ada");
        assertTrue("Kun metodille haeTiedot annetaan parametrina HashMap-olio sekä nimi \"Ada\", jota on jo HashMapissa, ei ohjelman tule ylikirjoittaa vanhaa tunnusta \"Ada\"", data.containsKey("Ada") && data.get("Ada") == 10);
    }

    @Test
    @Points("82.1")
    public void metodiHaeTiedotTulostaaOlemassaolevanJuotujenKahvienMaaran() throws Throwable {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Ada", 10);
        kutsuHaeTiedot(data, "Ada");
        assertTrue("Metodin haeTiedot tulee tulostaa juotujen kahvien määrä. Hae juotujen kahvien määrä parametrina saadusta HashMapista.", io.getSysOut().contains("Juotuja kahveja 10"));
        assertFalse("Metodin haeTiedot tulee tulostaa vain parametrina annetun henkilön juotujen kahvien määrä. Hae juotujen kahvien määrä parametrina saadusta HashMapista.", io.getSysOut().contains("Juotuja kahveja 0"));
    }

    public void kutsuHaeTiedot(HashMap<String, Integer> data, String nimi) {
        try {
            Reflex.reflect(LUOKKA).staticMethod(HAETIEDOT).returningVoid().taking(HashMap.class, String.class).invoke(data, nimi);
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle " + LUOKKA + " metodin public static void " + HAETIEDOT + "(HashMap<String, Integer> kassa, String nimi)?");
        }
    }

    @Test
    @Points("82.2")
    public void metodiKasvataSaldoaOlemassa() throws Throwable {
        try {
            Reflex.reflect(LUOKKA).staticMethod(MUUTASALDOA).returningVoid().taking(HashMap.class, String.class, int.class).requirePublic();
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle " + LUOKKA + " metodin public static void " + MUUTASALDOA + "(HashMap<String, Integer> kassa, String nimi, int paljonko)?");
        }
    }

    @Test
    @Points("82.2")
    public void saldonKasvatusYhdellaMuuttaaSaldoaYhdella() throws Throwable {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Ada", 10);
        kutsuKasvataSaldoa(data, "Ada", 1);
        assertTrue("Kun metodia kasvataSaldoa kutsutaan siten, että paljonko-muuttujan arvo on 1, tulee annettuun nimeen liittyvän saldon kasvaa yhdellä.", data.get("Ada") == 11);
    }

    @Test
    @Points("82.2")
    public void saldonKasvatusViidellaMuuttaaSaldoaViidella() throws Throwable {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Ada", 10);
        kutsuKasvataSaldoa(data, "Ada", 5);
        assertTrue("Kun metodia kasvataSaldoa kutsutaan siten, että paljonko-muuttujan arvo on 5, tulee annettuun nimeen liittyvän saldon kasvaa viidellä.", data.get("Ada") == 15);
    }

    @Test
    @Points("82.2")
    public void saldonKasvatusNegatiivisellaOnnistuu() throws Throwable {
        HashMap<String, Integer> data = new HashMap<>();
        data.put("Ada", 15);
        kutsuKasvataSaldoa(data, "Ada", -10);
        assertTrue("Kun metodia kasvataSaldoa kutsutaan negatiivisella siten, että paljonko-muuttujan arvo on -10, tulee annettuun nimeen liittyvän saldon pienentyä viidellä.", data.get("Ada") == 5);
    }

    public void kutsuKasvataSaldoa(HashMap<String, Integer> data, String nimi, int paljonko) {
        try {
            Reflex.reflect(LUOKKA).staticMethod(MUUTASALDOA).returningVoid().taking(HashMap.class, String.class, int.class).invoke(data, nimi, paljonko);
        } catch (Throwable t) {
            Assert.fail("Loithan luokalle " + LUOKKA + " metodin public static void " + MUUTASALDOA + "(HashMap<String, Integer> kassa, String nimi, int paljonko)?");
        }
    }

    @Test
    @Points("82.3")
    public void testaaKahvikassanToimintaaYksi() throws Throwable {
        io.setSysIn("Sonja\njuo\nSonja\ntuo\nAda\njuo\n\n");
        Kahvikassa.main(new String[0]);
        assertTrue("Toimiihan ohjelmasi oikein kun käytetään tehtävänannon alussa olevan esimerkin syötteitä.", io.getSysOut().contains("Luodaan tunnus Sonja"));
        assertTrue("Toimiihan ohjelmasi oikein kun käytetään tehtävänannon alussa olevan esimerkin syötteitä.", io.getSysOut().contains("Juotuja kahveja 0"));
        assertTrue("Toimiihan ohjelmasi oikein kun käytetään tehtävänannon alussa olevan esimerkin syötteitä.", io.getSysOut().contains("Juotuja kahveja 1"));
        assertTrue("Toimiihan ohjelmasi oikein kun käytetään tehtävänannon alussa olevan esimerkin syötteitä.", io.getSysOut().contains("Juotuja kahveja -9"));
        assertTrue("Toimiihan ohjelmasi oikein kun käytetään tehtävänannon alussa olevan esimerkin syötteitä.", io.getSysOut().contains("Luodaan tunnus Ada"));
    }

    @Test
    @Points("82.3")
    public void testaaKahvikassanToimintaaKaksi() throws Throwable {
        String syote = "Antti\ntuo\nAntti\ntuo\nAntti\ntuo\n\n";
        io.setSysIn(syote);
        Kahvikassa.main(new String[0]);
        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, io.getSysOut().contains("Luodaan tunnus Antti"));
        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, !io.getSysOut().contains("Luodaan tunnus Sonja"));
        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, !io.getSysOut().contains("Luodaan tunnus Ada"));

        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, !io.getSysOut().contains("Juotuja kahveja 1"));
        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, !io.getSysOut().contains("Juotuja kahveja -9"));

        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, io.getSysOut().contains("Juotuja kahveja 0"));
        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, io.getSysOut().contains("Juotuja kahveja -10"));
        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, io.getSysOut().contains("Juotuja kahveja -20"));
        assertTrue("Tarkista, että ohjelmasi toimii oikein jos syöte on:\n " + syote, io.getSysOut().contains("Juotuja kahveja -30"));
    }
}
