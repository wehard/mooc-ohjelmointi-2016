/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

import java.util.List;
import java.util.Random;

/**
 *
 * @author willehard
 */
public class Pelialue {

    private int leveys, korkeus;
    private char[] alue;

    public Pelialue(int leveys, int korkeus) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.alue = new char[leveys * korkeus];
    }

    public void piirraPelialue() {
        for (int y = 0; y < korkeus; y++) {
            for (int x = 0; x < leveys; x++) {
                int curPos = x + y * this.leveys;
                System.out.print(alue[curPos]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public void tyhjennaPelialue() {
        for (int i = 0; i < this.alue.length; i++) {
            this.alue[i] = '.';
        }
    }

    public int getLeveys() {
        return this.leveys;
    }

    public int getKorkeus() {
        return this.korkeus;
    }

    public char[] getAlue() {
        return this.alue;
    }

    public void setPiste(int x, int y, char c) {

        this.alue[x + y * this.leveys] = c;

    }

}
