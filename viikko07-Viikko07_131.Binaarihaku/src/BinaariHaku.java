
import java.util.Arrays;

public class BinaariHaku {

    public static boolean hae(int[] taulukko, int etsittavaLuku) {
        int alku = 0;
        int loppu = taulukko.length - 1;

        // tarvitset ainakin toistolauseen, missä katsotaan aina taulukon
        // keskimmäistä alkiota, sekä jonkinlaisen toiminnallisuuden
        // hakualueen jatkuvaan pienentämiseen
       
        while(alku <= loppu) {
            int keskiIndeksi = (alku + loppu) / 2;
            if(etsittavaLuku == taulukko[keskiIndeksi]) {
                return true;
            }
            if(taulukko[keskiIndeksi] > etsittavaLuku) {
                loppu = keskiIndeksi - 1;
            } else {
                alku = keskiIndeksi + 1;
            }
        }
        return false;
    }
}
