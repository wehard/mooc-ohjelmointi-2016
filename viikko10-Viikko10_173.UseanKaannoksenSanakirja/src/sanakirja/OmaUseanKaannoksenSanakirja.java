/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanakirja;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author willehard
 */
public class OmaUseanKaannoksenSanakirja implements UseanKaannoksenSanakirja {

    private Map<String, Set<String>> sanat = new HashMap<>();

    public OmaUseanKaannoksenSanakirja() {

    }

    @Override
    public void lisaa(String sana, String kaannos) {
        if (!sanat.containsKey(sana)) {
            sanat.put(sana, new HashSet<>());

        }
        sanat.get(sana).add(kaannos);
    }

    @Override
    public Set<String> kaanna(String sana) {

        return sanat.get(sana);
    }

    @Override
    public void poista(String sana) {
        sanat.remove(sana);
    }

}
