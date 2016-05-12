
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Test;

@Points("121")
public class NpeVirheOhjelmaTest {

    @Test
    public void tapahtuuNullPointerException() {
        try {
            NpeVirheOhjelma.main(new String[]{});
            fail("Ohjelman suorituksessa tulee tapahtua NullPointerException-virhe. Nyt ei tapahtunut.");
        } catch (NullPointerException e) {
        }
    }
}
