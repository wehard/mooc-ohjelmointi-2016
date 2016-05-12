/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muuttaminen.logiikka;

import java.util.ArrayList;
import java.util.List;
import muuttaminen.domain.Muuttolaatikko;
import muuttaminen.domain.Tavara;

/**
 *
 * @author willehard
 */
public class Pakkaaja {

    private int laatikoidenTilavuus;
    
    public Pakkaaja(int laatikoidenTilavuus) {
        this.laatikoidenTilavuus = laatikoidenTilavuus;
    }
    
    public List<Muuttolaatikko> pakkaaTavarat(List<Tavara> tavarat) {
        List<Muuttolaatikko> laatikot = new ArrayList<>();
        
        Muuttolaatikko l = new Muuttolaatikko(this.laatikoidenTilavuus);
        laatikot.add(l);
        for (Tavara t : tavarat) {
            if(l.lisaaTavara(t)) {
                //System.out.println("lisatty");
            } else {
                
                l = new Muuttolaatikko(this.laatikoidenTilavuus);
                laatikot.add(l);
                l.lisaaTavara(t);
                
            }
        }
        return laatikot;
    }
}
