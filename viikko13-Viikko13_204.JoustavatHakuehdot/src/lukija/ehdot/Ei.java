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
public class Ei implements Ehto {

    private Ehto ehto;

    public Ei(Ehto ehto) {
        this.ehto = ehto;
    }
    
    @Override
    public boolean toteutuu(String rivi) {
        return !this.ehto.toteutuu(rivi);
    }
    
}
