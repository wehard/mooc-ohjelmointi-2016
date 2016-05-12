
public class Tulostelua {

    public static void tulostaTahtia(int maara) {
        // 40.1
        for (int i = 0; i < maara; i++) {
            System.out.print("*");
        }
        System.out.println("");
    }

    public static void tulostaTyhjaa(int maara) {
        // 40.1
        for (int i = 0; i < maara; i++) {
            System.out.print(" ");
        }
    }

    public static void tulostaKolmio(int koko) {
        // 40.2
        for (int i = 0; i < koko; i++) {
            tulostaTyhjaa(koko-1-i);
            tulostaTahtia(i+1);
        }
    }

    public static void jouluKuusi(int korkeus) {
        // 40.3

        for (int i = 1; i < korkeus+1; i++) {
            tulostaTyhjaa(korkeus-i);
            tulostaTahtia(i*2-1);
        }
        tulostaTyhjaa(korkeus-2);
        tulostaTahtia(3);
        
        tulostaTyhjaa(korkeus-2);
        tulostaTahtia(3);
        
    }

    public static void main(String[] args) {
        // Testit eivät katso main-metodia, voit muutella tätä vapaasti.

        tulostaKolmio(5);
        System.out.println("---");
        jouluKuusi(4);
        System.out.println("---");
        jouluKuusi(10);
    }
}
