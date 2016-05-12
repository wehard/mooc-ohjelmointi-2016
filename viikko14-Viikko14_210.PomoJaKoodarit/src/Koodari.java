
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Koodari extends Tyontekija {

    public Koodari(String nimi, int palkka) {
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
        return 0;
    }

    @Override
    public void lisaaKieli(String kieli) {
        this.kielet.add(kieli);
    }

    @Override
    public boolean onkoTaitoa(String kieli) {
        for (String s : this.kielet) {
            if (s.equals(kieli)) {
                return true;
            }
        }
        return false;
    }

}
