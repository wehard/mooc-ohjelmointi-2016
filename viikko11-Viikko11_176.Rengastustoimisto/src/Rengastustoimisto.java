
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Rengastustoimisto {
    
    private Map<Lintu, List<String>> havaintopaikat = new HashMap<>();
    
    
    
    public void havaitse(Lintu lintu, String paikka) {
        if(havaintopaikat.containsKey(lintu)) {
            List<String> l = havaintopaikat.get(lintu);
            l.add(paikka);
            havaintopaikat.put(lintu, l);
        } else {
            List<String> l = new ArrayList<>();
            l.add(paikka);
            havaintopaikat.put(lintu, l);
        }
    }
    
    public void havainnot(Lintu lintu) {
        if(havaintopaikat.containsKey(lintu)) {
            System.out.println(lintu.toString() + " havaintoja: " + havaintopaikat.get(lintu).size());
            for(String s : havaintopaikat.get(lintu)) {
                System.out.println(s);
            } 
        } else {
            System.out.println(lintu + " havaintoja: 0");
        }
    }
    
}
