
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
public class Laatikko implements Talletettava {

    private double maksimipaino;
    

    private ArrayList<Talletettava> talletettavat = new ArrayList<>();

    public Laatikko(double maksimipaino) {
        this.maksimipaino = maksimipaino;
    }

    public void lisaa(Talletettava talletettava) {
        if (talletettava.paino() + this.paino() >= maksimipaino) {
            return;
        }
        talletettavat.add(talletettava);
    }
    
    @Override
    public double paino() {
        double paino = 0;
        for(Talletettava t : talletettavat) {
            paino+=t.paino();
        }
        return paino;
    }
    

    @Override
    public String toString() {
        return "Laatikko: " + talletettavat.size() + " esinettä, paino yhteensä " + this.paino() + " kiloa";
    }

}
