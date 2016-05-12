
import java.util.Scanner;

public class Debuggailua {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("Anna merkkijono:");
        String merkkijono = lukija.nextLine();

        System.out.println("Anna luku:");
        int luku = Integer.parseInt(lukija.nextLine());
        int moneskoKirjain = 0;

        for (int i = 0; i < merkkijono.length(); i++) {
            for (int k = 1; k <= luku; k++) {
                for (int p = 1; p < k; p++) {
                    System.out.print(" ");
                    
                }
                System.out.println(merkkijono.charAt(moneskoKirjain));
                //System.out.println(moneskoKirjain);
                moneskoKirjain++;
                if(moneskoKirjain > merkkijono.length()-1) {
                    moneskoKirjain = 0;
                }
            }
            
        }
    }
}
