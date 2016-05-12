/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liikkuvakuvio;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author willehard
 */
public class Piirtoalusta extends JPanel {
    
    private Kuvio kuvio;

    public Piirtoalusta(Kuvio kuvio) {
        this.kuvio = kuvio;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.kuvio.piirra(g);
    }
    
}
