
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
public class Tekstikayttoliittyma {

    private Scanner lukija;
    private Sanakirja sanakirja;

    public Tekstikayttoliittyma(Scanner lukija, Sanakirja sanakirja) {
        this.lukija = lukija;
        this.sanakirja = sanakirja;
    }

    public void kaynnista() {
        System.out.println("Komennot: ");
        System.out.println("    lopeta - poistuu käyttöliittymästä");

        boolean lopeta = false;
        while (!lopeta) {
            System.out.println(" ");
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            switch (komento) {
                case "lopeta":
                    lopeta = true;
                    break;
                case "lisaa":
                    String[] sanat = kysySanat();
                    sanakirja.lisaa(sanat[0], sanat[1]);
                    break;
                case "kaanna":
                    System.out.print("Anna sana: ");
                    System.out.println("Käännös: " + sanakirja.kaanna(lukija.nextLine()));
                    break;
                default:
                    System.out.println("Tuntematon komento.");
                    break;
            }
        }
        System.out.println("Hei hei!");
    }

    private String[] kysySanat() {
        System.out.print("Suomeksi: ");
        String suomi = lukija.nextLine();
        System.out.print("Englanniksi: ");
        String englanti = lukija.nextLine();
        String[] sanat = new String[]{suomi, englanti};
        return sanat;
    }

   

}
