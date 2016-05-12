
import java.util.ArrayList;
import java.util.Collections;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Kasi implements Comparable<Kasi> {

    private ArrayList<Kortti> kortit = new ArrayList<>();

    public void lisaa(Kortti kortti) {
        kortit.add(kortti);
    }

    public void tulosta() {
        for (Kortti k : kortit) {
            System.out.println(k.toString());
        }
    }

    public void jarjesta() {
        Collections.sort(kortit);
    }

    public int getSumma() {
        int summa = 0;
        for (Kortti k : kortit) {
            summa += k.getArvo();
        }
        return summa;
    }

    public void jarjestaMaittain() {

        Collections.sort(kortit, new SamatMaatVierekkainArvojarjestykseen());
    }

    @Override
    public int compareTo(Kasi o) {
        return (this.getSumma() - o.getSumma());
    }

}
