
import java.util.Scanner;

public class IanTarkastus {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Kuinka vanha olet? ");
        
        int ika = Integer.parseInt(lukija.nextLine());
        
        if (ika >= 0 && ika <= 120) {
            System.out.println("OK");
        } else {
            System.out.println("Mahdotonta!");
        }
        
    }
}
