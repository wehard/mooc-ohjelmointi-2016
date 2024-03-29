package arviot;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Testaa tunteikkaat elokuva-arviot ohjelmaa täällä

        // alla on valmiina annettuna tiedoston lukemiseen tarvittava koodi
        List<String> rivit = lueRivit("src/arviot-lyhyt-1.txt");
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);

        //System.out.println(arviot.lauseenTunne("unicorn is a mythical creature"));
        

        Scanner lukija = new Scanner(System.in);

        while (true) {
            System.out.println("~~ Emo-tions ~~");
            System.out.println("");
            System.out.println("Komennot: ");
            System.out.println("[1] Sanan yleisyys");
            System.out.println("[2] Sanan tunne");
            System.out.println("[3] Lauseen tunne");
            System.out.println("[x] Lopeta");

            System.out.print("> ");
            String komento = lukija.nextLine();
            if (komento.equals("x")) {
                break;
            }

            System.out.println("Anna syöte: ");
            String syote = lukija.nextLine();

            if (komento.equals("1")) {
                System.out.println("Sana '" + syote + "' esiintyy " + arviot.sanojenLukumaara(syote) + " kertaa.");
            } else if (komento.equals("2")) {
                System.out.println("Sanan '" + syote + "' tunne on " + arviot.sananTunneMerkkijonona(syote) + " (ka. " + arviot.sananTunne(syote) + ")");
            } else if (komento.equals("3")) {
                System.out.println("Lauseen '" + syote + "' tunne on " + arviot.lauseenTunneMerkkijonona(syote) + " (ka. " + arviot.lauseenTunne(syote) + ")");
            }

            System.out.println("");
        }
    }

    private static List<String> lueRivit(String tiedosto) {
        List<String> rivit = new ArrayList<>();

        // avataan resurssi
        try (Scanner lukija = new Scanner(new File(tiedosto))) {

            // käsitellään resurssia
            while (lukija.hasNextLine()) {
                rivit.add(lukija.nextLine());
            }

        } catch (Exception e) {
            // käsitellään mahdollinen poikkeus
            System.out.println("Virhe: " + e.getMessage());
        }

        return rivit;
    }
}
