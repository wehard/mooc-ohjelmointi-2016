/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siirrettava;

/**
 *
 * @author willehard
 */
public class Elio implements Siirrettava {

    private int x, y;
    
    public Elio(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    
    
    @Override
    public void siirra(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    public String toString() {
        return "x: " + this.x + "; " + "y: " + this.y;
    }
    
}
