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
public class Ympyra extends Kuvio {

    private int halkaisija;

    public Ympyra(int x, int y, int halkaisija) {
        super(x, y);
        this.halkaisija = halkaisija;
    }
    
    
    
    @Override
    public void piirra(Graphics graphics) {
        graphics.fillOval(this.getX(), this.getY(), halkaisija, halkaisija);
    }
    
}
