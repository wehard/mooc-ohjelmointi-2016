
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Kirjasto {

    private ArrayList<Kirja> kirjat = new ArrayList<>();

    public Kirjasto() {

    }

    public void lisaaKirja(Kirja uusiKirja) {
        kirjat.add(uusiKirja);
    }

    public void tulostaKirjat() {
        for (Kirja k : kirjat) {
            System.out.println(k.toString());
        }

    }

    public ArrayList<Kirja> haeKirjaNimekkeella(String nimeke) {

        return haeKirja(nimeke);
    }

    public ArrayList<Kirja> haeKirjaJulkaisijalla(String julkaisija) {
        return haeKirja(julkaisija);
    }

    public ArrayList<Kirja> haeKirjaJulkaisuvuodella(int julkaisuvuosi) {
        return haeKirja(Integer.toString(julkaisuvuosi));
    }

    private ArrayList<Kirja> haeKirja(String hakusana) {
        ArrayList<Kirja> loydetyt = new ArrayList<>();
        for (Kirja k : kirjat) {
            if (StringUtils.sisaltaa(k.nimeke(), hakusana)) {
                loydetyt.add(k);
                continue;
            }
            if (StringUtils.sisaltaa(k.julkaisija(), hakusana)) {
                loydetyt.add(k);
                continue;
            }
            if (StringUtils.sisaltaa(Integer.toString(k.julkaisuvuosi()), hakusana)) {
                loydetyt.add(k);
                continue;
            }
        }
        return loydetyt;
    }

}
