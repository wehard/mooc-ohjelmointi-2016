/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import matopeli.Suunta;
import matopeli.domain.Mato;

/**
 *
 * @author willehard
 */
public class Nappaimistonkuuntelija implements KeyListener {
 
    private Mato mato;

    public Nappaimistonkuuntelija(Mato mato) {
        this.mato = mato;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            this.mato.setSuunta(Suunta.YLOS);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.mato.setSuunta(Suunta.ALAS);
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.mato.setSuunta(Suunta.VASEN);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.mato.setSuunta(Suunta.OIKEA);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
}
