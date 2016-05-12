/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class YlhaaltaRajoitettuLaskuri {

    private int arvo;
    private int ylaraja;

    public YlhaaltaRajoitettuLaskuri(int ylarajanAlkuarvo) {
        // kirjoita koodia tähän
        this.ylaraja = ylarajanAlkuarvo;
        this.arvo = 0;
    }

    public void seuraava() {
        // kirjoita koodia tähän
        arvo++;
        if (arvo > ylaraja) {
            arvo = 0;
        }
    }

    public String toString() {
        // kirjoita koodia tähän
        return arvo < 10 ? "0" + arvo : "" + arvo;
    }

    public int arvo() {
        // kirjoita koodia tähän
        return arvo;
    }
    
    public void asetaArvo(int uusiArvo) {
        
        if(uusiArvo < 0 || uusiArvo > ylaraja) {
            return;
        }
        
        this.arvo = uusiArvo;
    }    
    
    

    

}
