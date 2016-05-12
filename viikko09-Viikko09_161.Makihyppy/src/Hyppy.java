
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Hyppy {

    private int pituus;
    private Integer[] pisteet = new Integer[5];

    public Hyppy() {
        Random rnd = new Random();
        this.pituus = 60 + rnd.nextInt(61);
        for (int i = 0; i < pisteet.length; i++) {
            pisteet[i] = 10 + rnd.nextInt(11);
        }
    }

    // Endast tre mellan poäng + längd
    public int getPisteet() {

        Arrays.sort(pisteet, new IntegerJarjestaja());
        int summa = 0;
        //System.out.println(pituus);
        for (int i = 1; i < pisteet.length - 1; i++) {
            summa += pisteet[i];
        }
        return summa + pituus;
    }
    
    public int getPituus() {
        return this.pituus;
    }

    public String getPisteetToString() {
        String s = "[";
        for (int i = 0; i < pisteet.length; i++) {
            if (i != pisteet.length - 1) {
                s += pisteet[i] + ", ";
            } else {
                s += pisteet[i] + "]";
            }
        }
        return s;
    }

}
