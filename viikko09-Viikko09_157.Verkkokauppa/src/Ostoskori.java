
import java.util.HashMap;
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
public class Ostoskori {

    private Map<String, Ostos> ostokset;

    public Ostoskori() {
        this.ostokset = new HashMap<>();
    }

    public void lisaa(String tuote, int hinta) {
        if (ostokset.containsKey(tuote)) {
            ostokset.get(tuote).kasvataMaaraa();

        } else {
            ostokset.put(tuote, new Ostos(tuote, 1, hinta));
        }
    }

    public int hinta() {
        int ret = 0;
        for (Ostos o : ostokset.values()) {
            ret += o.hinta();
        }
        return ret;
    }

    public void tulosta() {
        for (Ostos o : ostokset.values()) {
            System.out.println(o.toString());
        }
    }

}
