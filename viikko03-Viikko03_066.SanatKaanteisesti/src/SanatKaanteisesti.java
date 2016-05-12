import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SanatKaanteisesti {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Tee tänne edellisen tehtävän tapaan ArrayList, johon laitat sanat
        ArrayList<String> sanat = new ArrayList<>();
        
        
        while(true) {
            System.out.print("Anna sana: ");
            String sana = lukija.nextLine();
            
            if(sana.isEmpty()) {
                break;
            }
            
            sanat.add(sana);
        }
        
        Collections.reverse(sanat);
        
        System.out.println("Annoit seuraavat sanat: ");
        for(String sana : sanat) {
            System.out.println(sana);
        }
        
    }
}
