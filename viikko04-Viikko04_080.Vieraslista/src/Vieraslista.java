
import java.util.ArrayList;
import java.util.Scanner;

public class Vieraslista {

    public static void main(String[] args) {
        // HUOM! Älä luo muita Scanner-olioita koodissa -- nyt tai muutenkaan :)
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();

        // kun toteutat metodit, voit testata toimintaa täällä
        
        lueNimet(lukija, lista);
        System.out.println("");
        tarkistaNimet(lukija, lista);
        System.out.println("Kiitos!");

    }
    
    public static void lueNimet(Scanner lukija, ArrayList<String> lista) {
        System.out.println("Syötä nimiä vieraslistalle, tyhjä rivi lopettaa.");
        while(true) {
            String nimi = lukija.nextLine();
            if(nimi.equals("")) {
                break;
            }
            lista.add(nimi);
        }
        
    }
    
    public static void tarkistaNimet(Scanner lukija, ArrayList<String> lista) {
        System.out.println("Syötä nimiä, tyhjä rivi lopettaa.");
        while(true) {
            String nimi = lukija.nextLine();
            if(nimi.equals("")) {
                break;
            }
            if(lista.contains(nimi)) {
                System.out.println("Nimi on listalla.");
            }
            else {
                System.out.println("Nimi ei ole listalla.");
            }
        }
    }

}
