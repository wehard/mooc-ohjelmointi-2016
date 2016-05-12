
import java.util.Random;

public class Noppa {

    private Random random;
    private int tahkojenMaara;

    public Noppa(int tahkojenMaara) {
        this.random = new Random();
        // Alusta muuttuja tahkojenMaara tässä
        this.tahkojenMaara = tahkojenMaara;
    }

    public int heita() {
        // arvotaan luku väliltä 1-tahkojenMaara
        return 1+ random.nextInt(tahkojenMaara);
    }
}
