
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DesibelimittauksetTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.println("Minkä niminen tiedosto luetaan? ");
        String tiedosto = lukija.nextLine();

        ArrayList<Integer> lista = lueLuvut(tiedosto);
        lista = valitseLuvutValilta(lista, 0, Integer.MAX_VALUE);

        if (lista.isEmpty()) {
            System.out.println("Ei lukuja.");
        } else {
            System.out.println("Lukujen keskiarvo: " + keskiarvo(lista));
        }
    }

    // toteuta tänne metodi lueLuvut
    public static ArrayList<Integer> lueLuvut(String tiedosto) {
        ArrayList<Integer> luvut = new ArrayList<>();
        try (Scanner lukija = new Scanner(new File(tiedosto))) {
            while (lukija.hasNextLine()) {
                luvut.add(lukija.nextInt());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DesibelimittauksetTiedostosta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return luvut;
    }

    // valmiit metodit
    public static ArrayList<Integer> valitseLuvutValilta(ArrayList<Integer> luvut, int pienin, int suurin) {
        ArrayList<Integer> palautettava = new ArrayList<>();
        for (Integer luku : luvut) {
            if (luku >= pienin && luku <= suurin) {
                palautettava.add(luku);
            }
        }

        return palautettava;
    }

    public static double keskiarvo(ArrayList<Integer> luvut) {
        int summa = 0;

        for (Integer luku : luvut) {
            summa += luku;
        }

        return 1.0 * summa / luvut.size();
    }
}
