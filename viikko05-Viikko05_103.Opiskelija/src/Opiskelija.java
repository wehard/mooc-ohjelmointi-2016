/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Opiskelija {
    
    private String nimi;
    private String opiskelijanumero;
    
    public Opiskelija(String nimi, String numero) {
        this.nimi = nimi;
        this.opiskelijanumero = numero;
    }
    
    public String haeNimi() {
        return this.nimi;
    }
    
    public String haeOpiskelijanumero() {
        return opiskelijanumero;
    }
    
    public String toString() {
        return nimi + " (" + opiskelijanumero + ")";
    }
    
}
