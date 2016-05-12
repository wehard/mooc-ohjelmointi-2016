
import java.util.Scanner;

public class SalasanaTahtina {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // Toteuta tänne tehtävä "Salasana tähtinä"
        System.out.print("Anna salasanasi: ");
        String salasana = lukija.nextLine();
        System.out.print("Salasanasi on siis ");
        for (int i = 0; i < salasana.length(); i++) {
            System.out.print("*");
        }
        System.out.println("");
    }
}
