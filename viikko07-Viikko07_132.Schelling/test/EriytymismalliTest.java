
import fi.helsinki.cs.tmc.edutestutils.Points;
import org.junit.*;
import static org.junit.Assert.*;

public class EriytymismalliTest {

    @Test
    @Points("132.1")
    public void asetaKaikkiTyhjaksiAsettaaTaulukonArvotNolliksi() {
        Eriytymismalli malli = new Eriytymismalli(50, 50, 0.3, 0.5);
        malli.annaData()[0][0] = 1;

        malli.asetaKaikkiTyhjiksi();
        if (malli.annaData()[0][0] == 1) {
            fail("Kun kutsuaan metodia asetaKaikkiTyhjiksi, tulee kaikki taulukon arvot asettaa nolliksi.");
        }

        malli.annaData()[7][5] = 1;
        malli.annaData()[5][7] = 1;
        malli.annaData()[1][2] = 1;

        malli.asetaKaikkiTyhjiksi();

        if (malli.annaData()[7][5] == 1) {
            fail("Kun kutsuaan metodia asetaKaikkiTyhjiksi, tulee kaikki taulukon arvot asettaa nolliksi.");
        }
        if (malli.annaData()[5][7] == 1) {
            fail("Kun kutsuaan metodia asetaKaikkiTyhjiksi, tulee kaikki taulukon arvot asettaa nolliksi.");
        }
        if (malli.annaData()[1][2] == 1) {
            fail("Kun kutsuaan metodia asetaKaikkiTyhjiksi, tulee kaikki taulukon arvot asettaa nolliksi.");
        }
    }

    @Test
    @Points("132.1")
    public void tyhjatPaikatPalauttaaKaikkiArvotJosAsetettuTyhjaksi() {
        Eriytymismalli malli = new Eriytymismalli(5, 5, 0.3, 0.5);
        malli.annaData()[0][0] = 1;

        malli.asetaKaikkiTyhjiksi();

        assertTrue("Kun luodaan malli, jonka leveys on 5 ja korkeus on 5, ja kaikki kohdat alustetaan tyhjäksi, tulee metodin tyhjatPaikat palauttaa 25 tyhjää paikkaa. Nyt niin ei ollut.", malli.tyhjatPaikat().size() == 5 * 5);

        malli.annaData()[0][0] = 1;

        assertTrue("Kun luodaan malli, jonka leveys on 5 ja korkeus on 5, ja jossa yksi paikka ei ole tyhjä, tulee metodin tyhjatPaikat palauttaa 24 tyhjää paikkaa. Nyt niin ei ollut.", malli.tyhjatPaikat().size() == 24);

        for (Piste tyhja : malli.tyhjatPaikat()) {
            assertFalse("Kun mallin kohta 0, 0 on asetettu ei-tyhjäksi, ei se saa olla tyhjien paikkojen listalla.", tyhja.getX() == 0 && tyhja.getY() == 0);
        }
    }

    @Test
    @Points("132.2")
    public void haeTyytymattomat() {
        Eriytymismalli malli = new Eriytymismalli(5, 5, 0.3, 0.5);
        malli.asetaKaikkiTyhjiksi();

        int[][] data = malli.annaData();
        data[0][0] = 1;
        data[1][0] = 1;
        data[0][1] = 1;
        data[1][1] = 1;

        data[1][2] = 2;
        data[2][1] = 2;
        data[2][2] = 2;
        data[2][0] = 2;
        data[0][2] = 2;

        assertFalse("Jos pisteellä on vain samantyyppisiä naapureita tai nurkka-alueita ympärillä, sen ei pitäisi olla tyytymätön.", malli.haeTyytymattomat().contains(new Piste(0, 0)));
        assertTrue("Jos tyytymättömyysparametrin arvo on 0.5, ja pisteellä on kolme samantyyppistä naapuria ja viisi erityyppistä naapuria, pitäisi pisteen olla tyytymätön.", malli.haeTyytymattomat().contains(new Piste(1, 1)));
        assertFalse("Jos tyytymättömyysparametrin arvo on 0.5, ja pisteellä on kolme samantyyppistä naapuria ja kaksi erityyppistä naapuria, ei pisteen pitäisi olla tyytymätön.", malli.haeTyytymattomat().contains(new Piste(1, 0)));
        assertTrue("Jos tyytymättömyysparametrin arvo on 0.5, ja pisteellä on yksi samantyyppinen naapuri ja kaksi erityyppistä naapuria sekä tyhjiä paikkoja ympärillä, pitäisi pisteen olla tyytymätön.", malli.haeTyytymattomat().contains(new Piste(0, 2)));
    }
}
