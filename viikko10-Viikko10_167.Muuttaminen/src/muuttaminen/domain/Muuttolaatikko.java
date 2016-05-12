/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muuttaminen.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willehard
 */
public class Muuttolaatikko implements Tavara {
    
    private int maksimitilavuuus;
    private List<Tavara> tavarat = new ArrayList<>();
    
    public Muuttolaatikko(int maksimitilavuus) {
        this.maksimitilavuuus = maksimitilavuus;
    }
    
    public boolean lisaaTavara(Tavara tavara) {
        if(this.getTilavuus() + tavara.getTilavuus() > this.maksimitilavuuus) {
            return false;
        } else {
            this.tavarat.add(tavara);
        }
        
        return true;
    }
    
    @Override
    public int getTilavuus() {
        int i = 0;
        for(Tavara t : tavarat) {
            i+=t.getTilavuus();
        }
        return i;
    }
}
