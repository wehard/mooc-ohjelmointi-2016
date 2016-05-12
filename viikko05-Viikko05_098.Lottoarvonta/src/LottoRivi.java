
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LottoRivi {

    private ArrayList<Integer> numerot;

    public LottoRivi() {
        // Arvo numerot heti LottoRivin luomisen yhteydessä
        this.arvoNumerot();
    }

    public ArrayList<Integer> numerot() {
        return this.numerot;
    }

    public void arvoNumerot() {
        // Alustetaan lista numeroille
        this.numerot = new ArrayList<>();
        // Kirjoita numeroiden arvonta tänne käyttämällä metodia sisaltaaNumeron()

        Random random = new Random();

        for (int i = 0; i < 7; i++) {
            int lottonumero = random.nextInt(40);
            while(lottonumero < 1) {
                lottonumero = random.nextInt(40);
            }
            if (sisaltaaNumeron(lottonumero)) {
                i--;
            } else {
                numerot.add(lottonumero);
            }
        }
        Collections.sort(numerot);

    }

    public boolean sisaltaaNumeron(int numero) {
        // Testaa tässä onko numero jo arvottujen numeroiden joukossa

        if (numerot.contains(numero)) {
            return true;
        } else {
            return false;
        }

    }
}
