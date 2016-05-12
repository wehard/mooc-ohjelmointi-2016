/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package siirrettava;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author willehard
 */
public class Lauma implements Siirrettava {

    private List<Siirrettava> eliot = new ArrayList<>();
    
    
    public void lisaaLaumaan(Siirrettava siirrettava) {
        eliot.add(siirrettava);
    }
    
    @Override
    public void siirra(int dx, int dy) {
        for(Siirrettava s: eliot) {
            s.siirra(dx, dy);
        }
    }
    
    public String toString() {
        String str = "";
        for(Siirrettava s : eliot) {
            str+=s.toString() + "\n";
        }
        return str;
    }
}
