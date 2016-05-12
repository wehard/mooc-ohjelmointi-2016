/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Aani {
    
    private double taajuus;
    private double kesto;
    
    public Aani(double taajuus, double kesto) {
        this.taajuus = taajuus;
        this.kesto = kesto;
    }
    
    public double getTaajuus() {
        return taajuus;
    }
    
    public double getKesto() {
        return kesto;
    }
    
    
    public String toString() {
        String string = "" + taajuus + "Hz " + "(" + kesto + ")";
        return string;
    }
    
}
