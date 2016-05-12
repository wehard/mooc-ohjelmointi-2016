import java.util.Scanner;

public class Palindromi {

    public static boolean palindromi(String merkkijono) {
        // kirjoita koodia tähän
        String reversed = kaanna(merkkijono);
        if(merkkijono.equals(reversed)) {
            return true;
        }
        
        return false;
    }
    
    public static String kaanna(String merkkijono) {
        // Kirjoita koodia tähän.
        // Metodin on siis palautettava käännetty merkkijono returnilla!
        
        String palautus = "";
        
        for (int i = merkkijono.length()-1; i >= 0; i--) {
            palautus += merkkijono.charAt(i);
        }
        return palautus;
    }
    

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Anna merkkijono: ");
        String merkkijono = lukija.nextLine();    
        if (palindromi(merkkijono)) {
            System.out.println("Merkkijono on palindromi!");
        } else {
            System.out.println("Merkkijono ei ole palindromi!");
        }
    }
}
