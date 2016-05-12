
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
public class Puhelinmuistio {
    
    private ArrayList<Henkilo> henkilot;
    
    public Puhelinmuistio() {
        this.henkilot = new ArrayList<>();
        
    }
    
    public void lisaa(String nimi, String numero) {
        henkilot.add(new Henkilo(nimi, numero));
    }
    
    public void tulostaKaikki() {
        for(Henkilo h : henkilot) {
            System.out.println(h.toString());
        }
    }
    
    
    public String haeNumero(String nimi) {
        for(Henkilo h : henkilot) {
            if(h.haeNimi().equals(nimi)) {
                return h.haeNumero();
            }
        }
        return "numero ei tiedossa";
    }
}
