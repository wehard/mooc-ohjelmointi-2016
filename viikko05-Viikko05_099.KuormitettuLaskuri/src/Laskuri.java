/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Laskuri {

    private int arvo;
    private int alkuarvo;
    private boolean tarkistus;

    public Laskuri(int alkuarvo, boolean tarkistus) {
        this.alkuarvo = alkuarvo;
        this.arvo = alkuarvo;
        this.tarkistus = tarkistus;
    }

    public Laskuri(int alkuarvo) {
        this.alkuarvo = alkuarvo;
        this.arvo = alkuarvo;
        this.tarkistus = false;
    }

    public Laskuri(boolean tarkistus) {
        this.alkuarvo = 0;
        this.arvo = 0;
        this.tarkistus = tarkistus;
    }

    public Laskuri() {
        this.alkuarvo = 0;
        this.arvo = 0;
        this.tarkistus = false;
    }

    public int arvo() {

        return arvo;
    }

    public void lisaa() {
        arvo++;
    }

    public void lisaa(int lisays) {
        if (lisays < 0) {
            return;
        }
        arvo += lisays;
    }

    public void vahenna() {
        if (arvo <= 0 && tarkistus == true) {
            return;
        }

        arvo--;
    }

    public void vahenna(int vahennys) {

        if (vahennys < 0) {
            return;
        }
        arvo -= vahennys;

        if ((arvo < 0 && tarkistus == true)) {
            arvo = 0;
        }

    }
}
