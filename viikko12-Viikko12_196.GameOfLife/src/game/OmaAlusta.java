/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeAlusta;
import java.util.Random;

/**
 *
 * @author willehard
 */
public class OmaAlusta extends GameOfLifeAlusta {

    public OmaAlusta(int leveys, int korkeus) {
        super(leveys, korkeus);

    }

    @Override
    public void alustaSatunnaisetPisteet(double todennakoisyysPisteelle) {
        if (todennakoisyysPisteelle < 0.0) {
            todennakoisyysPisteelle = 0.0;
        }
        if (todennakoisyysPisteelle > 1.0) {
            todennakoisyysPisteelle = 1.0;
        }

        Random rnd = new Random();
        for (int x = 0; x < this.getLeveys(); x++) {
            for (int y = 0; y < this.getKorkeus(); y++) {
                super.getAlusta()[x][y] = rnd.nextDouble() < todennakoisyysPisteelle;
            }
        }
    }

    @Override
    public boolean onElossa(int x, int y) {
        if (!this.onkoAlueella(x, y)) {
            return false;
        }
        return this.getAlusta()[x][y];
    }

    @Override
    public void muutaElavaksi(int x, int y) {
        if (this.onkoAlueella(x, y)) {
            super.getAlusta()[x][y] = true;
        }

    }

    @Override
    public void muutaKuolleeksi(int x, int y) {
        if (this.onkoAlueella(x, y)) {
            super.getAlusta()[x][y] = false;
        }
    }

    @Override
    public int getElossaOlevienNaapurienLukumaara(int x, int y) {
        int elossaOlevatNaapurit = 0;
        if (this.onElossa(x - 1, y - 1)) {
            elossaOlevatNaapurit++;
        }
        if (this.onElossa(x, y - 1)) {
            elossaOlevatNaapurit++;
        }
        if (this.onElossa(x + 1, y - 1)) {
            elossaOlevatNaapurit++;
        }
        if (this.onElossa(x + 1, y)) {
            elossaOlevatNaapurit++;
        }
        if (this.onElossa(x + 1, y + 1)) {
            elossaOlevatNaapurit++;
        }
        if (this.onElossa(x, y + 1)) {
            elossaOlevatNaapurit++;
        }
        if (this.onElossa(x - 1, y + 1)) {
            elossaOlevatNaapurit++;
        }
        if (this.onElossa(x - 1, y)) {
            elossaOlevatNaapurit++;
        }
        return elossaOlevatNaapurit;
    }

    @Override
    public void hoidaSolu(int x, int y, int elossaOleviaNaapureita) {
        if (this.onElossa(x, y)) {
            if (elossaOleviaNaapureita < 2) {
                this.muutaKuolleeksi(x, y);
                return;
            }
            if (elossaOleviaNaapureita == 2 || elossaOleviaNaapureita == 3) {
                return;
            }
            if (elossaOleviaNaapureita > 3) {
                this.muutaKuolleeksi(x, y);
                return;
            }
        } else if (elossaOleviaNaapureita == 3) {
            this.muutaElavaksi(x, y);
            return;
        }

    }

    private boolean onkoAlueella(int x, int y) {
        if (x >= 0 && x <= this.getLeveys() - 1 && y >= 0 && y <= this.getKorkeus() - 1) {
            return true;
        } else {
            return false;
        }
    }

}
