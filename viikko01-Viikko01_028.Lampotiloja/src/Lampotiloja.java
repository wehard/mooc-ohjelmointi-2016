
import java.util.Scanner;

public class Lampotiloja {

    public static void main(String[] args) {

        Scanner lukija = new Scanner(System.in);
        // Toteuta lämpötilaohjelma tähän.

        // Näin kuvaajaa käytetään:
//        Kuvaaja.lisaaNumero(7);
//        double luku = 13.5;
//        Kuvaaja.lisaaNumero(luku);
//        luku = 3;
//        Kuvaaja.lisaaNumero(luku);
        // poista tai kommentoi nämä esimerkkikomennot ennenkuin teet ohjelmasi!
        // saat kommentoitua rivit helposti maalaamalla ne hiirellä ja painamalla yhtä aikaa ctrl, shift ja c
    
        System.out.print("Anna luku: ");
        double luku = Double.parseDouble(lukija.nextLine());
        
        
        while(luku >= -1000) {
            
            if(luku >= -30 && luku <= 40 ) {
                Kuvaaja.lisaaNumero(luku);
            }
            System.out.print("Anna luku: ");
            luku = Double.parseDouble(lukija.nextLine());
        }
            
        
        
    
    
    }
}
