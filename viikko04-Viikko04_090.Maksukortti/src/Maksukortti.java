/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Maksukortti {

    private double saldo;

    public Maksukortti(double alkusaldo) {
        // kirjoita koodia tähän
        this.saldo = alkusaldo;
    }

    public String toString() {
        // kirjoita koodia tähän
        return "Kortilla on rahaa " + saldo + " euroa";
    }

    public void syoEdullisesti() {
        // kirjoita koodia tähän
        if (saldo - 2.50 < 0) {
            return;
        }

        saldo -= 2.50;
    }

    public void syoMaukkaasti() {
        // kirjoita koodia tähän

        if (saldo - 4.30 < 0) {
            return;
        }

        saldo -= 4.30;
    }

    public void lataaRahaa(double rahamaara) {
        // kirjoita koodia tähän
        
        if(rahamaara < 0) {
            return;
        }
        
        saldo += rahamaara;
        if(saldo > 150.0) {
            saldo = 150.0;
        }
    }

}
