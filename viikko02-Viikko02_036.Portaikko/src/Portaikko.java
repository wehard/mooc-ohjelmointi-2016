
import java.util.Scanner;
import robotti.Ohjain;

public class Portaikko {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        Ohjain.kaynnista();
        // KIRJOITA OHJELMASI TÄNNE
        
        
        System.out.print("Montako ylös? ");
        int ylos = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Montako alas? ");
        int alas = Integer.parseInt(lukija.nextLine());
        
        for (int i = 0; i < ylos; i++) {
            Ohjain.vasen();
            Ohjain.liiku();
            Ohjain.oikea();
            Ohjain.liiku();
        }
        
        for (int i = 0; i < alas; i++) {
            Ohjain.oikea();
            Ohjain.liiku();
            Ohjain.vasen();
            Ohjain.liiku();
        }

        Ohjain.sammuta();
    }
}
