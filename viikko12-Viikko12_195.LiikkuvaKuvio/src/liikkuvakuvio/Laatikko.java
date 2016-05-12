/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkuvakuvio;

import java.awt.Graphics;

/**
 *
 * @author willehard
 */
public class Laatikko extends Kuvio {

    private int leveys, korkeus;
    
    public Laatikko(int x, int y, int leveys, int korkeus) {
        super(x,y);
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    @Override
    public void piirra(Graphics graphics) {
        graphics.fillRect(this.getX(), this.getY(), leveys, korkeus);
    }
    
}
