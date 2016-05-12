
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Lintu {
    
    private String nimi;
    private String latinaNimi;
    private int havainnot;

    public Lintu(String nimi, String latinaNimi) {
        this.nimi = nimi;
        this.latinaNimi = latinaNimi;
        this.havainnot = 0;
    }
    
    public void havaittu() {
        this.havainnot++;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.nimi);
        return hash;
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
        final Lintu other = (Lintu) obj;
        if (!Objects.equals(this.nimi, other.nimi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nimi + " (" + latinaNimi + ')' + " : " + this.havainnot + " havaintoa";
    }
    
    
    
}
