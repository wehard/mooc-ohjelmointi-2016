
import fi.helsinki.cs.tmc.edutestutils.MockStdio;
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;

@Points("136")
public class TarinaTest {
    
    @Rule
    public MockStdio io = new MockStdio();
    
    @Test
    public void tulostaaTarinan() {
        Tarina.main(new String[]{});
        
        String[] ohjelmanTulostus = io.getSysOut().split("\n");
        String[] odotettu = ("Hattivatti\n"
                + "hattivatistan\n"
                + "kaapu\n"
                + "Hattivatti\n"
                + "pyl\n"
                + "*puff*").split("\n");
        
        assertTrue("Ohjelman pitäisi tulostaa vähintään " + odotettu.length + " riviä.", odotettu.length <= ohjelmanTulostus.length);
        
        for (int i = 0; i < odotettu.length; i++) {
            assertTrue("Rivillä " + (i + 1) + " pitäisi olla \"" + odotettu[i] + "\", nyt ei ollut.", ohjelmanTulostus[i].trim().contains(odotettu[i].trim()));
        }
        
    }
}
