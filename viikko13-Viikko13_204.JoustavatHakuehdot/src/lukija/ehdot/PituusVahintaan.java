/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukija.ehdot;

/**
 *
 * @author willehard
 */
public class PituusVahintaan implements Ehto {

    private int pituus;

    public PituusVahintaan(int pituus) {
        this.pituus = pituus;
    }
    
    
    
    @Override
    public boolean toteutuu(String rivi) {
        return rivi.length() >= pituus;
    }
    
}
