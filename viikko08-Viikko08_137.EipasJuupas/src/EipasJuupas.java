
import java.util.Scanner;

public class EipasJuupas {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Toteuta tänne tehtävä "Eipäs Juupas"

       
            System.out.print("Anna eka: ");
            String eka = lukija.nextLine();
            System.out.print("Anna toka: ");
            String toka = lukija.nextLine();
            if(eka.equals(toka)) {
                System.out.println("Olipas!");
                System.out.println("No eipäs ollut!");
                System.out.println("Juupas!");
            } else {
                System.out.println("Eipäs ollut!");
                System.out.println("Juupas!");
                System.out.println("Eipäs!");
            }
        
    }
}
