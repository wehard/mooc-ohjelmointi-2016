/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.comparator;

import java.util.Comparator;
import java.util.Map;
import suosittelija.domain.Henkilo;

/**
 *
 * @author willehard
 */
public class HenkiloComparator implements Comparator<Henkilo> {

    private Map<Henkilo, Integer> henkiloidenSamuudet;

    public HenkiloComparator(Map<Henkilo, Integer> henkiloidenSamuudet) {
        this.henkiloidenSamuudet = henkiloidenSamuudet;
    }

    @Override
    public int compare(Henkilo o1, Henkilo o2) {
        return this.henkiloidenSamuudet.get(o2) - this.henkiloidenSamuudet.get(o1);
    }

}
