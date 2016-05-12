/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package henkilosto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author willehard
 */
public class Tyontekijat {

    private List<Henkilo> henkilot = new ArrayList<>();

    public Tyontekijat() {
    }

    public void lisaa(Henkilo lisattava) {
        this.henkilot.add(lisattava);
    }

    public void lisaa(List<Henkilo> lisattavat) {
        this.henkilot.addAll(lisattavat);
    }

    public void tulosta() {
        Iterator<Henkilo> iteraattori = henkilot.iterator();

        while (iteraattori.hasNext()) {
            System.out.println(iteraattori.next());
        }

    }

    public void tulosta(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = henkilot.iterator();

        while (iteraattori.hasNext()) {
            Henkilo h = iteraattori.next();
            if(h.getKoulutus().equals(koulutus)) {
                System.out.println(h);
                
            }
        }
    }

    public void irtisano(Koulutus koulutus) {
        Iterator<Henkilo> iteraattori = henkilot.iterator();

        while (iteraattori.hasNext()) {
            if (iteraattori.next().getKoulutus().equals(koulutus)) {
                iteraattori.remove();
            }
        }
    }
}
