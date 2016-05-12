
import java.util.Scanner;

public class KolmenLuvunSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int summa = 0;
        int luettu;

        
        // KIRJOITA OHJELMA TÄHÄN
        // ÄLÄ KÄYTÄ MUITA MUUTTUJIA KUIN lukija, summa JA luettu!

        System.out.print("Anna ensimmäinen luku: ");
        luettu = Integer.parseInt(lukija.nextLine());
        summa += luettu;
        
        System.out.print("Anna toinen luku: ");
        luettu = Integer.parseInt(lukija.nextLine());
        summa += luettu;
        
        System.out.print("Anna kolmas luku: ");
        luettu = Integer.parseInt(lukija.nextLine());
        summa += luettu;
        
        System.out.println("");
        
        System.out.println("Summa: " + summa);
    }
}
