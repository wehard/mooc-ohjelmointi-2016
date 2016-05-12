/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.Random;

/**
 *
 * @author willehard
 */
public class Lampomittari implements Sensori {

    private boolean paalla = false;

    @Override
    public boolean onPaalla() {
        return paalla;
    }

    @Override
    public void paalle() {
        this.paalla = true;
    }

    @Override
    public void poisPaalta() {
        this.paalla = false;
    }

    @Override
    public int mittaa() {
        if(this.onPaalla()) {
            Random rnd = new Random();
            return -30 + rnd.nextInt(60);
        } else {
            throw new IllegalStateException("Mittari ei ole päällä!");
        }
    }

}
