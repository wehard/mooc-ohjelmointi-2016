
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
public abstract class Tyontekija {

    protected String nimi;
    protected int palkka;
    
    protected List<String> kielet = new ArrayList<>();

    public Tyontekija(String nimi, int palkka) {
        this.nimi = nimi;
        this.palkka = palkka;
    }

    public abstract String haeNimi();

    public abstract int haePalkka();

    public abstract int laskeAlaiset();

    public abstract void lisaaKieli(String kieli);

    public abstract boolean onkoTaitoa(String kieli);

}
