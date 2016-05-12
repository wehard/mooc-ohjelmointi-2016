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
public abstract class Kuvio {

    protected int x, y;

    public Kuvio(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void siirra(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public abstract void piirra(Graphics graphics);
}
