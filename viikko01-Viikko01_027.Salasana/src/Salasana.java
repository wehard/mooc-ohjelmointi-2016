
import java.util.Scanner;

public class Salasana {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        String salasana = "porkkana"; // käytä porkkanaa salasanana testejä ajaessasi!

        
        // Toteuta ohjelmasi tähän.
        
        System.out.print("Anna salasana: ");
        String uusiSalasana = lukija.nextLine();
        
        while (!uusiSalasana.equals(salasana))  {
            System.out.println("Väärin!");
            System.out.print("Anna salasana: ");
            uusiSalasana = lukija.nextLine();
        }
        System.out.println("Oikein!");
        System.out.println("");
        System.out.println("Salaisuus on: znvavbfgv grugl!");
        
        
    }
}
