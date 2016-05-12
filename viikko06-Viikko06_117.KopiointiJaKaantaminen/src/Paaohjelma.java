
import java.util.Arrays;

public class Paaohjelma {

    public static void main(String[] args) {
        int[] alkuperainen = {1, 2, 3, 4};
        int[] kaannetty = kaanna(alkuperainen);

        // tulostetaan molemmat
        System.out.println("alkup: " + Arrays.toString(alkuperainen));
        System.out.println("käännetty: " + Arrays.toString(kaannetty));
    }

     

    public static int[] kopioi(int[] taulukko) {
        int[] uusi = new int[taulukko.length];
        for (int i = 0; i < uusi.length; i++) {
            uusi[i] = taulukko[i];
        }
        return uusi;
    }

    public static int[] kaanna(int[] taulukko) {
        int[] uusi = new int[taulukko.length];
        for (int i = 0; i < uusi.length; i++) {
            uusi[uusi.length - 1 - i] = taulukko[i];
        }
        return uusi;
    }

}
