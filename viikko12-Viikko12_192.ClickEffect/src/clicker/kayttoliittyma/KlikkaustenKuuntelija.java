/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clicker.kayttoliittyma;

import clicker.sovelluslogiikka.Laskuri;
import clicker.sovelluslogiikka.OmaLaskuri;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 *
 * @author willehard
 */
public class KlikkaustenKuuntelija implements ActionListener {

    private Laskuri laskuri;
    private JLabel jlabel;

    public KlikkaustenKuuntelija(Laskuri laskuri, JLabel jlabel) {
        this.laskuri = laskuri;
        this.jlabel = jlabel;
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        
        this.laskuri.kasvata();
        this.jlabel.setText(""+this.laskuri.annaArvo());
    }
    
}
