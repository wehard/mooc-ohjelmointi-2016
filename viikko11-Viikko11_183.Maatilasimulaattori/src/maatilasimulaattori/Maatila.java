/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatilasimulaattori;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willehard
 */
public class Maatila implements Eleleva {
    
    private String omistaja;
    private Navetta navetta;
    private List<Lehma> lehmat = new ArrayList<>();
    
    public Maatila(String omistaja, Navetta navetta) {
        this.omistaja = omistaja;
        this.navetta = navetta;
    }
    
    public void lisaaLehma(Lehma lehma) {
        this.lehmat.add(lehma);
    }

    @Override
    public void eleleTunti() {
        for(Lehma l : lehmat) {
            l.eleleTunti();
        }
    }
    
    public void hoidaLehmat() {
        this.navetta.hoida(this.lehmat);
    }
    
    public void asennaNavettaanLypsyrobotti(Lypsyrobotti robotti) {
        this.navetta.asennaLypsyrobotti(robotti);
    }
    
    public String getOmistaja() {
        return this.omistaja;
    }
    
    @Override
    public String toString() {
        String ret = "";
        ret += "Maatilan omistaja: " + this.getOmistaja() + "\n";
        ret += "Navetan maitosäiliö: " + this.navetta.toString() + "\n";
        if(this.lehmat.isEmpty()) {
            ret += "Ei lehmia.\n";
        } else {
            ret += "Lehmät:\n";
            for(Lehma l : lehmat) {
                ret += "        " + l.toString() + "\n";
            }
        }
        
        return ret;
    }
    
    
    
    
    
}
