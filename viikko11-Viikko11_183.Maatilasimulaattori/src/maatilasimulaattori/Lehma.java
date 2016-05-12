/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maatilasimulaattori;

import java.util.Random;

/**
 *
 * @author willehard
 */
public class Lehma implements Lypsava, Eleleva {

    private String nimi;
    private double tilavuus;
    private double maara = 0;

    private static final String[] NIMIA = new String[]{
        "Anu", "Arpa", "Essi", "Heluna", "Hely",
        "Hento", "Hilke", "Hilsu", "Hymy", "Matti", "Ilme", "Ilo",
        "Jaana", "Jami", "Jatta", "Laku", "Liekki",
        "Mainikki", "Mella", "Mimmi", "Naatti",
        "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
        "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Lehma() {
        this.nimi = NIMIA[new Random().nextInt(NIMIA.length)];
        this.tilavuus = 15.0 + new Random().nextInt(26);
    }

    public Lehma(String nimi) {
        this.nimi = nimi;
        this.tilavuus = 15.0 + new Random().nextInt(26);
    }

    public String getNimi() {
        return this.nimi;
    }

    public double getTilavuus() {
        return this.tilavuus;
    }

    public double getMaara() {
        return this.maara;
    }

    @Override
    public String toString() {
        return this.getNimi() + " " + Math.ceil(this.getMaara()) + "/" + Math.ceil(this.getTilavuus());

    }

    @Override
    public double lypsa() {
        double tmp = this.getMaara();
        this.maara = 0.0;
        return tmp;
    }

    @Override
    public void eleleTunti() {
        this.maara += 0.7 + (1.0 - 0.7) * new Random().nextDouble();
        if (this.getMaara() > this.getTilavuus()) {
            this.maara = this.tilavuus;
        }
    }
}
