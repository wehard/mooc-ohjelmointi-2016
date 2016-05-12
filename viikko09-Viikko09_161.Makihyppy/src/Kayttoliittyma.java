/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Kayttoliittyma {
    
    private Lukija lukija;
    
    public Kayttoliittyma() {
        lukija = new Lukija();
    }
    
    public void tulosta(String s) {
        System.out.print(s);
    }
    
    public void tulostaRivi(String s) {
        System.out.println(s);
    }
    
    public String kysy(String kysymys) {
        System.out.print(kysymys);
        String s = lukija.lueMerkkijono();
        return s;
    }
    
}
