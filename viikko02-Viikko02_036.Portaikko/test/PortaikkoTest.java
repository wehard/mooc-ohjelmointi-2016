
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import java.awt.Point;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.*;
import robotti.Ohjain;

public class PortaikkoTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    @Points("36.1")
    public void porrasYlos() {
        testMode();
        String input = "1\n";
        io.setSysIn(input);
        try {
            Portaikko.main(null);
        } catch (NoSuchElementException e) {
            return;
        }

        input = input.replaceAll("\n", " ").trim();

        List<String> komennot = komennot();
        if (komennot == null || komennot.isEmpty()) {
            Assert.fail("Käynnistäthän robotin alussa ja sammutathan robotin lopussa.");
        }

        List<Point> sijainnit = getSijainnit();
        sijainnit = new ArrayList<Point>(new HashSet<Point>(sijainnit));
        Assert.assertTrue("Kun syötetään komento " + input + ", robotin tulee olla käynyt vain kolmessa sijainnissa; alku, ylös, oikea.", sijainnit.size() == 3);

        sijainnit.removeAll(new ArrayList<Point>() {
            {
                add(new Point(1, 6));
                add(new Point(1, 7));
                add(new Point(2, 7));
            }
        });

        Assert.assertTrue("Kun syötetään komento " + input + ", robotin tulee liikkua vain yksi askel ylös ja yksi askel oikealle.", sijainnit.isEmpty());
    }

    @Test
    @Points("36.1")
    public void portaitaYlos() {
        testMode();
        String input = "3\n";
        io.setSysIn(input);
        try {

            Portaikko.main(null);
        } catch (NoSuchElementException e) {
            return;
        }

        input = input.replaceAll("\n", " ").trim();

        List<String> komennot = komennot();
        if (komennot == null || komennot.isEmpty()) {
            Assert.fail("Käynnistäthän robotin alussa ja sammutathan robotin lopussa.");
        }

        List<Point> sijainnit = getSijainnit();
        sijainnit = new ArrayList<Point>(new HashSet<Point>(sijainnit));
        Assert.assertTrue("Kun syötetään komento " + input + ", robotin tulee liikkua kolme porrasta.", sijainnit.size() == 7);

        sijainnit.removeAll(new ArrayList<Point>() {
            {
                add(new Point(1, 6));
                add(new Point(1, 7));
                add(new Point(2, 7));
                add(new Point(2, 8));
                add(new Point(3, 8));
                add(new Point(3, 9));
                add(new Point(4, 9));
            }
        });

        Assert.assertTrue("Kun syötetään komento " + input + ", robotin tulee liikkua vain yksi askel ylös ja yksi askel oikealle.", sijainnit.isEmpty());
    }

    @Test
    @Points("36.2")
    public void porrasYlosJaAlas() {
        testMode();
        String input = "1\n1\n";
        io.setSysIn(input);
        try {
            Portaikko.main(null);
        } catch (NoSuchElementException e) {
            return;
        }

        input = input.replaceAll("\n", " ").trim();

        List<String> komennot = komennot();
        if (komennot == null || komennot.isEmpty()) {
            Assert.fail("Käynnistäthän robotin alussa ja sammutathan robotin lopussa.");
        }

        List<Point> sijainnit = getSijainnit();
        sijainnit = new ArrayList<Point>(new HashSet<Point>(sijainnit));
        Assert.assertTrue("Kun syötetään komennot " + input + ", robotin tulee olla käynyt vain viidessä sijainnissa; alku, ylös, oikea, alas, oikea, nyt sijainteja oli " + sijainnit.size(), sijainnit.size() == 5);

        sijainnit.removeAll(new ArrayList<Point>() {
            {
                add(new Point(1, 6));
                add(new Point(1, 7));
                add(new Point(2, 7));
                add(new Point(2, 6));
                add(new Point(3, 6));
            }
        });

        Assert.assertTrue("Kun syötetään komennot " + input + ", robotin tulee liikkua yksi porras ylös ja yksi porras alas. Varmista, että robottisi on vain yhden askeleen portaiden yläpäässä.", sijainnit.isEmpty());
    }

    @Test
    @Points("36.2")
    public void vainAlas() {
        testMode();
        String input = "0\n1\n";
        io.setSysIn(input);
        try {
            Portaikko.main(null);
        } catch (NoSuchElementException e) {
            return;
        }

        input = input.replaceAll("\n", " ").trim();

        List<String> komennot = komennot();
        if (komennot == null || komennot.isEmpty()) {
            Assert.fail("Käynnistäthän robotin alussa ja sammutathan robotin lopussa.");
        }

        List<Point> sijainnit = getSijainnit();
        sijainnit = new ArrayList<Point>(new HashSet<Point>(sijainnit));
        Assert.assertTrue("Kun syötetään komennot " + input + ", robotin tulee olla käynyt vain kolmessa sijainnissa; alku, alas, oikea, nyt sijainteja oli " + sijainnit.size(), sijainnit.size() == 3);

        sijainnit.removeAll(new ArrayList<Point>() {
            {
                add(new Point(1, 6));
                add(new Point(1, 5));
                add(new Point(2, 5));
            }
        });

        Assert.assertTrue("Kun syötetään komennot " + input + ", robotin tulee liikkua yksi porras alas.", sijainnit.isEmpty());
    }

    @Test
    @Points("36.2")
    public void kolmeYlosJaKaksiAlas() {
        testMode();
        String input = "3\n2\n";
        io.setSysIn(input);
        try {
            Portaikko.main(null);
        } catch (NoSuchElementException e) {
            return;
        }

        input = input.replaceAll("\n", " ").trim();

        List<String> komennot = komennot();
        if (komennot == null || komennot.isEmpty()) {
            Assert.fail("Käynnistäthän robotin alussa ja sammutathan robotin lopussa.");
        }

        List<Point> sijainnit = getSijainnit();
        sijainnit = new ArrayList<Point>(new HashSet<Point>(sijainnit));
        Assert.assertTrue("Kun syötetään komennot " + input + ", robotin tulee olla käynyt yhdessätoista sijainnissa; alku, ylös, oikea, ylös, oikea, ylös, oikea, alas, oikea, alas, oikea" + sijainnit.size(), sijainnit.size() == 11);

        sijainnit.removeAll(new ArrayList<Point>() {
            {
                add(new Point(1, 6));
                add(new Point(1, 7));
                add(new Point(2, 7));
                add(new Point(2, 8));
                add(new Point(3, 8));
                add(new Point(3, 9));
                add(new Point(4, 9));
                add(new Point(4, 8));
                add(new Point(5, 8));
                add(new Point(5, 7));
                add(new Point(6, 7));
            }
        });

        Assert.assertTrue("Kun syötetään komennot " + input + ", robotin tulee liikkua kolme porrasta ylös ja kaksi alas.", sijainnit.isEmpty());
    }

    private List<String> komennot() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("getKomennot");
            m.setAccessible(true);
            return (List<String>) m.invoke(null);
        } catch (Throwable e) {
        }

        return null;
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

    private void testMode() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("testMode");
            m.setAccessible(true);
            m.invoke(null);
        } catch (Throwable e) {
            throw new Error("Jotain meni pieleen!", e);
        }

        reset();
    }

    private void reset() {
        try {
            Method m = Ohjain.class.getDeclaredMethod("reset");
            m.setAccessible(true);
            m.invoke(null);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
