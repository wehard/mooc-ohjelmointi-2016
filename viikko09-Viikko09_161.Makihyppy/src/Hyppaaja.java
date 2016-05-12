
import java.util.ArrayList;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Hyppaaja implements Comparator<Hyppaaja> {

    private String nimi;
    private ArrayList<Hyppy> hypyt = new ArrayList<>();

    public Hyppaaja(String nimi) {
        this.nimi = nimi;
    }

    public void hyppaa() {
        this.hypyt.add(new Hyppy());
    }

    public int getPisteet() {
        int summa = 0;
        for (Hyppy h : hypyt) {
            summa += h.getPisteet();
        }
        return summa;
    }

    public int viimeisinPituus() {
        return hypyt.get(hypyt.size() - 1).getPituus();
    }

    public String viimeisimmatTuomariPisteet() {
        return hypyt.get(hypyt.size() - 1).getPisteetToString();
    }

    public String getHypytAsString() {
        String h = "";
        for (int i = 0; i < hypyt.size(); i++) {
            if (i != hypyt.size() - 1) {
                h += hypyt.get(i).getPituus() + "m, ";
            } else {
                h += hypyt.get(i).getPituus() + "m";
            }

        }
        return h;
    }

    public String getNimi() {
        return this.nimi;
    }

    @Override
    public int compare(Hyppaaja o1, Hyppaaja o2) {
        return (o1.getPisteet() - o2.getPisteet());
    }

    @Override
    public String toString() {
        return nimi + " (" + this.getPisteet() + " pistettä)";
    }

}
