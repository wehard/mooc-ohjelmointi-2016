
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
public class LintuTietokanta {

    private HashMap<Lintu, Integer> linnut;

    public LintuTietokanta() {
        linnut = new HashMap<>();
    }

    public void lisaaLintu(Lintu lintu) {
        if(!haeLintu(lintu)) {
            linnut.put(lintu, 0);
        }
    }

    public void lisaaHavainto(String nimi) {
        if(!haeLintu(nimi)) {
            System.out.println("Ei ole lintu!");
        } else {
            int h = linnut.get(haeLintuTietokannastaNimella(nimi));
            h++;
            linnut.put(haeLintuTietokannastaNimella(nimi), h);
        }
    }

    public void tulostaTilasto() {
        for (Lintu l : linnut.keySet()) {
            tulostaLintu(l);
        }
    }

    public void tulostaLintu(Lintu lintu) {
        if (haeLintu(lintu)) {
            System.out.println(lintu.getNimi() + " (" + lintu.getLatNimi() + "): " + linnut.get(lintu) + " havaintoa");
        } else {
            System.out.println("Lintu oli null!");
        }
    }
    
    
    public Lintu haeLintuTietokannastaNimella(String nimi) {
        for(Lintu l : linnut.keySet()) {
            if(l.getNimi().equals(nimi)) {
                return l;
            }
        }
        return null;
    }
    

    private boolean haeLintu(Lintu lintu) {
        
        if(linnut.containsKey(lintu)) {
            return true;
        }
        return false;
    }
    
    private boolean haeLintu(String nimi) {
        for(Entry<Lintu, Integer> entry : linnut.entrySet()) {
            if(entry.getKey().getNimi().equals(nimi)) {
                return true;
            } 
        }
        return false;
    }

}
