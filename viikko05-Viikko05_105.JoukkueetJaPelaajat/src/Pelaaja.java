/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Pelaaja {

    private String nimi;
    private int maalit;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
    }
    
    public Pelaaja(String nimi, int maalit) {
        this.nimi = nimi;
        this.maalit = maalit;
    }
    
    public String haeNimi() {
        return nimi;
    }
    
    public int maalit() {
        return maalit;
    }
    
    public String toString() {
        return nimi + ", maaleja " + maalit;
    }
}
