
import java.util.ArrayList;

public class Varianssi {

    // Tee tänne metodi, joka summaa listan alkiot ja palauttaa summan
    public static int summa(ArrayList<Integer> lista) {
        int summa = 0;
        for (Integer i : lista) {
            summa += i;
        }
        return summa;
    }

    // Tee tänne metodi, joka laskee listan alkioiden keskiarvon ja palauttaa sen
    public static double keskiarvo(ArrayList<Integer> lista) {
        // kirjoita koodia tähän 
        return 1.0 * summa(lista) / lista.size();
    }

    public static double varianssi(ArrayList<Integer> lista) {
        // kirjoita koodia tähän
        double varianssi = 0.0;
        double keskiarvo = keskiarvo(lista);
        for (int i = 0; i < lista.size(); i++) {
            varianssi += Math.pow(lista.get(i) - keskiarvo, 2);
        }
        return varianssi / (lista.size() - 1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(2);
        lista.add(7);
        lista.add(2);

        System.out.println("Varianssi: " + varianssi(lista));
    }

}
