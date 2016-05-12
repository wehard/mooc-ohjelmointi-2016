/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkuvakuvio;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author willehard
 */
public class NappaimistonKuuntelija implements KeyListener {
    
    private Component component;
    private Kuvio kuvio;

    public NappaimistonKuuntelija(Component component, Kuvio kuvio) {
        this.component = component;
        this.kuvio = kuvio;
    }
    
    

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.kuvio.siirra(-1, 0);
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.kuvio.siirra(1, 0);
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            this.kuvio.siirra(0, -1);
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.kuvio.siirra(0, 1);
        }
        this.component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
