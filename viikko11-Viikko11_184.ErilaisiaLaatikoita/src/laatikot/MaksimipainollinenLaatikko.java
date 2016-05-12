/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

import java.util.ArrayList;

/**
 *
 * @author willehard
 */
public class MaksimipainollinenLaatikko extends Laatikko {

    private int maksimiPaino;
    private ArrayList<Tavara> tavarat = new ArrayList<>();

    public MaksimipainollinenLaatikko(int maksimiPaino) {
        this.maksimiPaino = maksimiPaino;
    }

    public int getPaino() {
        int p = 0;
        for (Tavara t : tavarat) {
            p += t.getPaino();
        }
        return p;
    }

    @Override
    public void lisaa(Tavara tavara) {
        if (tavara.getPaino() + this.getPaino() > this.maksimiPaino) {
            return;
        }
        this.tavarat.add(tavara);
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return tavarat.contains(tavara);
    }

}
