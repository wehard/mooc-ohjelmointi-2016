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
public class Molemmat implements Ehto {
    
    private Ehto ensimmainenEhto;
    private Ehto toinenEhto;

    public Molemmat(Ehto ensimmainenEhto, Ehto toinenEhto) {
        this.ensimmainenEhto = ensimmainenEhto;
        this.toinenEhto = toinenEhto;
    }

    
    
    @Override
    public boolean toteutuu(String rivi) {
        return this.ensimmainenEhto.toteutuu(rivi) && this.toinenEhto.toteutuu(rivi);
    }
    
}
