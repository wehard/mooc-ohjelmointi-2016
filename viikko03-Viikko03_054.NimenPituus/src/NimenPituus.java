
import java.util.Scanner;

public class NimenPituus {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // kutsu täältä metodiasi
        
        System.out.print("Anna nimi: ");
        String merkkijono = lukija.nextLine();
        
        int kirjaimet = laskeKirjaimet(merkkijono);
        System.out.println("Kirjainmäärä: " + kirjaimet);
    }
    
    // tee tänne metodi 
    // public static int laskeKirjaimet(String merkkijono)
    public static int laskeKirjaimet(String merkkijono) {
        return merkkijono.length();
    }
}
