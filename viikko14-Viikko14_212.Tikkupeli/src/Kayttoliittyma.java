
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
public class Kayttoliittyma {

    private Scanner lukija;
    private Tikkupeli tp;

    public Kayttoliittyma(Tikkupeli tp) {
        this.lukija = new Scanner(System.in);
        this.tp = tp;
    }

    public void kaynnista() {
        System.out.println("Tervetuloa tikkupeliin!");
        int luku = this.kysyLukuaValilta("Kuinka monta tikkua pöydällä on aluksi (10-100)? ", 10, 100);
        tp.alusta(luku);
        System.out.println("Vaihtoehdot:");
        System.out.println("  Pelaa kaveria vastaan (1)");
        System.out.println("  Pelaa tietokonetta vastaan (2)");
        System.out.println("  Pelaa kouliintunutta tietokonetta vastaan (3)");
        int valinta = this.kysyLukuaValilta("Minkä vaihtoehdon valitset (1-3)? ", 1, 3);
        Pelaaja p1 = null, p2 = null;
        if (valinta == 1) {
            p1 = new Ihminen("Pelaaja 1", this.tp, this);
            p2 = new Ihminen("Pelaaja 2", this.tp, this);
        }
        if (valinta == 2) {
            p1 = new Ihminen("Ihminen", this.tp, this);
            p2 = new Tekoaly("386", this.tp, this);
        }
        if (valinta == 3) {
            p1 = new Tekoaly("Zardoz", this.tp, this);
            p2 = new Tekoaly("Beeblebrox", this.tp, this);
            for (int i = 0; i < 100000; i++) {
                tp.alusta(luku);
                tp.setTekoalyHarjoittelu(true);
                tp.pelaa(p1, p2);
                
            }
            tp.setTekoalyHarjoittelu(false);
            p1 = new Ihminen("Pelaaja 1", this.tp, this);
        }
        tp.setTekoalyHarjoittelu(false);

        while (!lopeta) {
            tp.alusta(luku);
            tp.pelaa(p1, p2);
            System.out.println("");
            int komento = this.kysyLukuaValilta("Pelaa uudestaan (1 = kyllä, 0 = ei)? ", 0, 1);
            System.out.println("");
            lopeta = komento == 0;
        }
        System.out.println("Kiitos!");

    }

    private boolean lopeta;

    public void tulosta(String merkkijono) {
        System.out.println(merkkijono);
    }

    public int kysyLukuaValilta(String kysymys, int min, int max) {

        int i = Integer.MIN_VALUE;
        while (true) {
            System.out.print(kysymys);
            if (lukija.hasNextInt()) {
                i = lukija.nextInt();
                if (i >= min && i <= max) {
                    break;
                } else {
                    System.out.println("Valitse luku väliltä " + min + "-" + max);
                }
            } else {
                System.out.println("Valitse luku väliltä " + min + "-" + max);
                lukija.next();
            }
        }
        return i;
    }

}
