
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Tikkupeli {

    private Pelaaja pelaaja1;
    private Pelaaja pelaaja2;

    private Pelaaja lastPlayer = null;

    private int tikkujaAlussa;
    private int tikkuja;

    private boolean jatkuuko = false;

    public Tikkupeli() {

    }

    public void alusta(int tikkuja) {
        this.tikkujaAlussa = tikkuja;
        this.tikkuja = tikkuja;

    }

    private boolean aiTrainer = false;

    public void pelaa(Pelaaja p1, Pelaaja p2) {
        this.pelaaja1 = p1;
        this.pelaaja2 = p2;
        this.lastPlayer = null;
        while (true) {
            if (!aiTrainer) {
                System.out.println("Pöydällä on " + this.getTikkujenMaara() + " tikkua.");
            }
            if (this.lastPlayer == null || this.lastPlayer.equals(this.pelaaja2)) {
                this.pelaaja1.pelaa();
            } else {
                this.pelaaja2.pelaa();
            }
            
            if (this.getTikkujenMaara() <= 0) {
                break;
            }
        }
        if (this.lastPlayer.equals(p1)) {
            p1.setVoitto(false);
            p2.setVoitto(true);
        } else {
            p1.setVoitto(true);
            p2.setVoitto(false);
        }
        if (p1.getTyyppi() == PelaajaTyyppi.Tekoaly) {
            ((Tekoaly) p1).luoUudetHatut();
        }
        if (p2.getTyyppi() == PelaajaTyyppi.Tekoaly) {
            ((Tekoaly) p2).luoUudetHatut();
        }
        if (!aiTrainer) {
            System.out.println(this.lastPlayer.getNimi() + ", hävisit :/");
        }
    }

    public void setTekoalyHarjoittelu(boolean b) {
        this.aiTrainer = b;
    }

    public boolean onTekoalyHarjoittelu() {
        return this.aiTrainer;
    }

    public int getTikkujenMaara() {
        return this.tikkuja;
    }
    
    public int getTikkujaAlussa() {
        return this.tikkujaAlussa;
    }

    public void otaTikkuja(int montako) {
        if (montako < 0 || montako > 3) {
            System.out.println("Virhe: Väärä määrä!");
            return;
        }
        this.tikkuja -= montako;
    }

    public void setLastPlayer(Pelaaja p) {
        this.lastPlayer = p;
    }

    public boolean jatkuukoPeli() {
        return this.jatkuuko;
    }
}
