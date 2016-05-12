/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.domain;



/**
 *
 * @author willehard
 */
public class Henkilo {

    private String nimi;

    public Henkilo(String nimi) {
        this.nimi = nimi;
    }

    public String getNimi() {
        return this.nimi;
    }

    @Override
    public String toString() {
        return this.nimi;
    }

    @Override
    public int hashCode() {
        return this.nimi.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Henkilo other = (Henkilo) obj;
        if ((this.nimi == null) ? (other.nimi != null) : !this.nimi.equals(other.nimi)) {
            return false;
        }
        return true;
    }

}
