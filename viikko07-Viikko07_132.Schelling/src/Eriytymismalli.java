
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class Eriytymismalli {

    private int[][] taulukko;
    private int leveys;
    private int korkeus;
    private double prosTyhjia;
    private double tyytyvaisyysraja;
    private boolean tyytymattomiaLoytyy;

    public Eriytymismalli(int leveys, int korkeus, double prosTyhjia, double tyytyvaisyysraja) {
        this.leveys = leveys;
        this.korkeus = korkeus;

        this.taulukko = new int[korkeus][leveys];

        this.prosTyhjia = prosTyhjia;
        this.tyytyvaisyysraja = tyytyvaisyysraja;

        this.tyytymattomiaLoytyy = true;
    }

    public int[][] annaData() {
        return this.taulukko;
    }

    public void alusta(int joukkoja) {
        if (joukkoja < 2) {
            joukkoja = 2;
        }

        if (joukkoja > 4) {
            joukkoja = 4;
        }

        asetaKaikkiTyhjiksi();
        arvoAlkuarvot(joukkoja);
    }

    public void asetaKaikkiTyhjiksi() {
        // luo tänne metodi, joka asettaa jokaisen taulukon alkion
        // arvoksi luvun 0
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                taulukko[y][x] = 0;
            }
        }

    }

    public ArrayList<Piste> tyhjatPaikat() {
        ArrayList<Piste> tyhjat = new ArrayList<>();
        // luo täällä lista, missä on kaikki tyhjät paikat piste-olioina
        // tyhjissä paikoissa on arvo 0
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                if (taulukko[y][x] == 0) {
                    Piste uusiPiste = new Piste(x, y);
                    tyhjat.add(uusiPiste);
                }
            }
        }

        return tyhjat;
    }

    public void paivita() {
        ArrayList<Piste> tyytymattomat = haeTyytymattomat();

        if (tyytymattomat.isEmpty()) {
            this.tyytymattomiaLoytyy = false;
            return;
        }

        Collections.shuffle(tyytymattomat);

        while (!tyytymattomat.isEmpty()) {
            Piste tyytymaton = tyytymattomat.remove(0);

            ArrayList<Piste> tyhjat = tyhjatPaikat();
            Collections.shuffle(tyhjat);

            Piste tyhja = tyhjat.get(0);

            this.taulukko[tyhja.getY()][tyhja.getX()] = this.taulukko[tyytymaton.getY()][tyytymaton.getX()];
            this.taulukko[tyytymaton.getY()][tyytymaton.getX()] = 0;
        }
    }

    
    public ArrayList<Piste> haeTyytymattomat() {
        ArrayList<Piste> tyytymattomat = new ArrayList<>();

        for (int y = 0; y < this.korkeus; y++) {
            for (int x = 0; x < this.leveys; x++) {
                if (taulukko[y][x] != 0) {
                    if (!onTyytyvainen(x, y)) {
                        tyytymattomat.add(new Piste(x, y));
                    }
                }

            }

        }
        return tyytymattomat;
    }

    public boolean onTyytyvainen(int x, int y) {

        int naapurit = 0;
        int tamatyyppi = taulukko[y][x];
        int samankaltaisia = 0;

        int xStart = (x == 0) ? x : x - 1;
        int xEnd = (x == leveys-1) ? x : x + 2;
        int yStart = (y == 0) ? y : y - 1;
        int yEnd = (y == korkeus-1) ? y : y + 2;

        for (int j = yStart; j < yEnd; j++) {
            for (int i = xStart; i < xEnd; i++) {
                naapurit++;
                if (this.taulukko[j][i] == tamatyyppi) {
                    samankaltaisia++;
                }
            }

        }
        double luku = (double) samankaltaisia / naapurit;
        //System.out.println(luku);
        return luku > tyytyvaisyysraja;
    }
    

    public void arvoAlkuarvot(int joukkoja) {
        Random arpoja = new Random();

        ArrayList<Piste> tyhjat = tyhjatPaikat();
        Collections.shuffle(tyhjat);

        for (int i = 0; i < (1.0 - prosTyhjia) * tyhjat.size(); i++) {
            int x = tyhjat.get(i).getX();
            int y = tyhjat.get(i).getY();
            this.taulukko[y][x] = 1 + arpoja.nextInt(joukkoja);
        }
    }

    public boolean tyytymattomiaLoytyy() {
        return tyytymattomiaLoytyy;
    }

}
