import java.util.ArrayList;
import java.util.Scanner;

public class Sanat {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> sanat = new ArrayList<>();
        
        
        
        while(true) {
            System.out.print("Anna sana: ");
            String sana = lukija.nextLine();
            
            if(sana.isEmpty()) {
                break;
            }
            
            sanat.add(sana);
        }
        
        System.out.println("Annoit seuraavat sanat:");
        for (String sana : sanat) {
            System.out.println(sana);
        }
        
        
    }
}
