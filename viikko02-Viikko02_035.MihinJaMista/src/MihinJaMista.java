
import java.util.Scanner;

public class MihinJaMista {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // KIRJOITA OHJELMASI TÄNNE
        
        
        System.out.print("Mihin asti: ");
        int mihin = Integer.parseInt(lukija.nextLine());
        System.out.print("Mistä lähtien: ");
        int mista = Integer.parseInt(lukija.nextLine());
        
        int counter = 1;
        while(mista <= mihin ) {
            System.out.println(mista);
            mista++;
        }
    }
}
