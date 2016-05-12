
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Test;

@Points("123")
public class SioobVirheOhjelmaTest {

    @Test
    public void tapahtuuNullPointerException() {
        try {
            SioobVirheOhjelma.main(new String[]{});
            fail("Ohjelman suorituksessa tulee tapahtua StringIndexOutOfBoundsException-virhe. Nyt ei tapahtunut.");
        } catch (StringIndexOutOfBoundsException e) {
        }
    }
}
