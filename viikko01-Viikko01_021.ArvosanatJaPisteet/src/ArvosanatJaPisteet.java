
import java.util.Scanner;

public class ArvosanatJaPisteet {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna pisteet [0-100]: ");
        
        int vastaus = Integer.parseInt(lukija.nextLine());
        
        if(vastaus < 0) {
            System.out.println("");
            System.out.println("mahdotonta!");
        } else if(vastaus <= 74) {
            System.out.println("");
            System.out.println("hylätty");
        } else if(vastaus <= 89) {   
            System.out.println("");
            System.out.println("hyväksytty");
        } else if(vastaus <= 100) {
            System.out.println("");
            System.out.println("5");
        } else if(vastaus > 100) {
            System.out.println("");
            System.out.println("uskomatonta!");
        }
    }
}
