
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Ajoneuvorekisteri {

    private HashMap<Rekisterinumero, String> omistajat;

    public Ajoneuvorekisteri() {
        omistajat = new HashMap<>();
    }

    public boolean lisaa(Rekisterinumero rekkari, String omistaja) {

        if (omistajat.containsKey(rekkari)) {
            return false;
        }

        omistajat.put(rekkari, omistaja);
        return true;
    }

    public String hae(Rekisterinumero rekkari) {
        if (omistajat.containsKey(rekkari)) {
            return omistajat.get(rekkari);
        }
        return null;
    }

    public boolean poista(Rekisterinumero rekkari) {
        if (omistajat.containsKey(rekkari)) {
            omistajat.remove(rekkari);
            return true;
        }

        return false;
    }

    public void tulostaRekisterinumerot() {
        for (Rekisterinumero r : omistajat.keySet()) {
            System.out.println(r.toString());
        }
    }

    public void tulostaOmistajat() {
        ArrayList<String> omistajalista = new ArrayList<String>();
        for (Rekisterinumero r : omistajat.keySet()) {
            if (!omistajalista.contains(omistajat.get(r))) {
                System.out.println(omistajat.get(r));
                omistajalista.add(omistajat.get(r));
            }
        }
    }

}
