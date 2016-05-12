/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

/**
 *
 * @author willehard
 */
public class YhdenTavaranLaatikko extends Laatikko {

    private Tavara tavara = null;
    
    public YhdenTavaranLaatikko() {
        
    }
    
    @Override
    public void lisaa(Tavara tavara) {
        if(this.tavara == null) {
            this.tavara = tavara;
        }
        
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return tavara.equals(this.tavara);
    }
    
}
