
import java.util.Scanner;

public class Ylinopeussakko {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. 
        
        System.out.print("Kerro nopeus: ");
        int nopeus = Integer.parseInt(lukija.nextLine());
        
        if(nopeus > 120)
        {
            System.out.println("");
            System.out.println("Ylinopeussakko!");
        }
        
    }
}
