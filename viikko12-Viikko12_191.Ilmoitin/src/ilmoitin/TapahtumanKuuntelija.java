/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilmoitin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author willehard
 */
public class TapahtumanKuuntelija implements ActionListener {

    private JTextField lahde;
    private JLabel kohde;
    
    public TapahtumanKuuntelija(JTextField lahde, JLabel kohde) {
        this.lahde = lahde;
        this.kohde = kohde;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        this.kohde.setText(this.lahde.getText());
        this.lahde.setText("");
    }
    
}
