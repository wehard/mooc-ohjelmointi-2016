
import java.util.Scanner;

public class HipHipHurraa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Toteuta tänne tehtävä "Hip Hip Hurraa"
        
        System.out.print("Kirjoita merkkijono: ");
        String merkkijono = lukija.nextLine();
        
        for (int i = 1; i < merkkijono.length()+1; i++) {
            System.out.print(merkkijono.charAt(i-1) + " ");
            
            if(i%2 == 0) {
                System.out.print("hip ");
            }
            if(i%5 == 0) {
                System.out.print("hurraa ");
            }
            
            
            System.out.println("");
                    
        }
        
        
        
    }
}
