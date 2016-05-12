
import java.util.Arrays;

public class Paaohjelma {

    public static void main(String[] args) {
        int[] luvut = {8, 3, 7, 9, 1, 2, 4};
        jarjesta(luvut);
    }

    public static int pienin(int[] taulukko) {
        // kirjoita koodia tähän
        int luku = taulukko[0];
        for (int i : taulukko) {
            if (i < luku) {
                luku = i;
            }
        }
        return luku;
    }

    public static int pienimmanIndeksi(int[] taulukko) {
        int luku = taulukko[0];
        int index = 0;
        for (int i = 0; i < taulukko.length; i++) {
            if (taulukko[i] < luku) {
                luku = taulukko[i];
                index = i;
            }
        }
        return index;
    }

    public static int pienimmanIndeksiAlkaen(int[] taulukko, int aloitusIndeksi) {
        // kirjoita koodia tähän
        int luku = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < taulukko.length; i++) {
            if (i >= aloitusIndeksi) {
                if (taulukko[i] < luku) {
                    luku = taulukko[i];
                    index = i;
                }
            }
        }
        return index;
    }

    public static void vaihda(int[] taulukko, int indeksi1, int indeksi2) {
        // kirjoita koodia tähän
        int temp1 = taulukko[indeksi1];
        int temp2 = taulukko[indeksi2];
        taulukko[indeksi1] = temp2;
        taulukko[indeksi2] = temp1;
    }

    public static void jarjesta(int[] taulukko) {
        for (int i = 0; i < taulukko.length; i++) {

            vaihda(taulukko, i, pienimmanIndeksiAlkaen(taulukko, i));
            System.out.println(Arrays.toString(taulukko));

        }
    }

}
