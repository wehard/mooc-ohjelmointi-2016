
import java.util.ArrayList;
import kuva.Fotari;
import kuva.Kuva;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> tiedostot = new ArrayList<>();

        // tiedostojen lisääminen
        tiedostot.add("G0010111.png");
        tiedostot.add("G0010161.png");
        tiedostot.add("G0010163.png");

        // tiedostojen lisääminen
        Yhdistin yhdistin = new Yhdistin("mediaani");
        ArrayList<Kuva> kuvat = yhdistin.lataaKuvat(tiedostot);
        Kuva kuva = yhdistin.yhdistaKuvat(kuvat);

        Fotari.nayta(kuva);

    }
}
