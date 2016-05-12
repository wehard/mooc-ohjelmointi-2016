
import java.util.ArrayList;
import java.util.Collections;

public class Taikanelio {

    private int[][] nelio;

    // valmis konstruktori
    public Taikanelio(int koko) {
        if (koko < 2) {
            koko = 2;
        }

        this.nelio = new int[koko][koko];
    }

    // toteuta nämä kolme metodia
    public ArrayList<Integer> rivienSummat() {
        
        ArrayList<Integer> lista = new ArrayList<>();
        for (int y = 0; y < nelio.length; y++) {
            int rivisumma = 0;
            for (int x = 0; x < nelio[y].length; x++) {
                rivisumma += nelio[y][x];
            }
            lista.add(rivisumma);
        }
        return lista;
    }

    public ArrayList<Integer> sarakkeidenSummat() {
        
        ArrayList<Integer> lista = new ArrayList<>();
        int[] sarakesumma = new int[nelio.length];
        for (int y = 0; y < nelio.length; y++) {
            for (int x = 0; x < nelio[y].length; x++) {
                sarakesumma[x] += nelio[y][x];
            }
        }
        
        for (int i = 0; i < sarakesumma.length; i++) {
            lista.add(sarakesumma[i]);
        }
        return lista;
    }

    public ArrayList<Integer> lavistajienSummat() {
        ArrayList<Integer> lista = new ArrayList<>();
        int lavistajasumma = 0;
        for (int i = 0; i < nelio.length; i++) {
            lavistajasumma += nelio[i][i];
        }
        lista.add(lavistajasumma);
        lavistajasumma = 0;
        
        for (int i = 0; i < nelio.length; i++) {
            lavistajasumma += nelio[nelio.length-i-1][i];
        }
        lista.add(lavistajasumma);
        return lista;
        
        
        
    }

    // valmiit apumetodit -- älä koske näihin
    public boolean onTaikanelio() {
        return summatSamat() && kaikkiNumerotEri();
    }

    public ArrayList<Integer> annaKaikkiNumerot() {
        ArrayList<Integer> numerot = new ArrayList<>();
        for (int y = 0; y < nelio.length; y++) {
            for (int x = 0; x < nelio[y].length; x++) {
                numerot.add(nelio[y][x]);
            }
        }

        return numerot;
    }

    public boolean kaikkiNumerotEri() {
        ArrayList<Integer> numerot = annaKaikkiNumerot();

        Collections.sort(numerot);
        for (int i = 1; i < numerot.size(); i++) {
            if (numerot.get(i - 1) == numerot.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean summatSamat() {
        ArrayList<Integer> summat = new ArrayList<>();
        summat.addAll(rivienSummat());
        summat.addAll(sarakkeidenSummat());
        summat.addAll(lavistajienSummat());

        if (summat.size() < 3) {
            return false;
        }

        for (int i = 1; i < summat.size(); i++) {
            if (summat.get(i - 1) != summat.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int annaArvo(int x, int y) {
        if (x < 0 || y < 0 || x >= getLeveys() || y >= getKorkeus()) {
            return - 1;
        }

        return this.nelio[y][x];
    }

    public void asetaArvo(int x, int y, int arvo) {
        if (x < 0 || y < 0 || x >= getLeveys() || y >= getKorkeus()) {
            return;
        }

        this.nelio[y][x] = arvo;
    }

    public int getLeveys() {
        return this.nelio.length;
    }

    public int getKorkeus() {
        return this.nelio.length;
    }

    @Override
    public String toString() {
        String palautus = "";
        for (int y = 0; y < nelio.length; y++) {
            for (int x = 0; x < nelio[y].length; x++) {
                palautus += nelio[y][x] + "\t";
            }

            palautus += "\n";
        }

        return palautus;
    }
}
