/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatilasimulaattori;

/**
 *
 * @author willehard
 */
public class Lypsyrobotti {
    
    private Maitosailio sailio;
    
    public Lypsyrobotti() {
        
    }
    
    public Maitosailio getMaitosailio() {
        return this.sailio;
    }
    
    public void setMaitosailio(Maitosailio maitosailio) {
        this.sailio = maitosailio;
    }
    
    public void lypsa(Lypsava lypsava) {
        try {
            this.sailio.lisaaSailioon(lypsava.lypsa());
            
        } catch (Exception e) {
            throw new IllegalStateException("Maitosäiliötä ei ole asennettu");
        }
    }
}
