
public class Lukutilasto {

    private int lukujenMaara;
    private int summa;

    public Lukutilasto() {
        // alusta tässä muuttuja lukujenMaara
        this.lukujenMaara = 0;
        this.summa = 0;

    }

    public void lisaaLuku(int luku) {
        // kirjoita koodia tähän
        lukujenMaara++;
        summa += luku;
    }

    public int haeLukujenMaara() {
        // kirjoita koodia tähän
        return lukujenMaara;
    }

    public int summa() {
        // kirjoita koodia tähän
        return summa;

    }

    public double keskiarvo() {
        // kirjoita koodia tähän

        if (lukujenMaara == 0) {
            return 0;
        }
        return (double) summa / lukujenMaara;

    }

}
