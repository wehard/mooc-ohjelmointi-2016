
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Hattu {
    
     private List<Integer> pallot;

    public Hattu() {
        this.pallot = new ArrayList<>();
        this.pallot.add(1);
        this.pallot.add(2);
        this.pallot.add(3);
        
    }
     
    public void otaPallo(int i) {
        this.pallot.remove(i);
    }
    
    public void laitaPallo(int i) {
        this.pallot.add(i);
    }
    
}
