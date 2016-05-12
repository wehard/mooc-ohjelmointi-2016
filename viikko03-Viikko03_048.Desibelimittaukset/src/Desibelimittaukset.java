
import java.util.Locale;
import java.util.Scanner;

public class Desibelimittaukset {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta tänne ohjelma, joka laskee desibelimittausten keskiarvoja
        // Huomaa että ohjelmassa ei ole paikallisia testejä, vaan ohjelman
        // toiminta tarkastetaan palvelimella
        
        System.out.println("Anna desibelilukuja, lopeta luvulla 9999.");
        
        int lukujenSumma = 0;
        int annettujaLukuja = 0;
        
        while(true) {
            
            System.out.println("Anna desibeliluku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            
            if(luku == 9999 && annettujaLukuja <= 0) {
                System.out.println("Yhtään desibelilukua ei syötetty.");
                break;
            } else if (luku == 9999) {
                double keskiarvo = 1.0 * lukujenSumma / annettujaLukuja;
                System.out.println("Desibelilukujen keskiarvo on " + keskiarvo);
                break;
            }
            
            if(luku >= 0 && luku < 9999) {
                
                lukujenSumma += luku;
                annettujaLukuja++;
            }
            
            
        }
        
        
    }
}
