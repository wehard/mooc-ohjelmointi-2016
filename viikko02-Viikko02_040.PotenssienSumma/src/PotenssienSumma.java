
import java.util.Scanner;

public class PotenssienSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        
        System.out.print("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        int tulos = 1;
        
        for (int i = 1; i <= luku; i++) {
            tulos += Math.pow(2, i);
        }
          
        System.out.println("Tulos on " + tulos);
        
    }
}
