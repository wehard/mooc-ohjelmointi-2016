
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
public class Matkalaukku {

    private int maksimipaino;
    private ArrayList<Tavara> tavarat = new ArrayList<>();
    private int paino = 0;

    public Matkalaukku(int maksimipaino) {
        this.maksimipaino = maksimipaino;
    }

    public void lisaaTavara(Tavara tavara) {
        if ((tavara.getPaino() + this.paino) <= this.maksimipaino) {
            this.tavarat.add(tavara);
            paino += tavara.getPaino();
        }
    }

    public void tulostaTavarat() {
        for (Tavara t : tavarat) {
            System.out.println(t.toString());
        }
    }

    public int yhteispaino() {
        return this.paino;
    }

    public Tavara raskainTavara() {
        int tpaino = Integer.MIN_VALUE;
        Tavara raskain = null;
        
        for (Tavara t : tavarat) {
            if (t.getPaino() > tpaino) {
                tpaino = t.getPaino();
                raskain = t;
            }
        }
        return raskain;
    }

    @Override
    public String toString() {
        if (this.tavarat.size() == 1) {
            return this.tavarat.size() + " tavara (" + this.paino + " kg)";
        }
        if (this.tavarat.size() == 0) {
            return "ei tavaroita (" + this.paino + " kg)";
        }
        return this.tavarat.size() + " tavaraa (" + this.paino + " kg)";
    }

}
