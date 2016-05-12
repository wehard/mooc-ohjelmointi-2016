
import java.util.ArrayList;

public class LukujenKeskiarvo {

    // Kopioi tänne edellisen tehtävän metodi summa
    public static int summa(ArrayList<Integer> lista) {
        // Kirjoita koodia tänne
        int retval = 0;
        for(int summa : lista) {
            retval += summa;
        }
        return retval;
    }
    

    public static double keskiarvo(ArrayList<Integer> lista) {
        // kirjoita koodia tähän
        int summa = summa(lista);
        double keskiarvo = (double)summa / lista.size();
        
        return keskiarvo;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(2);
        lista.add(7);
        lista.add(2);

        System.out.println("Keskiarvo: " + keskiarvo(lista));
    }
}