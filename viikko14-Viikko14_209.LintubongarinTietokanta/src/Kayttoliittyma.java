
import java.util.Scanner;

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
    
    private Scanner lukija = new Scanner(System.in);
    
    private LintuTietokanta ltk;

    public Kayttoliittyma(LintuTietokanta ltk) {
        this.ltk = ltk;
    }
    
    public void kaynnista() {
        while(true) {
            System.out.print("? ");
            String komento = lukija.nextLine();
            if(komento.equals("Lisaa")) {
                ltk.lisaaLintu(new Lintu(this.kysy("Nimi:"), this.kysy("Latinankielinen nimi:")));
            }
            if(komento.equals("Havainto")) {
                boolean ok = ltk.lisaaHavainto(new Lintu(this.kysy("Nimi:"), ""));
                if(!ok) {
                    System.out.println("Ei ole lintu!");
                }
            }
            if(komento.equals("Tilasto")) {
                this.tulostaTilasto();
            }
            if(komento.equals("Nayta")) {               
                System.out.println(ltk.naytaLintu(new Lintu(this.kysy("Mikä?"), "")));
            }
            if(komento.equals("Lopeta")) {
                break;
            }
        }
    }
    
    public String kysy(String s) {
        System.out.print(s + " ");
        String k = lukija.nextLine();
        return k;
    }
    
    
    
    public void tulostaTilasto() {
        System.out.print(ltk.toString());
    }
    
}
