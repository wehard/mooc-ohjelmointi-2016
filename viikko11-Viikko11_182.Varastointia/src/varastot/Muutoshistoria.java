/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package varastot;

import java.util.ArrayList;

/**
 *
 * @author willehard
 */
public class Muutoshistoria {

    private ArrayList<Double> historia;

    public Muutoshistoria() {
        this.historia = new ArrayList<>();
    }

    public void lisaa(double tilanne) {
        this.historia.add(tilanne);
    }

    public void nollaa() {
        this.historia = new ArrayList<>();
    }

    public double maxArvo() {
        if (this.historia.isEmpty()) {
            return 0;
        }

        double arvo = Double.MIN_VALUE;
        for (Double d : this.historia) {
            if (d > arvo) {
                arvo = d;
            }
        }
        return arvo;
    }

    public double minArvo() {
        if (this.historia.isEmpty()) {
            return 0;
        }

        double arvo = Double.MAX_VALUE;
        for (Double d : this.historia) {
            if (d < arvo) {
                arvo = d;
            }
        }
        return arvo;
    }

    public double keskiarvo() {
        if (this.historia.isEmpty()) {
            return 0;
        }

        double arvo = 0;
        for (Double d : this.historia) {
            arvo += d;
        }
        return arvo / this.historia.size();
    }

    public double suurinMuutos() {
        if (this.historia.isEmpty() || this.historia.size() < 2) {
            return 0;
        }
        double muutos = 0;
        for (int i = 1; i < this.historia.size(); i++) {
            double ia = Math.abs(this.historia.get(i) - this.historia.get(i - 1));
            if (ia > muutos) {
                muutos = ia;
            }
        }

        return muutos;
    }

    public double varianssi() {
        if (this.historia.isEmpty() || this.historia.size() < 2) {
            return 0;
        }

        double varianssi = 0.0;

        for (Double luku : this.historia) {
            varianssi += Math.pow((double) luku - this.keskiarvo(), 2);
        }

        varianssi = varianssi / (this.historia.size() - 1);

        return varianssi;
    }

    @Override
    public String toString() {
        return this.historia.toString();
    }
}
