/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukija.ehdot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willehard
 */
public class VahintaanYksi implements Ehto {

    List<Ehto> ehdot = new ArrayList<>();

    public VahintaanYksi(Ehto... ehdot) {
        for (Ehto e : ehdot) {
            this.ehdot.add(e);
        }
    }

    @Override
    public boolean toteutuu(String rivi) {
        for (Ehto e : this.ehdot) {
            if (e.toteutuu(rivi)) {
                return true;
            }
        }
        return false;
    }

}
