import java.util.ArrayList;

public class Suurin {
    public static int suurin(ArrayList<Integer> lista) {
        // kirjoita koodia tähän
        
        int suurin = Integer.MIN_VALUE;
        
        for(int element : lista) {
            if(element > suurin) {
                suurin = element;
            }
        }
        
        return suurin;
    }

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(2);
        lista.add(7);
        lista.add(2);
        
        System.out.println("Suurin: " + suurin(lista));
    }
}