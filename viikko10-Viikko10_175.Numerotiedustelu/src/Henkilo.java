
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Henkilo implements Comparable<Henkilo> {

    private String nimi;
    private List<String> puhelinNumerot = new ArrayList<>();
    private String[] osoite = new String[2];
    private String katu;
    private String kaupunki;

    public Henkilo(String nimi) {
        this.nimi = nimi;
        this.katu = "";
        this.kaupunki = "";
    }
    
    

    public void lisaaNumero(String numero) {
        this.puhelinNumerot.add(numero);
    }

    public void setOsoite(String katu, String kaupunki) {
        this.katu = katu;
        this.kaupunki = kaupunki;
    }

    public String getNimi() {
        return this.nimi;
    }

    public String getOsoite() {
        if (this.katu == "" && this.kaupunki == "") {
            return "osoite ei tiedossa";
        } else {
            return this.katu+ " " + this.kaupunki;
        }
    }

    public List<String> getNumerot() {
        if (this.puhelinNumerot.isEmpty()) {
            List<String> dummy = new ArrayList<>();
            dummy.add("ei puhelinta");
            return dummy;
        }
        return this.puhelinNumerot;
    }

    public boolean onkoNumero(String numero) {
        for (String s : this.puhelinNumerot) {
            if (s.equals(numero)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onkoNumeroFiltterilla(String filtteri) {
        for(String s : this.puhelinNumerot) {
            if(s.contains(filtteri)) {
                return true;
            }
        }
        return false;
    }

    public boolean onkoHenkilo(String nimi) {
        return this.nimi.equals(nimi);
    }

    

    
    
    @Override
    public int compareTo(Henkilo toinen) {
        return this.nimi.toLowerCase().compareTo(toinen.nimi.toLowerCase());
    }

}
