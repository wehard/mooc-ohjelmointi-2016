
public class Main {

    public static void main(String[] args) {
        // Tässä voit testata metodia
        int[] taulukko = {5, 1, 3, 4, 2};
        tulostaTyylikkaasti(taulukko);
    }

    public static void tulostaTyylikkaasti(int[] taulukko) {
        // Kirjoita koodia tänne
        String tyylikas = "";
        for (int i = 0; i < taulukko.length-1; i++) {
            tyylikas += taulukko[i] + ", ";
        }
        tyylikas += taulukko[taulukko.length-1];
        System.out.println(tyylikas);
    }
}
