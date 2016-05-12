import java.util.Scanner;

public class EnsimmainenKirjain {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        
        System.out.print("Anna nimi: ");
        String merkkijono = lukija.nextLine();
        
        System.out.println("Ensimmäinen kirjain: " + ensimmainenKirjain(merkkijono));
        
    }
    
    
    public static char ensimmainenKirjain(String merkkijono) {
        return merkkijono.charAt(0);
    }
    
}
