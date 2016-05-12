
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Ostoslista {
    
    
    private HashMap<String, Integer> lista;
    
    
    public Ostoslista() {
        this.lista = new HashMap<>();
    }
    
    
    public void lisaa(String tuote) {
        if(lista.containsKey(tuote)) {
            lista.put(tuote, lista.get(tuote)+1);
        }
        else {
            lista.put(tuote, 1);
        }
    }
    
    public void poista(String tuote) {
        if(lista.containsKey(tuote) && !(lista.get(tuote) <= 0)) {
            lista.put(tuote, lista.get(tuote)-1);
            
        }
    }
    
    public int kappalemaara(String tuote) {
        
        if(!lista.containsKey(tuote)) {
            return 0;
        }
        return lista.get(tuote);
    }
}
