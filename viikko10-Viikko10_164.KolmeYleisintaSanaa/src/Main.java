
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä

        YleisimmatSanat2 tunnistin = new YleisimmatSanat2();
        ArrayList<String> sanat = new ArrayList<>();

      
        for (int i = 0; i < 30; i++) {
            sanat.add("KolkytKolkytKolkyt");
        }
        for (int i = 0; i < 30; i++) {
            sanat.add("Kolmekymmentäkkkksdd");
        }
        for (int i = 0; i < 30; i++) {
            sanat.add("Kymmenen");
        }
        for (int i = 0; i < 5; i++) {
            sanat.add("Viisi");
        }

        System.out.println(tunnistin.yleisetSanat(sanat).toString());

    }

}
