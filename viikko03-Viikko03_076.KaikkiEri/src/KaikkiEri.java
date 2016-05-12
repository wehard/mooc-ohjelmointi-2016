
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class KaikkiEri {

    public static boolean kaikkiEri(ArrayList<Integer> luvut) {
        // kirjoita koodia tähän
        ArrayList<Integer> temp = new ArrayList<>(luvut);
        
        Collections.sort(temp);
        
        int current = temp.get(0);
        
        for (int i = 0; i < temp.size(); i++) {
            
            if(temp.get(i) == current && i > 0) {
                
                return false;
                
            }
            
            current = temp.get(i);
        }
        
        return true;
    }

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Integer> luvut = new ArrayList<>();

        System.out.println("Anna lukuja, -99 lopettaa:");

        while (true) {
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == -99) {
                break;
            }
            luvut.add(luku);
        }

        if (kaikkiEri(luvut)) {
            System.out.println("Kaikki syöttämäsi luvut olivat erisuuruisia");
        } else {
            System.out.println("Syöttämiesi lukujen joukossa oli samansuuruisia");
        }
    }
}
