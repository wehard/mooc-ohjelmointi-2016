/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;

/**
 *
 * @author willehard
 */
public class ElokuvaComparator implements Comparator<Elokuva>{

    private Map<Elokuva, List<Arvio>> arviot;
    
    public ElokuvaComparator(Map<Elokuva, List<Arvio>> arviot) {
        this.arviot = arviot;
    }
    
    
    private double keskiarvo(Elokuva e) {
        double k = 0;
        for(Arvio a : this.arviot.get(e)) {
            k += a.getArvo();
        }
        return k / this.arviot.get(e).size();
    }
    
    @Override
    public int compare(Elokuva o1, Elokuva o2) {
        return (int) Math.round(keskiarvo(o2) - keskiarvo(o1));
    }
    
}
