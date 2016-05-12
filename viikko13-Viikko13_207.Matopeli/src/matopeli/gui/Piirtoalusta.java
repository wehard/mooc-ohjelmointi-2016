/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matopeli.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import matopeli.domain.Mato;
import matopeli.domain.Omena;
import matopeli.domain.Pala;
import matopeli.peli.Matopeli;

/**
 *
 * @author willehard
 */
public class Piirtoalusta extends JPanel implements Paivitettava {
    
    private Matopeli matoPeli;
    private int palanSivunPituus;

    public Piirtoalusta(Matopeli matoPeli, int palanSivunPituus) {
        this.matoPeli = matoPeli;
        this.palanSivunPituus = palanSivunPituus;
    }
    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        
        Mato mato = this.matoPeli.getMato();
        
        for(Pala pala : mato.getPalat()) {
            g.fill3DRect(pala.getX()*palanSivunPituus, pala.getY()*palanSivunPituus, this.palanSivunPituus, this.palanSivunPituus, false);
        }
        
        g.setColor(Color.RED);
        Omena o = this.matoPeli.getOmena();
        g.fillOval(o.getX()*palanSivunPituus, o.getY()*palanSivunPituus, this.palanSivunPituus, this.palanSivunPituus);
    }

    @Override
    public void paivita() {
        super.repaint();
    }
    
    
}
