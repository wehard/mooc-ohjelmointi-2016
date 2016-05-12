
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
public class Lastiruuma {
    
    private int maksimipaino;
    private int paino;
    private ArrayList<Matkalaukku> matkalaukut = new ArrayList<>();
    
    public Lastiruuma(int maksimipaino) {
        this.maksimipaino = maksimipaino;
    }
    
    public void lisaaMatkalaukku(Matkalaukku laukku) {
        if ((laukku.yhteispaino() + this.paino) <= this.maksimipaino) {
            this.matkalaukut.add(laukku);
            this.paino += laukku.yhteispaino();
        }
    }
    
    public void tulostaTavarat() {
        for(Matkalaukku m : this.matkalaukut) {
            m.tulostaTavarat();
        }
    }
    
    @Override
    public String toString() {
        if (this.matkalaukut.size() == 1) {
            return this.matkalaukut.size() + " matkalaukku (" + this.paino + " kg)";
        }
        if (this.matkalaukut.size() == 0) {
            return "ei matkalaukkuja (" + this.paino + " kg)";
        }
        
        
        return matkalaukut.size() + " matkalaukkua (" + this.paino + " kg)";
    }
}
