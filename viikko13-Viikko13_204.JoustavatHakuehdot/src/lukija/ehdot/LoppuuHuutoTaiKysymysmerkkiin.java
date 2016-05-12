/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lukija.ehdot;

/**
 *
 * @author willehard
 */
public class LoppuuHuutoTaiKysymysmerkkiin implements Ehto {

    @Override
    public boolean toteutuu(String rivi) {
        if(rivi.endsWith("!") || rivi.endsWith("?")) {
            return true;
        } else {
            return false;
        }
    }
    
}
