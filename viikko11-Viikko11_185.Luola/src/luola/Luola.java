/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luola;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author willehard
 */
public class Luola {

    private int leveys;
    private int korkeus;
    private int hirvioita;
    private int siirtoja;
    private boolean hirviotLiikkuvat;

    private Pelialue pelialue;

    private Hahmo pelaaja;
    private List<Hahmo> hirviot;

    private String[] suunnat = new String[]{"w", "a", "s", "d"};

    private boolean lopeta = false;

    public Luola(int leveys, int korkeus, int hirvioita, int siirtoja, boolean hirviotLiikkuvat) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.hirvioita = hirvioita;
        this.siirtoja = siirtoja;
        this.hirviotLiikkuvat = hirviotLiikkuvat;
        this.pelialue = new Pelialue(leveys, korkeus);
        this.hirviot = new ArrayList<>();
    }

    public void run(Scanner lukija) {

        this.luoHirviot();
        this.luoPelaaja();
        this.paivita();
        do {

            String komennot = lukija.nextLine();
            this.teeSiirto(komennot);
            this.paivita();
        } while (this.siirtoja > 0 && !this.hirviot.isEmpty());

        if (this.siirtoja == 0 && !this.hirviot.isEmpty()) {
            System.out.println("HÄVISIT");
        }
        if (this.siirtoja > 0 && this.hirviot.isEmpty()) {
            System.out.println("VOITIT");

        }

    }

    public void paivita() {

        this.pelialue.tyhjennaPelialue();
        // Hirviöt
        for (Hahmo h : this.hirviot) {
            pelialue.setPiste(h.getX(), h.getY(), h.kirjain);
        }
        //Pelaaja
        pelialue.setPiste(this.pelaaja.getX(), this.pelaaja.getY(), this.pelaaja.kirjain);

        this.tulostaPelinTiedot();
        this.pelialue.piirraPelialue();
    }

    public void teeSiirto(String komennot) {
        boolean siirtoOnnistui = false;
        for (char ch : komennot.toCharArray()) {

            switch (ch) {
                case 'w':
                    if (pelaaja.siirra("w")) {
                        siirtoOnnistui = true;
                    } else {
                        siirtoOnnistui = false;
                        continue;
                    }
                    break;
                case 'a':
                    if (pelaaja.siirra("a")) {
                        siirtoOnnistui = true;
                    } else {
                        siirtoOnnistui = false;
                        continue;
                    }
                    break;
                case 's':
                    if (pelaaja.siirra("s")) {
                        siirtoOnnistui = true;
                    } else {
                        siirtoOnnistui = false;
                        continue;
                    }
                    break;
                case 'd':
                    if (pelaaja.siirra("d")) {
                        siirtoOnnistui = true;
                    } else {
                        siirtoOnnistui = false;
                        continue;
                    }

                    break;
            }
            if (siirtoOnnistui) {
                // Tsekkaa  onko pelaaja hirvion paalla, jos on poista hirvio pelista
                for (int i = 0; i < this.hirviot.size(); i++) {
                    if (this.pelaaja.getX() == this.hirviot.get(i).getX() && this.pelaaja.getY() == this.hirviot.get(i).getY()) {
                        this.hirviot.remove(this.hirviot.get(i));

                    }
                }

            }
        }

        // Tsekkaa  onko pelaaja hirvion paalla, jos on poista hirvio pelista
        for (int i = 0; i < this.hirviot.size(); i++) {
            if (this.pelaaja.getX() == this.hirviot.get(i).getX() && this.pelaaja.getY() == this.hirviot.get(i).getY()) {
                this.hirviot.remove(this.hirviot.get(i));

            }
        }
        this.siirraHirviot();
        this.siirtoja--;
    }

    public void siirraHirviot() {
        if (!this.hirviotLiikkuvat) {
            return;
        }
        for (Hahmo h : this.hirviot) {
            Random rnd = new Random();
            int nx = rnd.nextInt(leveys - 1);
            int ny = rnd.nextInt(korkeus - 1);
            while (this.getPiste(nx, ny) != null) {
                nx = rnd.nextInt(leveys - 1);
                ny = rnd.nextInt(korkeus - 1);
            }
            h.setPaikka(nx, ny);
        }
    }

    public Hahmo getPiste(int x, int y) {
        for (Hahmo h : this.hirviot) {
            if (h.getX() == x && h.getY() == y) {
                return h;
            }
        }
        return null;
    }

    private void tulostaPelinTiedot() {
        // Monta siirtoa on jäljellä

        System.out.println(this.siirtoja);
        System.out.println("");
        System.out.println(this.pelaaja.toString());
        // Hirviöiden tiedot 
        for (Hahmo h : this.hirviot) {
            System.out.println(h.toString());
        }
        System.out.println("");
    }

    private void luoHirviot() {
        // Luo hirviot
        Random rnd = new Random();
        int counter = 0;
        while (counter < this.hirvioita) {
            int nx = rnd.nextInt(leveys);
            int ny = rnd.nextInt(korkeus);
            if (nx != 0 && ny != 0 && this.getPiste(nx, ny) == null) {
                Hahmo uusiHirvio = new Hirvio(nx, ny, this.pelialue);
                this.hirviot.add(uusiHirvio);
                counter++;
            }
        }
    }

    private void luoPelaaja() {
        this.pelaaja = new Pelaaja(0, 0, this.pelialue);
    }

}
