import java.util.ArrayList;

public class Varianssi {
    // Kopioi tänne tehtävän 70 metodi summa
    public static int summa(ArrayList<Integer> lista) {
        
        int retval = 0;
        for(int summa : lista) {
            retval += summa;
        }
        return retval;
    }
    
    // Kopioi tänne tehtävän 71 metodi keskiarvo
    public static double keskiarvo(ArrayList<Integer> lista) {
        
        int summa = summa(lista);
        double keskiarvo = (double)summa / lista.size();
        
        return keskiarvo;
    }

    public static double varianssi(ArrayList<Integer> lista) {
        // kirjoita koodia tähän
        
        double varianssi = 0.0;
        double keskiarvo = keskiarvo(lista);
        
        for(int luku : lista) {
            varianssi += Math.pow((double)luku - keskiarvo, 2);
        }
        
        varianssi = varianssi / (lista.size() - 1);
            
        
        return varianssi;
    }
    
    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(3);
        lista.add(2);
        lista.add(7);
        lista.add(2);
        
        if(lista.size() > 1) {
            System.out.println("Varianssi: " + varianssi(lista));
        }
        
    }

}
