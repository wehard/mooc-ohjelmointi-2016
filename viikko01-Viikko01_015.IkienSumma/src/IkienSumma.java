
import java.util.Scanner;

public class IkienSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.print("Kerro nimi: ");
        String ekanimi = lukija.nextLine();
        System.out.print("Kerro ikä: ");
        int ekaika = Integer.parseInt(lukija.nextLine());
        
        System.out.println("");
        
        System.out.print("Kerro nimi: ");
        String tokanimi = lukija.nextLine();
        System.out.print("Kerro ikä: ");
        int tokaika = Integer.parseInt(lukija.nextLine());
        
        System.out.println("");
        
        System.out.println(ekanimi + " ja " + tokanimi + " ovat yhteensä " + (ekaika + tokaika) + " vuotta vanhoja.");
          

        // Toteuta ohjelmasi tähän.
    }
}
