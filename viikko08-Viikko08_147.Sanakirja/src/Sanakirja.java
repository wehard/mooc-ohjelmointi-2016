
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Sanakirja {
    
    private HashMap<String, String> sanat = new HashMap<>();
    
    public Sanakirja() {
        
    }
    
    public String kaanna(String sana) {
        if(sanat.containsKey(sana)) {
            return sanat.get(sana);
        }
        return null;
    }
    
    public void lisaa(String sana, String kaannos) {
        sanat.put(sana, kaannos);
    }
    
    
    public int sanojenLukumaara() {
        return sanat.size();
    }
    
    public ArrayList<String> kaannoksetListana() {
        ArrayList<String> lista = new ArrayList<>();
        for(Entry e : sanat.entrySet()) {
            lista.add(e.getKey() + " = " + e.getValue());
        }
        return lista;
    }
    
}
