/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willehard
 */
public class Keskiarvosensori implements Sensori {

    private List<Sensori> sensorit = new ArrayList<>();
    private List<Integer> mittaukset = new ArrayList<>();

    public void lisaaSensori(Sensori lisattava) {
        this.sensorit.add(lisattava);
        
    }

    @Override
    public boolean onPaalla() {
        for (Sensori s : sensorit) {
            if (!s.onPaalla() || sensorit.isEmpty()) {
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    @Override
    public void paalle() {
        for (Sensori s : sensorit) {
            s.paalle();
        }
    }

    @Override
    public void poisPaalta() {
        for (Sensori s : sensorit) {
            s.poisPaalta();
        }
    }

    @Override
    public int mittaa() {
        if (!this.onPaalla() || this.sensorit.isEmpty()) {
            throw new IllegalStateException("Ei ole päällä tai ei ole lisättyjä sensoreita");
        }
        int keskiarvo = 0;
        for (Sensori s : sensorit) {
            keskiarvo += s.mittaa();
        }
        keskiarvo /= sensorit.size();
        this.mittaukset.add(keskiarvo);
        return keskiarvo;
    }

    public List<Integer> mittaukset() {

        return this.mittaukset;
    }

}
