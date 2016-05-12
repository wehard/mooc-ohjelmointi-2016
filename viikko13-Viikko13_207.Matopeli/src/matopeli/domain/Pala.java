/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.domain;

/**
 *
 * @author willehard
 */
public class Pala {

    private int x, y;

    public Pala(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
    
    public boolean osuu(Pala pala) {
        return this.getX() == pala.getX() && this.getY() == pala.getY();
    }

    public String toString() {
        return "(" + this.getX() + "," + this.getY() + ")";
    }
}
