
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // tee tänne pääohjelma
        ArrayList<Opiskelija> lista = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);
        while (true) {
            System.out.print("Nimi:");
            String nimi = lukija.nextLine();

            if (nimi.equals("")) {
                break;
            }

            System.out.print("Opiskelijanumero:");
            String numero = lukija.nextLine();

            lista.add(new Opiskelija(nimi, numero));
        }
        
        for(Opiskelija op : lista) {
            System.out.println(op.toString());
        }
        
        System.out.println("");
        System.out.print("Anna hakusana: ");
        String haku = lukija.nextLine();
        
        
        System.out.println("Tulokset:");
        for(Opiskelija op : lista) {
            if(op.haeNimi().contains(haku)) {
                System.out.println(op.toString());
            }
        }
        
        
        
        
    }
    
}
