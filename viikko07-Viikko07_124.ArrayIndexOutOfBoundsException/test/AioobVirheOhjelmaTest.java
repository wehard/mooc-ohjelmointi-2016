
import fi.helsinki.cs.tmc.edutestutils.Points;
import static org.junit.Assert.*;
import org.junit.Test;

@Points("124")
public class AioobVirheOhjelmaTest {

    @Test
    public void tapahtuuNullPointerException() {
        try {
            AioobVirheOhjelma.main(new String[]{});
            fail("Ohjelman suorituksessa tulee tapahtua ArrayIndexOutOfBoundsException-virhe. Nyt ei tapahtunut.");
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }
}
