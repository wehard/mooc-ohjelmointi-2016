
public class Hymiot {

    public static void main(String[] args) {
        // Testaa metodisi toimintaa ainakin seuraavilla kutsuilla
        tulostaHymioityna("Metodi");
        tulostaHymioityna("Hajautustaulu");
        tulostaHymioityna("Rajapinta");

    }

    private static void tulostaHymioityna(String merkkijono) {

        int pituus = merkkijono.length() + 6;

        if (merkkijono.length() % 2 == 1) {
            pituus++;
            merkkijono += " ";
        }

        for (int i = 0; i < pituus / 2; i++) {
            System.out.print(":)");
        }
        System.out.println("");
        System.out.println(":) " + merkkijono + " :)");

        for (int i = 0; i < pituus / 2; i++) {
            System.out.print(":)");
        }
        System.out.println("");

    }

}
