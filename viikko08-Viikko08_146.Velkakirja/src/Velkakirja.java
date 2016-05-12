
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Velkakirja {
    
    private HashMap<String, Double> velat = new HashMap<>();
    
    public Velkakirja() {
        
    }
    
    public void asetaLaina(String kenelle, double maara) {
        velat.put(kenelle, maara);
    }
    
    public double paljonkoVelkaa(String kuka) {
        if(velat.containsKey(kuka)) {
            return velat.get(kuka);
        }
        return 0.0;
    }
    
}
