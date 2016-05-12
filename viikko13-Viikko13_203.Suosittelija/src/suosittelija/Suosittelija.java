/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import suosittelija.comparator.ElokuvaComparator;
import suosittelija.comparator.HenkiloComparator;
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;
import suosittelija.domain.Henkilo;

/**
 *
 * @author willehard
 */
public class Suosittelija {

    private ArvioRekisteri arvioRekisteri;

    public Suosittelija(ArvioRekisteri arvioRekisteri) {
        this.arvioRekisteri = arvioRekisteri;
    }

    public Elokuva suositteleElokuva(Henkilo henkilo) {

        // Om henkilo har sett alla filmer return null
        int montanahty = this.arvioRekisteri.annaHenkilonArviot(henkilo).keySet().size();
        if (montanahty == this.arvioRekisteri.elokuvienArviot().keySet().size()) {
            return null;
        }

        HashMap<Henkilo, Integer> samuukset = new HashMap<>();
        //samuukset.put(henkilo, Integer.MIN_VALUE); // Kolla att det här inte gör problem!
        for (Henkilo toinen : this.arvioRekisteri.arvioijat()) {
            if (!toinen.equals(henkilo)) {
                samuukset.put(toinen, this.laskeHenkiloidenSamuus(henkilo, toinen));
            }
        }

        Henkilo samanlaisinHenkilo = null;
        if (!samuukset.isEmpty()) {
            samanlaisinHenkilo = this.parasHenkilo(samuukset, henkilo);
        }

        if (arvioRekisteri.annaHenkilonArviot(henkilo).isEmpty()) {
            return suositteleElokuvaSimple(henkilo);
        } else {
            return suositteleElokuvaAdvanced(henkilo, samanlaisinHenkilo);
        }
    }

    public Elokuva suositteleElokuvaSimple(Henkilo henkilo) {
        Map<Elokuva, List<Arvio>> elokuvienArviot = arvioRekisteri.elokuvienArviot();

        List<Elokuva> elokuvat = new ArrayList<>();
        for (Elokuva e : arvioRekisteri.elokuvienArviot().keySet()) {
            elokuvat.add(e);
        }
        Collections.sort(elokuvat, new ElokuvaComparator(elokuvienArviot));
        return elokuvat.get(0);
    }

    public Elokuva suositteleElokuvaAdvanced(Henkilo henkilo, Henkilo parasHenkilo) {

        Map<Elokuva, Arvio> parhaanarviot;
        Elokuva parasElokuva = null;
        int parasarvosana = Integer.MIN_VALUE;
        if (parasHenkilo != null) {
            parhaanarviot = this.arvioRekisteri.annaHenkilonArviot(parasHenkilo);
            for (Elokuva e : parhaanarviot.keySet()) {
                if (parhaanarviot.get(e).getArvo() > parasarvosana && this.arvioRekisteri.haeArvio(henkilo, e) == Arvio.EI_NAHNYT) {
                    parasarvosana = parhaanarviot.get(e).getArvo();
                    parasElokuva = e;
                }
            }
        }
        return parasElokuva;
    }

    private Henkilo parasHenkilo(HashMap<Henkilo, Integer> samuukset, Henkilo kenelle) {
        if (samuukset == null || samuukset.isEmpty()) {
            return null;
        }

        HenkiloComparator hc = new HenkiloComparator(samuukset);
        List<Henkilo> ht = this.arvioRekisteri.arvioijat();
        ht.remove(kenelle);
        Collections.sort(ht, hc);

        if (samuukset.get(ht.get(0)) != 0) {
            return ht.get(0);
        } else {
            return null;
        }
    }

    private int laskeHenkiloidenSamuus(Henkilo henkilo, Henkilo toinen) {
        int samuusarvo = 0;
        Set<Elokuva> elokuvat = this.arvioRekisteri.elokuvienArviot().keySet();

        for (Elokuva e : elokuvat) {
            if (arvioRekisteri.haeArvio(toinen, e) != Arvio.EI_NAHNYT && arvioRekisteri.haeArvio(henkilo, e) != Arvio.EI_NAHNYT) {
                samuusarvo += this.arvioRekisteri.haeArvio(toinen, e).getArvo() * this.arvioRekisteri.haeArvio(henkilo, e).getArvo();
            }
        }
        return samuusarvo; //FIXME!! 
    }

}
