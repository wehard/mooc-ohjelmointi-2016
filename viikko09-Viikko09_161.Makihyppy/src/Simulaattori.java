
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Simulaattori {

    private ArrayList<Hyppaaja> hyppaajat = new ArrayList<>();
    private Kayttoliittyma kayttoliittyma = new Kayttoliittyma();
    private int kierros = 0;
    
    public Simulaattori() {

    }

    public void kaynnista() {
        this.tulostaTervehdys();
        this.haeHyppaajat();
        this.tulostaTervehdys2();
        this.aloitaKilpailu();
        this.tulostaKilpailunTulokset();
    }

    private void haeHyppaajat() {
        do {
            String s = kayttoliittyma.kysy("  Osallistujan nimi: ");
            if(s.equals("")) {
                break;
            }
            this.lisaaHyppaaja(s);
        } while (true);
    }
    
    private void aloitaKilpailu() {
        boolean lopeta = false;
        do {
            String s = kayttoliittyma.kysy("Kirjoita \"hyppaa\" niin hypätään, muuten lopetetaan: ");
            switch(s) {
                default :
                    lopeta = true;
                    break;
                case "hyppaa" :
                    this.seuraavaKierros();
                    break;
                    
            }
        } while (!lopeta);
    }
    
    private void lisaaHyppaaja(String s) {
        Hyppaaja uusi = new Hyppaaja(s);
        hyppaajat.add(uusi);
    }
    
    private void seuraavaKierros() {
        kierros++;
        this.kayttoliittyma.tulostaRivi("");
        this.kayttoliittyma.tulostaRivi(kierros + ". kierros");
        this.kayttoliittyma.tulostaRivi("");
        this.kayttoliittyma.tulostaRivi("Hyppyjärjestys: ");
        Collections.sort(hyppaajat, new JarjestaHyppaajatPisteidenMukaan());
        
        int index = 1;
        for(Hyppaaja h : hyppaajat) {
            String s = index + ". " + h.toString();
            this.kayttoliittyma.tulostaRivi("  "+ s);
            index++;
        }
        this.kayttoliittyma.tulostaRivi("");
        
        for(Hyppaaja h : hyppaajat) {
            h.hyppaa();
        }
        
        this.tulostaKierroksenTulokset(kierros);
        
    }
    
    private void tulostaKierroksenTulokset(int kierros) {
        Collections.sort(hyppaajat, new JarjestaHyppaajatPisteidenMukaan());
        this.kayttoliittyma.tulostaRivi("Kierroksen " + kierros + " tulokset");
        for(Hyppaaja h : hyppaajat) {
            this.kayttoliittyma.tulostaRivi("  " + h.getNimi());
            this.kayttoliittyma.tulostaRivi("    pituus: " + h.viimeisinPituus());
            this.kayttoliittyma.tulostaRivi("    tuomaripisteet: " + h.viimeisimmatTuomariPisteet());
        }
        this.kayttoliittyma.tulostaRivi("");
    }
    
    private void tulostaKilpailunTulokset() {
        Collections.sort(hyppaajat, new JarjestaHyppaajatPisteidenMukaan());
        Collections.reverse(hyppaajat);
        this.kayttoliittyma.tulostaRivi("");
        this.kayttoliittyma.tulostaRivi("Kiitos!");
        this.kayttoliittyma.tulostaRivi("");
        this.kayttoliittyma.tulostaRivi("Kilpailun lopputulokset: ");
        this.kayttoliittyma.tulostaRivi("Sija    Nimi");
        int sija = 1;
        for(Hyppaaja h : hyppaajat) {
            this.kayttoliittyma.tulostaRivi(sija +  "       " + h.toString());
            this.kayttoliittyma.tulostaRivi(       "          hyppyjen pituudet: " +  h.getHypytAsString());
            sija++;
        }
    }

    
    private void tulostaTervehdys() {
        this.kayttoliittyma.tulostaRivi("Kumpulan mäkiviikot");
        this.kayttoliittyma.tulostaRivi("");
        this.kayttoliittyma.tulostaRivi("Syötä kilpailun osallistujat yksi kerrallaan, tyhjällä merkkijonolla siirtyy hyppyvaiheeseen.");
    }
    
    private void tulostaTervehdys2() {
        this.kayttoliittyma.tulostaRivi("");
        this.kayttoliittyma.tulostaRivi("Kilpailu alkaa!");
        this.kayttoliittyma.tulostaRivi("");
    }
}
