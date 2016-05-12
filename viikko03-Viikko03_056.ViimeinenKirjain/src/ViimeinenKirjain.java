
import java.util.Scanner;

public class ViimeinenKirjain {


    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna nimi: ");
        String merkkijono = lukija.nextLine();
        
        System.out.println("Viimeinen kirjain: " + viimeinenKirjain(merkkijono));
    }

    public static char viimeinenKirjain(String merkkijono) {
        return merkkijono.charAt(merkkijono.length()-1);
    }
}
