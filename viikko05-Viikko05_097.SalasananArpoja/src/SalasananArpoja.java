
import java.util.Random;

public class SalasananArpoja {

    // Määrittele muuttuja tässä
    private Random random;

    private int pituus;
    private String merkit = "abcdefghijklmnopqrstuvwxyz";

    public SalasananArpoja(int salasananPituus) {
        // Alusta muuttujat tässä
        this.pituus = salasananPituus;
        this.random = new Random();
    }

    public String luoSalasana() {
        // Kirjoita tähän koodi, joka palauttaa uuden salasanan
        String uusiSalasana = "";

        for (int i = 0; i < pituus; i++) {
            char merkki = merkit.charAt(random.nextInt(merkit.length()));
            uusiSalasana += merkki;
        }
        

        return uusiSalasana;
    }
}
