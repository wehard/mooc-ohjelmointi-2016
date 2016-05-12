
import java.util.Scanner;

public class KirjaimetErikseen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        
        System.out.print("Anna nimi: ");
        String nimi = lukija.nextLine();
        
        for (int i = 0; i < nimi.length(); i++) {
            System.out.println(i+1 + ". kirjain: " + nimi.charAt(i));
        }
    }
}
