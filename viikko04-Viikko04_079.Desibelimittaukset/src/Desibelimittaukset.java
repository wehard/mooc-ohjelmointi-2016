
import java.util.ArrayList;
import java.util.Scanner;

public class Desibelimittaukset {

    public static void main(String[] args) {
        // HUOM! Älä luo muita Scanner-olioita koodissa
        Scanner lukija = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(10);
        lista.add(15);
        lista.add(20);
        lista.add(25);
        lista.add(30);
        
        
        

        System.out.println("Lukujen keskiarvo on " + keskiarvo(lista));

    }

    public static void lueLuvut(Scanner lukija, ArrayList<Integer> lista) {
        System.out.println("Syötä lukuja, tyhjä syöte lopettaa.");
        while (true) {
            String syote = lukija.nextLine();

            if (syote.equals("")) {
                break;
            }

            int luku = Integer.parseInt(syote);
            lista.add(luku);
        }
    }

    public static ArrayList<Integer> valitseLuvutValilta(ArrayList<Integer> luvut, int pienin, int suurin) {
        ArrayList<Integer> uusi = new ArrayList<>();

        for (int luku : luvut) {
            if (luku >= pienin && luku <= suurin) {
                uusi.add(luku);
            }
        }

        return uusi;
    }

    public static double keskiarvo(ArrayList<Integer> luvut) {
        double keskiarvo = 0.0;
        int summa = 0;
        
        for (int luku : luvut) {
            summa += luku;
        }
        
        keskiarvo = (double)summa / luvut.size();
        

        return keskiarvo;
    }

}
