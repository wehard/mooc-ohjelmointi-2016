/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Lento {
    private Lentokone lentokone;
    private String lahtopaikka;
    private String kohdepaikka;
    
    public Lento(Lentokone lentokone, String lahtopaikka, String kohdepaikka) {
        this.lentokone = lentokone;
        this.lahtopaikka = lahtopaikka;
        this.kohdepaikka = kohdepaikka;
    }
    
    public String toString() {
        return lentokone.toString() + " (" + lahtopaikka + "-" + kohdepaikka + ")";
    }
}
