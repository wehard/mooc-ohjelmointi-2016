/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatilasimulaattori;

/**
 *
 * @author willehard
 */
public class Maitosailio {

    private double tilavuus;
    private double saldo;

    public Maitosailio() {
        this.tilavuus = 2000.0;
    }

    public Maitosailio(double tilavuus) {
        this.tilavuus = tilavuus;
    }

    public double getTilavuus() {
        return this.tilavuus;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public double paljonkoTilaaJaljella() {
        return this.tilavuus - this.saldo;
    }
    
    public void lisaaSailioon(double maara) {
        if(maara < 0) {
            return;
        }
        if(this.saldo + maara > this.tilavuus) {
            this.saldo = this.tilavuus;
            return;
        }
        this.saldo+=maara;
    }
    
    public double otaSailiosta(double maara) {
        if(this.saldo - maara < 0) {
            double jaljella = maara - this.saldo;
            this.saldo = 0.0;
            return jaljella;
        }
        this.saldo -= maara;
        return maara;
    }

    @Override
    public String toString() {
        return Math.ceil(this.getSaldo()) + "/" + Math.ceil(this.getTilavuus());
    }
    
}
