
import java.util.Random;
import java.util.Scanner;

public class Numerovisa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int arvottuLuku = arvoLuku();

        // OHJELMOI OHJELMASI TÄHÄN, ÄLÄ MUOKKAA YLLÄOLEVIA ASIOITA
        
        
        
        int arvauskerrat = 0;
        
        while (true) {
            
            System.out.print("Arvaa luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            
            
            if(luku == arvottuLuku) {
                System.out.println("Onneksi olkoon, oikein arvattu!");
                break;
                
            }
                
            if(luku > arvottuLuku) {
                arvauskerrat++;
                System.out.println("Luku on pienempi, tehtyjä arvauksia: " + arvauskerrat);
                
            } else if (luku < arvottuLuku) {
                arvauskerrat++;
                System.out.println("Luku on suurempi, tehtyjä arvauksia: " + arvauskerrat);
                
            } 
            
        }
        
        
            
        
        
    }

    // ÄLÄ MUOKKAA METODIA arvoLuku
    private static int arvoLuku() {
        return new Random().nextInt(101);
    }
}
