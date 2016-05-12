
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Muuntaja {
    
    private ArrayList<Muunnos> muunnokset = new ArrayList<>();
    
    public Muuntaja() {
        
    }
    
    public void lisaaMuunnos(Muunnos muunnos) {
        muunnokset.add(muunnos);
    }
    
    public String muunna(String merkkijono) {
        String muunnettu = merkkijono;
        for(Muunnos m : muunnokset) {
            muunnettu = m.muunna(muunnettu);
        }
        return muunnettu;
    }
    
}
