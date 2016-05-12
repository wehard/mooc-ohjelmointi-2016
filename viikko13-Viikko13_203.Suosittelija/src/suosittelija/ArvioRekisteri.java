/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import suosittelija.domain.Arvio;
import suosittelija.domain.Elokuva;
import suosittelija.domain.Henkilo;

/**
 *
 * @author willehard
 */
public class ArvioRekisteri {

    private Map<Elokuva, List<Arvio>> elokuvaArviot = new HashMap<>();
    private Map<Henkilo, Map<Elokuva, Arvio>> henkiloArviot = new HashMap<>();

    public ArvioRekisteri() {
    }

    public void lisaaArvio(Elokuva elokuva, Arvio arvio) {
        if (this.elokuvaArviot.containsKey(elokuva)) {
            List<Arvio> arviot = this.elokuvaArviot.get(elokuva);
            arviot.add(arvio);
            this.elokuvaArviot.put(elokuva, arviot);
        } else {
            List<Arvio> arviot = new ArrayList<>();
            arviot.add(arvio);
            this.elokuvaArviot.put(elokuva, arviot);
        }
    }

    public void lisaaArvio(Henkilo henkilo, Elokuva elokuva, Arvio arvio) {
        this.lisaaArvio(elokuva, arvio);
        if (this.henkiloArviot.get(henkilo) == null) {
            HashMap<Elokuva, Arvio> uusi = new HashMap<>();
            this.henkiloArviot.put(henkilo, uusi);
            this.henkiloArviot.get(henkilo).put(elokuva, arvio);

        } else {
            this.henkiloArviot.get(henkilo).put(elokuva, arvio);
        }
    }

    public Arvio haeArvio(Henkilo henkilo, Elokuva elokuva) {

        if (this.annaHenkilonArviot(henkilo).get(elokuva) == null) {
            return Arvio.EI_NAHNYT;
        } else {
            return henkiloArviot.get(henkilo).get(elokuva);
        }

        /*
        if (this.henkiloArviot.get(henkilo) == null) {
            return null;
        }
        
        Map<Elokuva, Arvio> tamanArviot = this.henkiloArviot.get(henkilo);
        if (tamanArviot.get(elokuva) != null) {
            return tamanArviot.get(elokuva);
        } else {
            return Arvio.EI_NAHNYT;
        }
        */
    }

    public Map<Elokuva, Arvio> annaHenkilonArviot(Henkilo henkilo) {
        if (!this.henkiloArviot.containsKey(henkilo)) {
            return new HashMap<>();
        }
        if (this.henkiloArviot.get(henkilo).isEmpty()) {
            return new HashMap<Elokuva, Arvio>();
        } else {
            return this.henkiloArviot.get(henkilo);
        }

    }

    public List<Henkilo> arvioijat() {
        List<Henkilo> lista = new ArrayList<>();

        for (Entry e : this.henkiloArviot.entrySet()) {
            if (e.getValue() != null) {
                lista.add((Henkilo) e.getKey());
            }
        }
        return lista;
    }

    public List<Arvio> annaArviot(Elokuva elokuva) {
        return this.elokuvaArviot.get(elokuva);
    }

    public Map<Elokuva, List<Arvio>> elokuvienArviot() {
        return this.elokuvaArviot;
    }

}
