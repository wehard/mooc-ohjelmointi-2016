
import java.util.Scanner;

public class YmpyranKehanPituus {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. 
        
        System.out.print("Anna ympyrän säde: ");
        int sade = Integer.parseInt(lukija.nextLine());
        
        double tulos = 2.0 * Math.PI * sade;
                
        System.out.println("Ympyrän kehä: " + tulos);
        
        
    }
}
