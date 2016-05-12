
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Joukkue {
    
    private String nimi;
    private ArrayList<Pelaaja> pelaajat = new ArrayList<>();
    private int maksimikoko;
    
    public Joukkue(String nimi) {
        this.nimi = nimi;
        this.maksimikoko = 16;
    }
    
    public String haeNimi() {
        return nimi;
    }
    
    public void lisaaPelaaja(Pelaaja pelaaja) {
        if(pelaajat.size() >= maksimikoko) {
            return;
        }
        pelaajat.add(pelaaja);
    }
    
    public void tulostaPelaajat() {
        for(Pelaaja pelaaja : pelaajat) {
            System.out.println(pelaaja.toString());
        }
    }
    
    public void asetaMaksimikoko(int maksimikoko) {
        this.maksimikoko = maksimikoko;
    }
    
    public int koko() {
        return pelaajat.size();
    }
    
    public int maalit() {
        int joukkoeenMaalit = 0;
        for(Pelaaja pelaaja : pelaajat) {
            joukkoeenMaalit += pelaaja.maalit();
        }
        return joukkoeenMaalit;
    }
    
}
