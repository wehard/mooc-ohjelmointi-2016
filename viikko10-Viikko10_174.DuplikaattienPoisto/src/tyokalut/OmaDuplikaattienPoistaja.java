/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyokalut;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author willehard
 */
public class OmaDuplikaattienPoistaja implements DuplikaattienPoistaja {

    private HashSet<String> sanat = new HashSet<>();
    private int havaitutDuplikaatit = 0;

    @Override
    public void lisaa(String merkkijono) {
        if (!this.sanat.contains(merkkijono)) {
            this.sanat.add(merkkijono);
        } else {
            this.havaitutDuplikaatit++;
        }
    }

    @Override
    public int getHavaittujenDuplikaattienMaara() {
        return this.havaitutDuplikaatit;
    }

    @Override
    public Set<String> getUniikitMerkkijonot() {
        return this.sanat;
    }

    @Override
    public void tyhjenna() {
        this.sanat = new HashSet<String>();
        this.havaitutDuplikaatit = 0;
    }

}
