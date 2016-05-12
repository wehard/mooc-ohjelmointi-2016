/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilot;

/**
 *
 * @author willehard
 */
public class Opiskelija extends Henkilo { 
    
    private int opintoPisteet;
    
    public Opiskelija(String nimi, String osoite) {
        super(nimi, osoite);
        this.opintoPisteet = 0;
    }
    
    public void opiskele() {
        this.opintoPisteet++;
    }
    
    public int opintopisteita() {
        return this.opintoPisteet;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n  opintopisteitä " + this.opintopisteita();
    }
    
}
