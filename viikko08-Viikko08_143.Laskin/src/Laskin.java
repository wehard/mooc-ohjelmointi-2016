/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author willehard
 */
public class Laskin {
    
    private Lukija lukija = new Lukija();
    private int kayttokerrat = 0;

    public void kaynnista() {
        while (true) {
            System.out.print("komento: ");
            String komento = lukija.lueMerkkijono();
            if (komento.equals("lopetus")) {
                break;
            }

            if (komento.equals("summa")) {
                summa();
            } else if (komento.equals("erotus")) {
                erotus();
            } else if (komento.equals("tulo")) {
                tulo();
            }
        }

        statistiikka();
    }
    
    private void summa() {
        System.out.print("luku1: ");
        int luku1 = lukija.lueKokonaisluku();
        System.out.print("luku2: ");
        int luku2 = lukija.lueKokonaisluku();
        System.out.println("lukujen summa " + (luku1 + luku2));
        kayttokerrat++;
        
    }
    
    private void erotus() {
        System.out.print("luku1: ");
        int luku1 = lukija.lueKokonaisluku();
        System.out.print("luku2: ");
        int luku2 = lukija.lueKokonaisluku();
        System.out.println("lukujen erotus " + (luku1 - luku2));
        kayttokerrat++;
    }
    
    private void tulo() {
        System.out.print("luku1: ");
        int luku1 = lukija.lueKokonaisluku();
        System.out.print("luku2: ");
        int luku2 = lukija.lueKokonaisluku();
        System.out.println("lukujen tulo " + (luku1 * luku2));
        kayttokerrat++;
    }
    
    private void statistiikka() {
        System.out.println("Laskuja laskettiin " + kayttokerrat);
    }

}
