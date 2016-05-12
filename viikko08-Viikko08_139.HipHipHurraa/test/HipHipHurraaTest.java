
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("139")
public class HipHipHurraaTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void test1() {
        io.setSysIn("test");
        HipHipHurraa.main(new String[]{});

        String[] tulostus = io.getSysOut().toLowerCase().trim().split("\n");

        tarkista("test", tulostus, "t", "e hip", "s", "t hip");

    }

    @Test
    public void test2() {
        io.setSysIn("saippuakauppias");
        HipHipHurraa.main(new String[]{});

        String[] tulostus = io.getSysOut().toLowerCase().trim().split("\n");
        tarkista("saippuakauppias", tulostus, "s", "a hip", "i", "p hip", "p hurraa", "u hip", "a",
                "k hip", "a", "u hip hurraa", "p", "p hip", "i", "a hip", "s hurraa");

    }

    private void tarkista(String syote, String[] tulostus, String... odotettu) {
        assertTrue("Tulostathan vain " + odotettu.length + " riviä?", tulostus.length == odotettu.length);

        for (int i = 0; i < odotettu.length; i++) {
            assertTrue("Kun syöte on:\n" + syote + "\ntulee rivillä " + i + ". olla tulostus " + odotettu[i], tulostus[i].trim().endsWith(odotettu[i]));

        }

    }
}
