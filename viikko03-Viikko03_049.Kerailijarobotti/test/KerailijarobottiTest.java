
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.awt.Point;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import robotti.Ohjain;
import robotti.Pallo;

public class KerailijarobottiTest {

    @Test
    @Points("49.1")
    public void ohjainKaynnistetaanAlussaJaSammutetaanLopussa() throws Exception {
        suoritaOhjelma();
        List<String> komennot = getKomennot();

        Assert.assertNotNull("Varmista, että robotti sammutetaan lopuksi komennolla \"Ohjain.sammuta();\".", komennot);
        Assert.assertTrue("Kun ohjelma suoritettiin, komentoja annettiin " + komennot.size() + ". Robotti tulee ainakin käynnistää ja sammuttaa.", komennot.size() >= 2);

        Assert.assertTrue("Ensimmäisen ohjaimelle annettavan komennon tulee olla \"Ohjain.kaynnista();\".", komennot.get(0).equals("kaynnista"));
        Assert.assertTrue("Viimeisen ohjaimelle annettavan komennon tulee olla \"Ohjain.sammuta();\".", komennot.get(komennot.size() - 1).equals("sammuta"));

        int kaynnistyksia = 0;
        int sammutuksia = 0;
        for (String komento : komennot) {
            if (komento.equals("kaynnista")) {
                kaynnistyksia++;
            }
            if (komento.equals("sammuta")) {
                sammutuksia++;
            }
        }

        Assert.assertTrue("Ylimääräiset käynnistykset ja sammutukset vievät sähköä!\nKäynnistä robotti vain alussa ja sammuta se lopussa!", kaynnistyksia == 1 && sammutuksia == 1);
    }

    @Test
    @Points("49.1")
    public void ajetaanPisteidenYli() throws Exception {
        suoritaOhjelma();

        List<Point> pisteet = new ArrayList<>();
        for (Pallo p : getPoimitutPallot()) {
            pisteet.add(new Point(p.x, p.y));
        }

        pisteet.removeAll(getSijainnit());

        assertTrue("Aja kaikkien esineiden yli. Nyt yliajamattomia esineitä jäi jäljelle " + pisteet.size() + ".", pisteet.isEmpty());

    }

    @Test
    @Points("49.2")
    public void eiRikotaKauhaa() throws Exception {
        suoritaOhjelma();

        Assert.assertTrue("Älä riko kauhaa! Kauha rikkoontuu jos yrität nostaa esinettä sellaisesta kohdasta, missä sitä ei ole.", Ohjain.kauhaKunnossa());
        palauta();
    }

    @Test
    @Points("49.2")
    public void nostetaanYksiEsine() throws Exception {
        nostaVahintaan("Yritä nostaa ainakin yksi esine.", 1);
    }

    @Test
    @Points("49.2")
    public void nostetaanKaksiEsinetta() throws Exception {
        nostaVahintaan("Yritä nostaa ainakin kaksi esinettä.", 2);
    }

    @Test
    @Points("49.2")
    public void nostetaanRivi() throws Exception {
        nostaVahintaan("Yritä nostaa rivillinen esineitä.", 7);
    }

    @Test
    @Points("49.2")
    public void nostetaanKaksiRivia() throws Exception {
        nostaVahintaan("Yritä nostaa kaksi rivillista esineitä.", 14);
    }

    @Test
    @Points("49.2")
    public void nostetaanKaikki() throws Exception {
        nostaVahintaan("Yritä nostaa kaikki esineet.", 98);
    }

    private void suoritaOhjelma() {
        testMode();
        palauta();

        try {
            Paaohjelma.main(new String[]{});
        } catch (Throwable t) {
            try {
                Ohjain.sammuta();
            } catch (Throwable t2) {
            }

            fail(t.getMessage());
        }
    }

    private void nostaVahintaan(String viesti, int lkm) {
        suoritaOhjelma();

        assertTrue(viesti, getPoimitutPallot() != null && getPoimitutPallot().size() >= lkm);
        palauta();
    }

    private List<Pallo> getPoimitutPallot() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("getPoimitutPallot");
            m.setAccessible(true);
            return (List<Pallo>) m.invoke(null);
        } catch (Throwable e) {
        }
        return null;
    }

    private List<String> getKomennot() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("getKomennot");
            m.setAccessible(true);
            return (List<String>) m.invoke(null);
        } catch (Throwable e) {
        }
        return null;
    }

    private void testMode() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("testMode");
            m.setAccessible(true);
            m.invoke(null);
        } catch (Throwable e) {
            throw new Error("Jotain meni pieleen!", e);
        }
    }

    private List<Point> getSijainnit() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("getSijainnit");
            m.setAccessible(true);
            return (List<Point>) m.invoke(null);
        } catch (Throwable e) {
        }
        return null;
    }

    private void palauta() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("palauta");
            m.setAccessible(true);
            m.invoke(null);
        } catch (Throwable e) {
            throw new Error("Jotain meni pieleen!", e);
        }
    }
}
