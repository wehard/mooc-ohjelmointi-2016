
import java.util.HashMap;
import java.util.Scanner;

public class Kahvikassa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        HashMap<String, Integer> kahvit = new HashMap<>();

        // kahvikassan toiminnallisuus
        while (true) {
            
            System.out.println("** Kahvikassa **");
            
            System.out.print("> ");
            String kayttaja = lukija.nextLine();
            if(kayttaja.equals("")) {
                break;
            }

            haeTiedot(kahvit, kayttaja);
            
            System.out.println("");
            
            System.out.println("Kirjoita \"juo\" jos haluat juoda kahvin, \"tuo\" jos toit kahvipaketin.");
            System.out.print("> ");
            
            String komento = lukija.nextLine();
            
            if(komento.equals("")) {
                break;
            }
            if(komento.equals("juo")) {
                muutaSaldoa(kahvit, kayttaja, 1);
            }
            if(komento.equals("tuo")) {
                muutaSaldoa(kahvit, kayttaja, -10);
            }
            haeTiedot(kahvit, kayttaja);
        }

        

    }

    // metodit
    public static void haeTiedot(HashMap<String, Integer> data, String nimi) {

        if (!data.containsKey(nimi)) {
            System.out.println("Luodaan tunnus " + nimi + ".");
            data.put(nimi, 0);
            System.out.println("Juotuja kahveja " + data.get(nimi) + ".");
        } else {
            System.out.println("Juotuja kahveja " + data.get(nimi) + ".");
        }

    }

    public static void muutaSaldoa(HashMap<String, Integer> kassa, String nimi, int paljonko) {

        kassa.put(nimi, kassa.get(nimi)+paljonko);

    }
}
