
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
public class Pakkaus {
    
    private ArrayList<Lahja> lahjat = new ArrayList<>();
    
    
    public Pakkaus() {
        
    }
    
    public void lisaaLahja(Lahja lahja) {
        lahjat.add(lahja);
    }
    
    public int getPaino() {
        int paino = 0;
        for(Lahja l : lahjat) {
            paino += l.getPaino();
        }
        return paino;
    }
    
    
}
