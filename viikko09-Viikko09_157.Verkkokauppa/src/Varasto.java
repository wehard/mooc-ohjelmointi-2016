
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author willehard
 */
public class Varasto {

    private Map<String, Integer> tuotteet;
    private Map<String, Integer> saldo;

    public Varasto() {
        this.tuotteet = new HashMap<>();
        this.saldo = new HashMap<>();
    }

    public void lisaaTuote(String tuote, int hinta, int saldo) {
        this.tuotteet.put(tuote, hinta);
        this.saldo.put(tuote, saldo);
    }

    public int hinta(String tuote) {
        if (tuotteet.containsKey(tuote)) {
            return tuotteet.get(tuote);
        }
        return -99;
    }
    
    public int saldo(String tuote) {
        if(saldo.containsKey(tuote)) {
            return saldo.get(tuote);
        }
        return 0;
    }
    
    public boolean ota(String tuote) {
        if(saldo.containsKey(tuote) && saldo.get(tuote) > 0) {
            saldo.put(tuote, saldo.get(tuote) - 1);
            return true;
        }
        return false;
    }
    
    public Set<String> tuotteet() {
        Set<String> lista = new HashSet<>();
        for(String s : this.tuotteet.keySet()) {
            lista.add(s);
        }
        return lista;
    }

}
