/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Sivari implements Palvelusvelvollinen {

    private int tj;

    public Sivari() {
        this.tj = 362;
    }

    @Override
    public int getTJ() {
        return this.tj;
    }

    @Override
    public void palvele() {
        if (tj > 0) {
            tj--;
        }
    }

}
