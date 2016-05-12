
import java.util.Scanner;

public class Paaohjelma {

    // tee ohjelmaasi VAIN YKSI Scanner-olio
    // jos joudut käyttämään Scanneria muualta kuin luontipaikasta, välitä se parametrina

    public static void main(String[] args) {
        
        Scanner lukija = new Scanner(System.in);
        LintuTietokanta tietoKanta = new LintuTietokanta();
        
        boolean lopeta = false;
        
        while(true) {
            System.out.print("? ");
            String komento = lukija.nextLine();
            switch(komento) {
                case "Lisaa" :
                    System.out.print("Nimi: ");
                    String nimi = lukija.nextLine();
                    System.out.print("Latinankielinen nimi: ");
                    String latNimi = lukija.nextLine();
                    tietoKanta.lisaaLintu(new Lintu(nimi, latNimi));
                    break;
                case "Havainto" :
                    System.out.print("Mikä havaittu: ");
                    String havainto = lukija.nextLine();
                    tietoKanta.lisaaHavainto(havainto);
                    break;
                case "Tilasto" :
                    tietoKanta.tulostaTilasto();
                    break;
                case "Nayta" :
                    System.out.print("Mikä? ");
                    String nayta = lukija.nextLine();
                    tietoKanta.tulostaLintu(tietoKanta.haeLintuTietokannastaNimella(nayta));
                    break;
                case "Lopeta" :
                    lopeta = true;
                    break;
            }
            
            if(lopeta) {
                break;
            }
        }
        
        
    }

}
