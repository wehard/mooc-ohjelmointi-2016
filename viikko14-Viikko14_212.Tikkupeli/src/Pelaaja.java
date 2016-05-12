/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public interface Pelaaja {
    
    public void pelaa();
    
    public PelaajaTyyppi getTyyppi();
    
    public String getNimi();
    
    public void setVoitto(boolean b);
    
    
}
