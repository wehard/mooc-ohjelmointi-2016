
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public class Tekoaly implements Pelaaja {

    private PelaajaTyyppi tyyppi = PelaajaTyyppi.Tekoaly;
    private String nimi;
    
    private List<Hattu> hatut;
    private int[] ulkoPallot;

    private Tikkupeli tp;
    private Kayttoliittyma kl;

    private boolean voitto = false;
    
    public Tekoaly(String nimi, Tikkupeli tp, Kayttoliittyma kl) {
        this.nimi = nimi;
        this.tp = tp;
        this.kl = kl;
        this.ulkoPallot = new int[tp.getTikkujaAlussa()];
        this.hatut = new ArrayList<>();
        luoUudetHatut();
    }
    
    public void luoUudetHatut() {
        this.hatut = new ArrayList<>();
        for (int i = 0; i < tp.getTikkujaAlussa(); i++) {
            this.hatut.add(new Hattu());
        }
        if(voitto) {
            this.laitaUlkoPallotHattuihin();
        }
    }
    

    @Override
    public void pelaa() {
        Random rnd = new Random();
        int palloArvo = rnd.nextInt(4 - 1) + 1;
        if(palloArvo > tp.getTikkujenMaara()) {
            palloArvo = tp.getTikkujenMaara();
        }
        this.tp.otaTikkuja(palloArvo);
        //
        this.hatut.get(this.tp.getTikkujenMaara()).otaPallo(palloArvo-1);
        this.ulkoPallot[this.tp.getTikkujenMaara()] = palloArvo;     
        if(!this.tp.onTekoalyHarjoittelu()) {
            System.out.println("Tekoäly "+this.getNimi()+" valitsi " + palloArvo);
        }
        
        this.tp.setLastPlayer(this);
    }
    
    public void laitaUlkoPallotHattuihin() {
        for (int i = 0; i < this.hatut.size(); i++) {
            if(this.ulkoPallot[i] != 0) {
                this.hatut.get(i).laitaPallo(this.ulkoPallot[i]);
                
            }
        }
        this.voitto = false;
    }

    @Override
    public PelaajaTyyppi getTyyppi() {
        return this.tyyppi;
    }

    @Override
    public String getNimi() {
        return this.nimi;
    }

    @Override
    public void setVoitto(boolean b) {
        this.voitto = b;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tekoaly other = (Tekoaly) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        if (this.tyyppi != other.tyyppi) {
            return false;
        }
        return true;
    }

    
    
}
