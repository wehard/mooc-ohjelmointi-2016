
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Testaa ohjelmasi toimintaa täällä!

        Scanner lukija = new Scanner(System.in);
        List<Double> sadeMaarat = new ArrayList<>();

        System.out.println("Anna sademääriä, lopeta luvulla 999999.");
        boolean lopeta = false;
        while (!lopeta) {
            System.out.println("Anna sademäärä:");
            Double uusiSadeMaara = Double.parseDouble(lukija.nextLine());
            if(uusiSadeMaara == 999999) {
                lopeta = true;
            } else {
                sadeMaarat.add(uusiSadeMaara);
            }
        }
        
        double keskiarvo = 0;
        
        for(Double d : sadeMaarat) {
            keskiarvo += d;
        }
        keskiarvo /= sadeMaarat.size();
        
        if(sadeMaarat.size() < 1) {
            System.out.println("Yhtään sademäärää ei syötetty.");
        } else {
            System.out.println("Sademäärien keskiarvo on " + keskiarvo);
        }

    }
}
