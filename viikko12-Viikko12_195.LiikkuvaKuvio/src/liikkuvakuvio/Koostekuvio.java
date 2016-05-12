/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkuvakuvio;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author willehard
 */
public class Koostekuvio extends Kuvio {

    private ArrayList<Kuvio> kuviot = new ArrayList<>();

    public Koostekuvio() {
        super(1, 1);
    }

    public void liita(Kuvio k) {
        this.kuviot.add(k);
    }

    @Override
    public void siirra(int dx, int dy) {
        for (Kuvio k : kuviot) {
            k.siirra(dx, dy);
        }
    }

    @Override
    public void piirra(Graphics graphics) {
        for (Kuvio k : kuviot) {
            k.piirra(graphics);
        }
    }

}
