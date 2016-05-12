
import java.util.Scanner;

public class LukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        
        System.out.print("Mihin asti: ");
        int mihin = Integer.parseInt(lukija.nextLine());
        int summa = 0;
        
        int counter = 0;
        
        while(counter <= mihin ) {
            
            summa+= counter;
            counter++;
        }
        System.out.println("Summa on: " + summa);
    }
}
