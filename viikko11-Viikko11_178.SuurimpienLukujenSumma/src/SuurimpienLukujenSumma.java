
import java.util.ArrayList;
import java.util.List;

public class SuurimpienLukujenSumma {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä

        List<Integer> luvut1 = new ArrayList<>();
        List<Integer> luvut2 = new ArrayList<>();
        luvut1.add(7);
        luvut1.add(2);
        luvut1.add(9);

        luvut2.add(11);
        luvut2.add(12);
        luvut2.add(5);

        List<List<Integer>> listat = new ArrayList<>();
        listat.add(luvut1);
        listat.add(luvut2);

        System.out.println(suurimpienLukujenSumma(listat)); // tulostaa 21
    }

    public static int suurimpienLukujenSumma(List<List<Integer>> lukulistat) {
        // toteuta metodin toiminnallisuus tänne

        List<Integer> suurimmatLuvut = new ArrayList<>();

        for (int i = 0; i < lukulistat.size(); i++) {
            int suurin = 0;
            for (Integer j : lukulistat.get(i)) {
                if (j > suurin) {
                    suurin = j;
                }
            }
            suurimmatLuvut.add(suurin);
        }
        int summa = 0;
        for (Integer i : suurimmatLuvut) {
            summa += i;
        }

        return summa;
    }
}
