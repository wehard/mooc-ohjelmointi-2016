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
    }

    public void seuraava() {
        // kirjoita koodia tähän
        arvo++;
        if (arvo > ylaraja) {
            arvo = 0;
        }
    }

    public int arvo() {
        // kirjoita koodia tähän
        return this.arvo;
    }
    
    public void asetaArvo(int arvo) {
        if(arvo < 0 || arvo > this.ylaraja) {
            return;
        }
        this.arvo = arvo;
    }

    @Override
    public String toString() {
        // kirjoita koodia tähän
        if (arvo < 10) {
            return "0" + arvo;
        }
        return "" + arvo;
    }
}
