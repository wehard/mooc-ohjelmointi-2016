
import java.util.ArrayList;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // tee ohjelmasi tänne
        // älä kuitenkaan tee kaikkea koodia mainiin, vaan suunnittele ohjelmalle järkevä rakenne
        // ÄLÄ tee ohjelmaasi muita Scannereita kuin tässä luotu
        // jos joudut käyttämään Scanneria muusta metodista, välitä se parametrina tehtävän 73 tapaan
        ArrayList<Integer> lista = new ArrayList<>();
        lista = haeArvosanatKayttajalta(lukija);
        tulostaArvosanaJakauma(lista);

    }

    public static ArrayList<Integer> haeArvosanatKayttajalta(Scanner lukija) {
        ArrayList<Integer> lista = new ArrayList<>();
        System.out.println("Syötä koepisteet, -1 lopettaa:");
        while (true) {

            int luku = Integer.parseInt(lukija.nextLine());
            if (luku != -1) {
                if (luku > 60 || luku < 0) {
                    continue;
                } else {
                    lista.add(luku);
                }

            } else {
                break;
            }
        }
        return lista;
    }

    public static void tulostaArvosanaJakauma(ArrayList<Integer> arvosanaLista) {
        int[] arvosanat = new int[6];
        int hyvaksytyt = 0;
        for (int i : arvosanaLista) {
            if (i > 60) {
                continue;
            }
            if (i < 0) {
                continue;
            }
            if (i >= 50) {
                arvosanat[5]++;
                hyvaksytyt++;
                continue;
            }
            if (i >= 45) {
                arvosanat[4]++;
                hyvaksytyt++;
                continue;
            }
            if (i >= 40) {
                arvosanat[3]++;
                hyvaksytyt++;
                continue;
            }
            if (i >= 35) {
                arvosanat[2]++;
                hyvaksytyt++;
                continue;
            }
            if (i >= 30) {
                arvosanat[1]++;
                hyvaksytyt++;
                continue;
            }
            if (i <= 29) {
                arvosanat[0]++;
                continue;
            }

        }
        System.out.println("Arvosanajakauma:");
        for (int i = arvosanat.length - 1; i >= 0; i--) {
            System.out.print(i + ": ");
            for (int j = 0; j < arvosanat[i]; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        double hProsentti = 100.0 * hyvaksytyt / arvosanaLista.size();
        System.out.println("Hyväksymisprosentti: " + hProsentti);
    }
}
