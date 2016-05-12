/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilosto;

/**
 *
 * @author willehard
 */
public class Henkilo {

    private String nimi;
    private Koulutus koulutus;

    public Henkilo(String nimi, Koulutus k) {
        this.nimi = nimi;
        this.koulutus = k;
    }

    public Koulutus getKoulutus() {
        return this.koulutus;
    }

    public String toString() {
        return this.nimi + ", " + this.koulutus;
    }

}
