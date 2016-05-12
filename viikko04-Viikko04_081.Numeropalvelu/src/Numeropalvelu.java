
import java.util.HashMap;
import java.util.Scanner;

public class Numeropalvelu {

    public static void main(String[] args) {
        // Toteuta numeropalvelu tänne
        Scanner lukija = new Scanner(System.in);
        HashMap<String, String> numerot = new HashMap<>();

        while (true) {
            System.out.print("Syötä puhelinnumero, tyhjä lopettaa: ");
            String numero = lukija.nextLine();

            if (numero.isEmpty()) {
                break;
            }

            System.out.print("Syötä nimi: ");
            String nimi = lukija.nextLine();

            if (nimi.isEmpty()) {
                break;
            }

            /*
            if (numerot.containsKey(nimi)) {
                continue;
            } else {
                numerot.put(nimi, numero);
            }
             */
            numerot.put(numero, nimi);

        }

        System.out.println("");
        System.out.println("Kiitos!");

        System.out.println("");
        System.out.println("* Numeropalvelu *");

        while (true) {

            System.out.println("Mikä numero tarkistetaan?");
            System.out.print("> ");

            String numero = lukija.nextLine();

            if (numero.isEmpty()) {
                break;
            }

            if (numerot.containsKey(numero)) {
                System.out.println("Soittaja on " + numerot.get(numero));
            } else {
                System.out.println("Tuntematon numero.");
            }
            System.out.println("");

        }

        System.out.println("");
        System.out.println("Kiitos!");
    }

}
