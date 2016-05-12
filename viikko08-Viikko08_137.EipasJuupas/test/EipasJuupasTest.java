
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("137")
public class EipasJuupasTest {

    @Rule
    public MockStdio io = new MockStdio();

    @Test
    public void samat() {
        io.setSysIn("sama\nsama");
        EipasJuupas.main(new String[]{});

        String tulostus = io.getSysOut().toLowerCase();

        int eiLkm = laskeLkm(tulostus);

        assertTrue("Kun käyttäjä syöttää merkkijonot 'sama' ja 'sama', pitäisi tulostuksen olla:\nOlipas!\n"
                + "No eipäs ollut!\n"
                + "Juupas!", eiLkm == 1);

    }

    public int laskeLkm(String tulostus) {
        int eiLkm = 0;
        int idx = 0;

        while (tulostus.indexOf("ei", idx) >= 0) {
            eiLkm++;
            idx = tulostus.indexOf("ei", idx) + 1;
        }

        return eiLkm;
    }

    @Test
    public void eri() {
        io.setSysIn("eri\nsama\n");
        EipasJuupas.main(new String[]{});

        String tulostus = io.getSysOut().toLowerCase();

        int eiLkm = laskeLkm(tulostus);

        assertTrue("Kun käyttäjä syöttää merkkijonot 'eri' ja 'sama', pitäisi tulostuksen olla:\nEipäs ollut!\n"
                + "Juupas!\n"
                + "Eipäs!", eiLkm == 2);

    }
}
