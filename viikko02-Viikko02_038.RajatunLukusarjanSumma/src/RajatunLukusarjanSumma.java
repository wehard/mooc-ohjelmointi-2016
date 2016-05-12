
import java.util.Scanner;

public class RajatunLukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        
        System.out.print("Ensimmäinen: ");
        int first = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Viimeinen: ");
        int last = Integer.parseInt(lukija.nextLine());
        
        int summa = 0;
        
        int counter = 0;
        
        for (int i = first; i <= last; i++) {
            summa += i;
        }
     
        System.out.println("Summa on: " + summa);
    }
}
