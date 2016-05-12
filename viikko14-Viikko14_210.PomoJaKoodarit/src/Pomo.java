
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Pomo extends Tyontekija {

    private List<Tyontekija> alaiset = new ArrayList<>();
    
    public Pomo(String nimi, int palkka) {
        super(nimi, palkka);
    }

    
    
    @Override
    public String haeNimi() {
        return this.nimi;
    }

    @Override
    public int haePalkka() {
        return this.palkka;
    }

    @Override
    public int laskeAlaiset() {
        int a = 0;
        for(Tyontekija t : this.alaiset) {
            a += t.laskeAlaiset();
        }
        a += this.alaiset.size();
        return a;
    }

    @Override
    public void lisaaKieli(String kieli) {
        this.kielet.add(kieli);
    }

    @Override
    public boolean onkoTaitoa(String kieli) {
        if(this.kielet.contains(kieli)) return true;
        for(Tyontekija t : this.alaiset) {
            if(t.onkoTaitoa(kieli)) {
                return true;
            }
        }
        return false;
    }
    
    public void lisaaAlainen(Tyontekija alainen) {
        this.alaiset.add(alainen);
    }
    
}
