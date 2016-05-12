
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
public class Tahtitaivas {
    
    private double tiheys;
    private int leveys;
    private int korkeus;
    private int tahtiaViimeTulostuksessa = 0;
    
    public Tahtitaivas(double tiheys) {
        this.tiheys = tiheys;
        this.leveys = 20;
        this.korkeus = 10;
    }
    
    public Tahtitaivas(int leveys, int korkeus) {
        this.tiheys = 0.1;
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    public Tahtitaivas(double tiheys, int leveys, int korkeus) {
        this.tiheys = tiheys;
        this.leveys = leveys;
        this.korkeus = korkeus;
    }
    
    public void tulostaRivi() {
        Random random = new Random();
        for (int i = 0; i < this.leveys; i++) {
            
            if(random.nextDouble() <= tiheys) {
                System.out.print("*");
                this.tahtiaViimeTulostuksessa++;
            } else {
                System.out.print(" ");
            }
        }
        System.out.println("");
    }
    
    
    public void tulosta() {
        for (int i = 0; i < this.korkeus; i++) {
            tulostaRivi();
        }
        
    }
    
    public int tahtiaViimeTulostuksessa() {
        int ret = this.tahtiaViimeTulostuksessa;
        this.tahtiaViimeTulostuksessa = 0;
        return ret;
    }
    
}
