/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.domain;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import matopeli.Suunta;

/**
 *
 * @author willehard
 */
public class Mato {

    private int alkuX, alkuY;
    private Suunta alkusuunta;
    private Suunta suunta;

    private List<Pala> palat;

    private boolean saakasvaa = false;

    public Mato(int alkuX, int alkuY, Suunta alkusuunta) {
        this.palat = new ArrayList<>();
        this.alkuX = alkuX;
        this.alkuY = alkuY;
        this.alkusuunta = alkusuunta;
        this.suunta = this.alkusuunta;
        this.palat.add(new Pala(this.alkuX, this.alkuY));
    }

    public Suunta getSuunta() {
        return this.suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public int getPituus() {
        return this.palat.size();
    }

    public List<Pala> getPalat() {
        return this.palat;
    }

    public void liiku() {
        Pala vanhapaa = this.getPalat().get(this.getPituus() - 1);
        Pala vanhahanta = this.getPalat().get(0);

        if (this.suunta == Suunta.ALAS) {
            this.getPalat().add(new Pala(vanhapaa.getX(), vanhapaa.getY() + 1));
        }
        if (this.suunta == Suunta.OIKEA) {
            this.getPalat().add(new Pala(vanhapaa.getX() + 1, vanhapaa.getY()));
        }
        if (this.suunta == Suunta.VASEN) {
            this.getPalat().add(new Pala(vanhapaa.getX() - 1, vanhapaa.getY()));
        }
        if (this.suunta == Suunta.YLOS) {
            this.getPalat().add(new Pala(vanhapaa.getX(), vanhapaa.getY() - 1));
        }

        if (!this.saakasvaa && this.getPituus() > 3) {
            this.getPalat().remove(vanhahanta);
        } else {
            this.saakasvaa = false;
        }

    }

    public void kasva() {
        this.saakasvaa = true;
    }

    public boolean osuu(Pala pala) {
        for (Pala p : this.getPalat()) {
            if (p != pala && p.osuu(pala)) {
                return true;
            }
        }
        return false;
    }

    public boolean osuuItseensa() {
        return this.osuu(this.getPalat().get(this.getPituus() - 1));
    }
}
