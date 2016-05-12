/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Kirja implements Talletettava {
    
    private String kirjoittaja;
    private String nimi;
    private double paino;
    
    
    public Kirja(String kirjoittaja, String nimi, double paino) {
        this.kirjoittaja = kirjoittaja;
        this.nimi = nimi;
        this.paino = paino;
    }

    @Override
    public double paino() {
        return this.paino;
    }

    @Override
    public String toString() {
        return kirjoittaja + ": " + nimi;
    }
    
}
